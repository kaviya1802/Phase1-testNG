package com.ecom.selenium.external.elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class DemoCheckBoxTest {

	WebDriver driver;
	String siteUrl = "file:///home/nallakavi35gmai/eclipse-workspace/amazontests/static/radio-check.html";
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
	public void verfiyCheckBoxExistTest() {
		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(false, checkBox1.isSelected());
	}
	
	@Test
	public void verifyDefaultCheckBoxTest() {
		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		assertEquals(true, checkBox2.isSelected());
	}
	
	@Test
	public void verifyCheckboxSelection() {
		driver.findElement(By.id("vehicle1")).click();
		driver.findElement(By.id("vehicle2")).click();
		driver.findElement(By.id("vehicle3")).click();
	}
	@Test
	public void verifyDropDown() {
		WebElement select = driver.findElement(By.id("vehicle"));
		Select vehicle= new Select(select);
		vehicle.selectByVisibleText("I have a bike");
		WebElement selectedElement = vehicle.getFirstSelectedOption();
		assertEquals("I have a bike", selectedElement.getText());
	}
	
	@Test
	public void selectByIndex() {
		WebElement select = driver.findElement(By.id("vehicle"));
		Select vehicle= new Select(select);
		vehicle.selectByIndex(2);
		List<WebElement> selectedElement = vehicle.getAllSelectedOptions();
		assertEquals("I have a C", selectedElement.get(0).getText());
	}

}
