package com.selenium_testng.day30;

import org.testng.IConfigurable;
import org.testng.IConfigureCallBack;
import org.testng.ITestResult;

public class IConfigurable_6 implements IConfigurable {

	@Override
	public void run(IConfigureCallBack callBack, ITestResult testResult) {
		System.out.println("Before running config method: " + testResult.getMethod().getMethodName());

		try {
			// Execute the actual config method
			callBack.runConfigurationMethod(testResult);
		} catch (Throwable t) {
			System.out.println("Exception in config method: " + t.getMessage());
		}

		System.out.println("After running config method: " + testResult.getMethod().getMethodName());
	}
}
