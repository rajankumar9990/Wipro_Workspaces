//`IAlterSuiteListener` is a TestNG interface that lets you dynamically modify the test suite (`XmlSuite`) before execution.

package com.selenium_testng.day30;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.util.ArrayList;
import java.util.List;

public class IAlterSuiteListener_2 implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        System.out.println("Inside alter() - modifying suite programmatically");

        // Take the first suite
        XmlSuite suite = suites.get(0);

        // Create a new test
        XmlTest test = new XmlTest(suite);
        test.setName("DynamicTestAddedByListener");

        // Add class dynamically
        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("com.selenium_testng.day30.Listener_Test_Class_2")); 
        test.setXmlClasses(classes);
    }
}
