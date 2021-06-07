package com.ecom.selenium.tests.amazontests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class ExplicitWaitTest {

	WebDriver driver;
	WebDriverWait wait;
	final String siteUrl = "https://www.amazon.in/";
	final String driverPath = "/home/nallakavi35gmai/eclipse-workspace/amazontests/driver/chromedriver";

	/**Explicit wait is used to tell the webdriver to wait for a certain conditions(Explicit conditions for wait)
	 * Once time is maximun or element not visible exception
	 * intelligent wait
	 */
	@BeforeMethod
	public void setUpDriver() {

		// setup properties
		System.getProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get(siteUrl);
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

	@Test
	public void verifyElectronicsLinkTest() {
		WebElement elink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-xshop\"]/a[5]")));
		elink.click();
		String expected = "Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in";
		assertEquals(elink.getText(), expected);
	}

}
