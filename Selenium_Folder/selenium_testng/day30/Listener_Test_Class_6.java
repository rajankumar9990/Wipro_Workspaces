/*IConfigurable is a TestNG listener interface that lets you take control of how configuration methods (@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod, etc.) are invoked.

It contains one method:

void run(IConfigureCallBack callBack, ITestResult testResult);*/
package com.selenium_testng.day30;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.selenium_testng.day30.IConfigurable_6.class)
public class Listener_Test_Class_6 {
	@BeforeClass
	public void setup() {
		System.out.println(">>> Inside @BeforeClass setup <<<");
	}

	@Test
	public void testOne() {
		System.out.println("Running Test One");
	}

	@Test
	public void testTwo() {
		System.out.println("Running Test Two");
	}
}
