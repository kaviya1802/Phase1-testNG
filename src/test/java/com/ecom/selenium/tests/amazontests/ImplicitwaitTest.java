package com.ecom.selenium.tests.amazontests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ImplicitwaitTest {
	WebDriver driver;
	final String siteUrl = "https://www.amazon.in/";
	final String driverPath = "/home/nallakavi35gmai/eclipse-workspace/amazontests/driver/chromedriver";
	
	/**Implicit wait makes the web driver to wait for given amount of time until it launch the browser
	 * before throwing no element found, default wait time is 0.
	 * 
	 */
	
	
	@BeforeTest
	public void launchBrowser() {
		// setup properties
		System.getProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(siteUrl);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void verifyomePageTitle() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(driver.getTitle(), expected);
	}
	
	@Test
	public void verifySourceUrl() {
		assertEquals(driver.getCurrentUrl(), siteUrl);
	}

}
