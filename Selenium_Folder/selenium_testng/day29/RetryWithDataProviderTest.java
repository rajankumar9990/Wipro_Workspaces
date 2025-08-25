package com.selenium_testng.day29;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.Assert;

public class RetryWithDataProviderTest {
	@DataProvider(name = "data")
	public Object[][] getData() {
		return new Object[][] { { "Value1" }, { "Value2" }, { "Value3" } };
	}

	@Test(dataProvider = "data", retryAnalyzer = RetryAnalyzer.class)
	public void testWithData(String input) {
		System.out.println("Running test with input: " + input);
		Assert.assertTrue(input.contains("2"), "only value2 should pass");
	}
}
