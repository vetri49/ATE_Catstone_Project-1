package com.simplilearn.selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrtionPageTest {
	

	WebDriver driver=null;
	String siteurl="http://localhost:9010/register";
	String driverpath="drivers/windows/chromedriver.exe";
	
	@BeforeTest
	public  void setup() {

		System.setProperty("webdriver.chrome.driver", driverpath);
	    driver=new ChromeDriver();
		
		driver.get(siteurl);
		
	}
	@AfterTest
	public void cleanup() {
		if(driver!=null)
		driver.quit();
	}
	@Test(description="Test sport shoes register page title match",priority=1)
	public void registrationPageTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("jothi");
		driver.findElement(By.id("email")).sendKeys("jothi@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("jothi111");
		driver.findElement(By.xpath("/html/body/div[2]/form/button")).submit();
		
		
	}
	@Test(description="Test sport shoes registration page source url",priority=2)
	public void homePageSOurceUrlTest() {
		String url=driver.getCurrentUrl();
		assertEquals("http://localhost:9010/register-user",url);
	}
	@Test(description="Test sport shoes registartion page title ",priority=3)
	public void homePageTitleTest() {
		
		String actualTitle=" ";
		assertNotEquals(actualTitle,driver.getTitle());
		System.out.println(driver.getTitle());
	}

}
