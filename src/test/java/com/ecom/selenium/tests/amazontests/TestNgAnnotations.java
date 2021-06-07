package com.ecom.selenium.tests.amazontests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {

	@Test
	public void testOne() {
		System.out.println("--Test 1 executed --");
	}
	
	@Test
	public void testTwo() {
		System.out.println("-- Test 2 Executed --");
	}
	
	@BeforeTest
	public void setUp() {
		System.out.println("--Before Test executed --");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("--Before Test executed --");
	}
	
	@BeforeMethod
	public void setUpEveryTest() {
		System.out.println("--Before every test --");
	}
	
	@AfterMethod
	public void tearDownEveryTest() {
		System.out.println(" -- After evert test");
	}
}
