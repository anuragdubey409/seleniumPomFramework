package com.google.utils;

public class BrowserType {

	private Browser browser;

	public enum Browser {
		Chrome, IE, Firefox
	};

		public void setBrowser(Browser browser) {
			this.browser = browser;
		}

		public Browser getBrowser() {
			return browser;
		}
}
