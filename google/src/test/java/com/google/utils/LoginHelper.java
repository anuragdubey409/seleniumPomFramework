package com.google.utils;

import org.openqa.selenium.WebDriver;

public class LoginHelper {
	private DriverHelper driverHelper;
	private WebDriver driver;

	public LoginHelper(WebDriver driver) {
		this.driver = driver;
		driverHelper = new DriverHelper(driver);
	}

	String username = "css=input[type='email']";

	String password = "css=input[type='password']";

	String loginButton = "css=button[id='loginBtn']";

	public void setUserName(String userName) throws Exception {
		driverHelper.setText(username, userName);
	}

	public void setPassword(String password) throws Exception {
		driverHelper.setText(this.password, password);
	}

	public void clickOnLoginButton() throws Exception {
		driverHelper.click(loginButton);
	}
}
