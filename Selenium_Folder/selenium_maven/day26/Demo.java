package com.selenium_maven.day26;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Hello");
        WebDriver driver = new ChromeDriver(); // upcasting
        
            driver.get("https://www.google.com");
            System.out.println("Page Title : "+driver.getTitle());
      
     
            driver.quit(); // ensures driver quits even if an exception occurs
    
}}
