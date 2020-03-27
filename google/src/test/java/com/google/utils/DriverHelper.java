package com.google.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DriverHelper {
	protected WebDriver driver;
	private JavaScriptExecutor jsOps;
	private SynchronizedWaits wait;
	protected String attributeValue;

	public DriverHelper(WebDriver driver) {
		this.driver = driver;
		wait = new SynchronizedWaits(driver);
		jsOps = new JavaScriptExecutor(driver);
	}

	public static By byLocator(String element) {
		By locator = null;
		if (element.startsWith("//")) {
			locator = By.xpath(element);
		} else if (element.startsWith("css=")) {
			locator = By.cssSelector(element.replace("css=", ""));
		} else if (element.startsWith(".")) {
			element.replace(".", "");
			locator = By.className(element);
		} else if (element.startsWith("#")) {
			element.replace("#", "");
			locator = By.id(element);
		}
		return locator;
	}

	/**
	 * Get webElement by passing locator as String
	 * 
	 * @param locator
	 * @return WebElement Of Passed String
	 */
	public WebElement getWebElement(String locator) {
		return driver.findElement(byLocator(locator));
	}

	/**
	 * click on the webElement if not clickable try with js click
	 * 
	 * @param element
	 * @throws Exception
	 */
	public void click(WebElement element) throws Exception {
		try {
			wait.waitForTheElementToBeClickable(element);
			element.click();
		} catch (Exception e) {
			if (element.equals(null)) {
				throw new Exception("element is not initialized");
			} else {
				jsOps.clickUsingJavaScript(element);
			}
		}
	}

	/**
	 * click on webElement :- Can pass locator as String
	 * 
	 * @param element
	 * @throws Exception
	 */
	public void click(String element) throws Exception {
		click(getWebElement(element));
	}

	/**
	 * Set Text Using selenium send keys if not try js setText
	 * 
	 * @param element
	 * @param keysToSend
	 * @throws Exception
	 */
	public void setText(WebElement element, String keysToSend) throws Exception {
		wait.waitForTheElementToBeVisible(element);
		try {
			element.sendKeys(keysToSend);
		} catch (Exception e) {
			if (element.equals(null)) {
				throw new Exception("element not instantiated");
			} else {
				jsOps.setTextUsingJavaScript(element, keysToSend);
			}
		}
	}

	/**
	 * Set text the locator can be passed as String
	 * 
	 * @param locator
	 * @param keysToSend
	 * @throws Exception
	 */
	public void setText(String locator, String keysToSend) throws Exception {
		setText(getWebElement(locator), keysToSend);
	}

	/**
	 * Get the title of the page
	 * 
	 * @return pageTitle
	 */
	public String getPageTitle(String title) {
		wait.waitForTheTitleContains(title);
		return driver.getTitle();
	}

	/**
	 * Get the attribute value name
	 * 
	 * @param element
	 * @param attributeName
	 * @return
	 */
	public String getAttributeOfWebElement(WebElement element, String attributeName) {
		wait.waitForTheElementToBeVisible(element);
		return element.getAttribute(attributeName);
	}

	/**
	 * Get the attribute value of String locator
	 * 
	 * @param element
	 * @param attributeName
	 * @return
	 */
	public String getAttributeOfWebElement(String element, String attributeName) {
		attributeValue = getAttributeOfWebElement(getWebElement(element), attributeName);
		return attributeValue;
	}

	/**
	 * Get the text of Web Element
	 * 
	 * @param element
	 * @return
	 */
	public String getTextOfWebElement(WebElement element) {
		wait.waitForTheElementToBeClickable(element);
		return element.getText();
	}

	/**
	 * a get Length of WebElement
	 * 
	 * @param element
	 * @return size of WebEleme
	 */
	public int getLengthOfTheWebElement(List<WebElement> element) {
		return element.size();
	}

}
