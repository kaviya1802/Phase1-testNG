package com.ecom.selenium.external.elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DemoRadioButtonTest {

	WebDriver driver;
	String siteUrl = "file:///home/nallakavi35gmai/eclipse-workspace/amazontests/static/radio-check.html";
	String driverPath = "/home/nallakavi35gmai/eclipse-workspace/amazontests/driver/chromedriver";

	@BeforeMethod
	public void setUpDriver() {
		System.getProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	@Test
	public void verifyRadioButtonExistTest() {
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
		
		WebElement radio3 = driver.findElement(By.id("other"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
	}
	
	@Test
	public void verifyRadioButtonClickTest1() {
		WebElement radio1 = driver.findElement(By.id("male"));
		radio1.click();
		assertEquals(true, radio1.isSelected());
	}
	
	@Test
	public void verifyRadioButtonClickTest2() {
		WebElement radio2 = driver.findElement(By.id("female"));
		radio2.click();
		assertEquals(true, radio2.isSelected());
	}
	
	@Test
	public void verifyRadioButtonClickTest3() {
		WebElement radio3 = driver.findElement(By.id("other"));
		radio3.click();
		assertEquals(true, radio3.isSelected());
	}

}
