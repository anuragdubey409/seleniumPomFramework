package com.google.testScript;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.pages.DashBoardPage;
import com.google.pages.DealsPage;
import com.google.utils.Constants;
import com.google.utils.DriverTestCase;
import com.google.utils.GlobalDataProvider;

public class LoginToTheApplication extends DriverTestCase {

	@BeforeClass
	public void getData() throws Exception {
		data = new HashMap<Object, List<Object>>();
		dataProvider = new GlobalDataProvider(Constants.testDataFileName);
		data=GlobalDataProvider.getData("");
	}

	@Test
	public void testLoginToTheApplication() {
		try {
			// login to the application
			dashBoardPage = loginToTheApplication(DashBoardPage.class);
			
			//Verify the title of the page
			dashBoardPage.verifyTheDashboardPageTitle("Account Setup | HubSpot");
			
			//Select the menu item from the menu bar list
			dashBoardPage.navigateToMenu("Sales","Deals" ,DealsPage.class);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
