package com.google.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {

	private JavascriptExecutor jse;
	private WebDriver driver;

	public JavaScriptExecutor(WebDriver driver) {
		this.driver = driver;
	}

	public JavascriptExecutor getJavaScriptExecutor() {
		return (JavascriptExecutor) this.getDriver();
	}

	private WebDriver getDriver() {
		return driver;
	}

	public Object executeScript(String script, WebElement element) {
		Object obj = getJavaScriptExecutor().executeScript(script, element);
		return obj;
	}

	public Object execute(String script) {
		Object obj = getJavaScriptExecutor().executeScript(script);
		return obj;
	}

	public void clickUsingJavaScript(WebElement element) {
		getJavaScriptExecutor().executeScript("arguments[0].click();", element);
	}
	
	public void setTextUsingJavaScript(WebElement element,String keysToSend) {
		getJavaScriptExecutor().executeScript("arguments[0].setAttribute('value','"+keysToSend+"')", element);
	}

}
