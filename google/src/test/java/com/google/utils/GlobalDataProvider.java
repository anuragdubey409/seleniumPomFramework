package com.google.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GlobalDataProvider {

	private FileInputStream input;
	private XSSFWorkbook book;
	private XSSFSheet sheet;
	private Cell cell;
	private static List<Object> data;
	private static Map<Object, List<Object>> setValue;

	public GlobalDataProvider(String fileName) throws FileNotFoundException {
		input = new FileInputStream(new File(PropertyReader.getProjectPath() + fileName));
	}

	private Object getData(int z) throws IOException {
		data = new ArrayList<Object>();
		sheet = book.getSheetAt(0);
		Row row = sheet.getRow(z);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);
			switch (cell.getCellType()) {
			case STRING:
				data.add(cell.getStringCellValue());
				break;
			case NUMERIC:
				data.add(cell.getNumericCellValue());
				break;
			default:
				data.add(cell.getErrorCellValue());
				break;
			}
		}
		return data;
	}

	/**
	 * Get the row number of passed parameter
	 * 
	 * @param match
	 * @return the row number on which the passed String is matched
	 * @throws Exception
	 */
	private Integer getRowNumberOfCorrespondingValue(Object match) throws Exception {
		int matchingRowNumber = 0;
		book = new XSSFWorkbook(input);
		sheet = book.getSheetAt(0);
		for (Row row : sheet) {
			if (matchingRowNumber > 0) {
				break;
			}
			cell = row.getCell(0);
			switch (cell.getCellType()) {
			case STRING:
				String matching = (String) match;
				if (StringUtils.containsIgnoreCase(cell.getStringCellValue(), matching)) {
					matchingRowNumber = row.getRowNum();
				}
				break;
			case NUMERIC:
				int matchingInt = Integer.parseInt((String) match);
				if (cell.getNumericCellValue() == matchingInt) {
					matchingRowNumber = row.getRowNum();
				}
				break;
			default:
				break;
			}
		}
		return matchingRowNumber;
	}

	public static Map<Object, List<Object>> getData(Object key) throws Exception {
		{
			setValue = new HashMap<Object, List<Object>>();
			GlobalDataProvider gp = new GlobalDataProvider(Constants.testDataFileName);
			int rowNumber = gp.getRowNumberOfCorrespondingValue(key);
			gp.getData(rowNumber);
			setValue.put(key, data);
		}
		return setValue;
	}
}
