package com.ecom.selenium.external.window.popup;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BrowserWindowsPopupTest {

	WebDriver driver;
	final String siteUrl = "https://www.amazon.in/";
	final String driverPath = "/home/nallakavi35gmai/eclipse-workspace/amazontests/driver/chromedriver";

	@BeforeMethod
	public void launchBrowser() {
		// setup properties
		System.getProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void verifyLocationWindowspopup() throws InterruptedException {
		
		driver.findElement(By.id("glow-ingress-line2")).click();
		String mainWindow = driver.getWindowHandle();
		
		//switch to pop up window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itrs = windows.iterator();
		
		while(itrs.hasNext()) {
			String childwindow = itrs.next();
			
				Thread.sleep(5000);
				//driver.switchTo().window(childwindow);
				driver.findElement(By.cssSelector("#GLUXZipUpdateInput")).sendKeys("639202");
				//Thread.sleep(5000);
				driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
				
		}
			driver.switchTo().window(mainWindow);
			
			
		}
		
	}