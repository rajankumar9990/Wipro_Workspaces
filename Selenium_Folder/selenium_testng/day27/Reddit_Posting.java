package com.selenium_testng.day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import io.github.sukgu.Shadow;
public class Reddit_Posting {
	WebDriver driver;
	SoftAssert softAssert;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.reddit.com/");
		softAssert = new SoftAssert();
	}

	@Test(priority = 1)
	public void login() throws Exception {
		driver.findElement(By
				.xpath("//a[@id='login-button']//span[@class='flex items-center gap-xs'][normalize-space()='Log In']"))
				.click();
		Thread.sleep(2000);

		// Enter credentials
		driver.findElement(By.name("username")).sendKeys(""); // test account
		driver.findElement(By.name("password")).sendKeys(""); // test account
		driver.findElement(By
				.xpath("//button[@type='button']//span[@class='flex items-center gap-xs'][normalize-space()='Log In']"))
				.click();
		Thread.sleep(2000);

		// Verify login success
		boolean loggedIn = driver.findElements(By.xpath("//span[text()='Home']")).size() > 0;
		softAssert.assertTrue(loggedIn, "Login failed!");
	}

	@Test(priority = 2)
	public void createPost() throws Exception {
		// Click 'Create Post' button
		driver.findElement(By.xpath("//a[@id='create-post']//span[@class='flex items-center justify-center']")).click();
		Thread.sleep(2000);
		//dropdown
		driver.findElement(By.cssSelector("span[class='flex items-center gap-xs']")).sendKeys("360");
		// Enter post title and content
		driver.findElement(By.name("title")).sendKeys("Test Post by Selenium");

		driver.findElement(By.xpath("//p[@class='first:mt-0 last:mb-0']")).sendKeys("This is a test post content.");

		// Submit post
		driver.findElement(By.cssSelector("#inner-post-submit-button > span > span")).click();
		Thread.sleep(2000);

		// Verify post creation

	}

}
