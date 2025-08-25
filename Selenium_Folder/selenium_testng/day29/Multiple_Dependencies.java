package com.selenium_testng.day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Multiple_Dependencies {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("Launching browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void openAmazon() {
        driver.get("https://www.amazon.in/");
        System.out.println("Opened Amazon");
    }

    @Test(dependsOnMethods = "openAmazon")
    public void searchLaptop() {
        System.out.println("Searching Laptop...");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();
        //Assert.fail();
    }

    @Test(dependsOnMethods = "searchLaptop")
    public void selectFirstResult() {
        System.out.println("Selecting first laptop result...");

    }

    @Test(dependsOnMethods = {"searchLaptop", "selectFirstResult"})
    public void addToCart() {
        System.out.println("Adding laptop to cart...");
        
    }

    @Test(dependsOnMethods = {"openAmazon", "addToCart"})
    public void checkout() {
        System.out.println("Proceeding to checkout...");
    
    }

    @AfterClass
    public void close() {
        System.out.println("Closing browser...");
        driver.quit();
    }
}
