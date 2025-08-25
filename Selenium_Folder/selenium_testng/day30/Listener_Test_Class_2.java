package com.selenium_testng.day30;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.selenium_testng.day30.IAlterSuiteListener_2.class)
public class Listener_Test_Class_2 {

	public class TestClassOne {

		@Test
		public void testMethodOne() {
			System.out.println("Executing TestClassOne.testMethodOne");
		}

		@Test
		public void testMethodTwo() {
			System.out.println("Executing TestClassOne.testMethodTwo");
		}
	}
}
