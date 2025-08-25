package com.selenium_testng.day30;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.selenium_testng.day30.IReporter_4.class)
public class Listener_Test_Class_4 {
	 @Test
	    public void testOne() {
	        System.out.println("Running testOne");
	    }

	    @Test
	    public void testTwo() {
	        System.out.println("Running testTwo");
	    }

}
