//IReporter is used in TestNG to create custom reports after all tests finish running.
package com.selenium_testng.day30;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import java.util.List;

public class IReporter_4 implements IReporter{
	@Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println(">>> Custom Report Execution <<<");

        for (ISuite suite : suites) {
            System.out.println("Suite Name: " + suite.getName());
            System.out.println("Total Tests Run: " + suite.getResults().size());
        }

        System.out.println(">>> Report Finished <<<");
    }

}
