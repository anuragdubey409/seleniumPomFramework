package com.google.utils;

import org.testng.Assert;

public class AssertionType {

	/**
	 * Validate on Equal
	 * 
	 * @param actual
	 * @param expected
	 */
	public static void validateOnEqual(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	/**
	 * Validate the condition on True value
	 * 
	 * @param condition
	 */
	public static void validateOnTrue(boolean condition) {
		Assert.assertTrue(condition);
	}

	/**
	 * Validate the condition on False value
	 */
	public static void validateOnFalse(boolean condition) {
		Assert.assertFalse(condition);
	}

}
