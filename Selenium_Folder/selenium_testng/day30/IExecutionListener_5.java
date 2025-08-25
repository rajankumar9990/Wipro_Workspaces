package com.selenium_testng.day30;

import org.testng.IExecutionListener;

public class IExecutionListener_5 implements IExecutionListener{
	@Override
    public void onExecutionStart() {
        System.out.println(">>> TestNG Execution Started <<<");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println(">>> TestNG Execution Finished <<<");
    }

}
