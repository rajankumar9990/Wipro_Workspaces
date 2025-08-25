package com.selenium_testng.day30;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.selenium_testng.day30.ITestListener_1.class)
public class Listener_Test_Class_1 {

	@Test
	public void testPass() {
		Assert.assertTrue(true);
	}

	@Test
	public void testFail() {
		Assert.fail("Intentional Failure");
	}

}
