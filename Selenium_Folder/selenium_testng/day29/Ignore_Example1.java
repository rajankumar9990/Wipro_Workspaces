package com.selenium_testng.day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Ignore_Example1 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("Launching browser...");
        driver = new ChromeDriver();  // chromedriver must be installed
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void openBrowser() {
        driver.get("https://www.amazon.in/");
        System.out.println("Opened Amazon");
    }

    @Test(dependsOnMethods = "openBrowser")
    public void searchProduct() {
        System.out.println("Searching product...");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();
        //Assert.fail("Failed");
    }
@Ignore
    @Test(dependsOnMethods = "searchProduct", alwaysRun=true)
    public void logout() {
        System.out.println("Logging out...");
        //Assert.fail();
    }
    @AfterClass
    public void close() {
        System.out.println("Closing browser...");
        driver.quit();
    }
}
