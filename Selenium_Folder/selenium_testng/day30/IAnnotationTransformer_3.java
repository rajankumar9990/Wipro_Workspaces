//
package com.selenium_testng.day30;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class IAnnotationTransformer_3 implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// Just print which test is being transformed
		System.out.println("Transforming test: " + testMethod.getName());

		// Example: set all tests to priority 1
		annotation.setPriority(1);
	}

}
