package com.selenium_maven.day26;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Patient_Appointment {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// Load credentials from properties file
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("src\\main\\java\\com\\selenium_maven\\day26\\Patient.properties");
		props.load(fis);

		// Launch Chrome
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.practo.com");

		String email = props.getProperty("practo.email");
		String password = props.getProperty("practo.password");

		driver.findElement(By.name("Practo login")).click();

		// login
		driver.findElement(By.id("username")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("login")).click();
		System.out.println("Logged in Successfully");
		Thread.sleep(2000);

		// search doctor
		driver.findElement(By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']")).click();
		// dentist
		driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div/div[1]/span[1]/div")).click();
		System.out.println("Doctor is searched as Dentist");
		// Book free clinic
		driver.findElement(By.cssSelector(
				"body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)"))
				.click();

		// Select time - 5:00 PM
		driver.findElement(By.xpath("//span[normalize-space()='05:00 PM']")).click();
		Thread.sleep(2000);
		System.out.println("Clinic booked at 05:00 PM");
		
		// online payment
		driver.findElement(By.xpath("//div[@class='c-appointment-form__payment__card ']")).click();
		Thread.sleep(1000);
		// confirm booking
		driver.findElement(By.xpath("//button[normalize-space()='Confirm Clinic Visit']")).click();
		Thread.sleep(2000);
		// upi details
		driver.findElement(By.xpath("//*[@id=\"payment-options\"]/div[2]/div[4]/div[2]/div[1]/div[2]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='upi-vpa']")).sendKeys("1234567891@ptaxis");
		Thread.sleep(2000);
		// pay
		driver.findElement(By.xpath("//div[@id='pay-now']")).click();
		System.out.println("Payment Button Clicked and it will show Invalid UPI");
		Thread.sleep(2000);

		// Profile
		driver.findElement(By.xpath("//span[@class='up-triangle']//span[@class='downarrow icon-ic_down_cheveron']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='u-d nav-dropdown text-left active-state']//span[contains(text(),'My Medical Records')]"))
				.click();
		Thread.sleep(2000);

		// upload report
		driver.findElement(By.cssSelector(
				"#sideBarAppContainer > div.col-sm-9.col-lg-10.col-xs-12.product-container-wrapper > div.timeline-container-wrapper > div > div.timeline-container-header.separator.hidden-xs > div"))
				.click();

		driver.findElement(By.cssSelector(".record-upload-add-tile.text-small.text-center")).click();// div tag 


		WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));//actual file upload

		//absolute file path
		fileInput.sendKeys("C:\\Rajan Files\\OneDrive\\Desktop\\Selenium Folder\\med_report.pdf");

		System.out.println("File uploaded successfully");

		// Title passed
		driver.findElement(By.className("input-box-body")).sendKeys("Blood Report");
		Thread.sleep(2000);
		
		// Open the calendar if needed
		WebElement dateInput = driver.findElement(By.xpath("//input[@placeholder='Select date']"));
		dateInput.click();

		//  click '19' on the calendar for August 2025
		WebElement dateElement = driver.findElement(
		    By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[4]/div[3]")
		);
		dateElement.click();

		// Click OK / Done on the calendar popup
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[3]/div[2]/div[1]")).click();

		// Done
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]/div[2]")).click();
		// pop up done click
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"div.record-upload-layout.success.text-center div.button.text-center.heading-four.btn-positive"))
				.click();

		Thread.sleep(2000);
		System.out.println("Medical Report Uploaded");
		Thread.sleep(2000);
		//for log out
		driver.findElement(By.xpath("//div[@class='nav-items u-d-trigger dropdown-toggle push-droparrow']")).click();
		Thread.sleep(2000);
		//clicking on logout
		driver.findElement(By.xpath("//div[@class='u-d nav-dropdown text-left active-state']//a[@class='nav-interact logout-click'][normalize-space()='Logout']")).click();
		System.out.println("Log Out Successfull, Please re login to use.");
		Thread.sleep(4000);
		
		driver.quit();

	}

}
