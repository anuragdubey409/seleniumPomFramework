package com.google.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.utils.AssertionType;
import com.google.utils.DriverHelper;

public class DashBoardPage extends DriverHelper {

	@FindBy(xpath = "//div[@class='desktop-nav-left-container']//ul[@class='primary-links']/li/following-sibling::li")
	private List<WebElement> menuLength;

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}

	public void verifyTheDashboardPageTitle(String title) {
		String windowTitle = getPageTitle(title);
		AssertionType.validateOnEqual(windowTitle, title);
	}

	public <T> T navigateToMenu(String menuTitle,String subMenu, Class<T> className) throws Exception {
		for(WebElement element:menuLength) {
			WebElement menuLocator=element.findElement(By.xpath("./child::a"));
			String menuText=menuLocator.getText();
			if(StringUtils.containsIgnoreCase(menuTitle, menuText)) {
				click(element);
			}
			WebElement subMenuItem=element.findElement(By.xpath(".//div[contains(text(),'"+subMenu+"')]/parent::a"));
			click(subMenuItem);
 		}
		return PageFactory.initElements(driver, className);
	}

	public void navigateToSubMenu(String menuItem) {
		
	}
}