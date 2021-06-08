package com.ecom.selenium.external.browser.screenshot;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

public class BrowserWindowSchreenShotTests {
	WebDriver driver;
	final String siteUrl = "https://www.amazon.in/";
	final String driverPath = "/home/nallakavi35gmai/eclipse-workspace/amazontests/driver/chromedriver";

	@BeforeMethod
	public void launchBrowser() {
		// setup properties
		System.getProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(siteUrl);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void takeScreenShotTest() throws IOException, URISyntaxException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		URI uri = new URI(siteUrl);
		FileHandler.copy(src, new File("/home/nallakavi35gmai/selenium-test-screenshot/"+uri.getHost()));
	}

}
