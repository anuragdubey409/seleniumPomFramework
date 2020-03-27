package com.google.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	private static Properties prop;
	private FileReader reader;
	private static String value;

	public PropertyReader(String fileName) throws IOException {
		prop = new Properties();
		reader = new FileReader(getProjectPath() + "/" + fileName);
		prop.load(reader);
	}

	public static String getProperty(String key) {
		value = prop.getProperty(key);
		return value;
	}

	public static void setProperty() {

	}

	public static String getProjectPath() {
		File f = new File("");
		return f.getAbsolutePath().replaceAll("\\\\", "/");
	}
}
