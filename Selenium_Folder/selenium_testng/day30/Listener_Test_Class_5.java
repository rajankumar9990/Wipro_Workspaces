/*IExecutionListener is a TestNG listener interface that allows you to perform actions before the entire test suite starts and after the entire test suite finishes.
It has two methods:

onExecutionStart() → Executes before any test starts.

onExecutionFinish() → Executes after all tests finish.*/
package com.selenium_testng.day30;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.selenium_testng.day30.IExecutionListener_5.class)
public class Listener_Test_Class_5 {
	@Test
	public void testOne() {
		System.out.println("Running Test One");
		Assert.assertTrue(true);
	}

	@Test
	public void testTwo() {
		System.out.println("Running Test Two");
		Assert.assertTrue(true);
	}
}
