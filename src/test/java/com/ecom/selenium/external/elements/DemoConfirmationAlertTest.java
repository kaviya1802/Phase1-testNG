package com.ecom.selenium.external.elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DemoConfirmationAlertTest {

	WebDriver driver;
	String siteUrl = "file:///home/nallakavi35gmai/eclipse-workspace/amazontests/static/alerts.html";
	String driverPath = "/home/nallakavi35gmai/eclipse-workspace/amazontests/driver/chromedriver";

	@BeforeMethod
	public void setUpDriver() {
		System.getProperty("webdriver.chrome.driver", driverPath);
		driver= new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

	@Test
	public void webConfirmationBox() throws InterruptedException {
		
		//click on try it button
		driver.findElement(By.xpath("/html/body/button")).click();
		Thread.sleep(5000);
		
		//accept the alert popup
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//click on try it button
		driver.findElement(By.xpath("/html/body/button")).click();
		Thread.sleep(5000);
		
		//dismiss the alert popup
		alert.dismiss();
	}
	
	@Test()
	public void verifyTitle() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/button")).click();
		Thread.sleep(3000);
		
		assertEquals("Press a button !", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=1)
	public void verifyAlertbox() throws InterruptedException {
		
		//click on try it
		
		driver.findElement(By.xpath("/html/body/button[2]")).click();
		Thread.sleep(3000);
		//accept the alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Are you sure !", driver.switchTo().alert().getText());
		alert.accept();
	
				
	}

}
