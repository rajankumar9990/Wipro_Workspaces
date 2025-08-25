package com.selenium_testng.day27;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import java.lang.Object;
public class Flight_Booking {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("Launching browser.....");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");
    }
    @DataProvider(name = "cityPairs")
    public Object[][] getCityPairs() { //object is class
        return new Object[][] {
            {"Paris", "London"},
            {"Boston", "Berlin"},
            {"Philadelphia", "Rome"}
        };
    }

    @Test(dataProvider = "cityPairs")
    public void BookFlight(String fromCity, String toCity) throws Exception {
        // Open site before each booking
        driver.get("https://blazedemo.com/");
        Thread.sleep(2000);

        // Search flight
        driver.findElement(By.name("fromPort")).sendKeys(fromCity);
        Thread.sleep(2000);
        driver.findElement(By.name("toPort")).sendKeys(toCity);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(2000);

        // Selecting first flight
        driver.findElement(By.cssSelector("table tbody tr:nth-child(1) td input")).click();
        Thread.sleep(2000);

        // Enter passenger details
        driver.findElement(By.id("inputName")).sendKeys("Rajan Gupta");
        Thread.sleep(2000);
        driver.findElement(By.id("address")).sendKeys("Delhi, Burari");
        Thread.sleep(1000);
        driver.findElement(By.id("city")).sendKeys("New Delhi");
        Thread.sleep(2000);
        driver.findElement(By.id("state")).sendKeys("Delhi");
        Thread.sleep(2000);
        driver.findElement(By.id("zipCode")).sendKeys("110001");
        Thread.sleep(2000);
        driver.findElement(By.id("creditCardNumber")).sendKeys("1234567891234567");
        Thread.sleep(2000);
        driver.findElement(By.id("nameOnCard")).sendKeys("Rajan Gupta");
        Thread.sleep(2000);

        // Proceed with booking
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(3000);
System.out.println("Your flight has been confirmed.");
    }

    @AfterClass
    public void CloseBrowser() {
        driver.quit();  // closes browser once after all tests
    }
}
