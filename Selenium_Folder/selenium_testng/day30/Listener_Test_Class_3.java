package com.selenium_testng.day30;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.selenium_testng.day30.IAnnotationTransformer_3.class)
public class Listener_Test_Class_3 {
	 @Test
	    public void testA() {
	        System.out.println("Running testA");
	    }

	    @Test
	    public void testB() {
	        System.out.println("Running testB");
	    }
}
