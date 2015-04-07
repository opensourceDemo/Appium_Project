package com.pos.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSimulatorDemo {
	
	RemoteWebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities =new DesiredCapabilities();	
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","Rekha");
		capabilities.setCapability("platformVersion","4.4");	
		driver=new RemoteWebDriver( new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("*** In class - Test A ***");
	}

	@Test
	public void testOne() throws InterruptedException {
		driver.get("http://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5);
				if (driver.findElement(By.id("Email")) !=null){
					System.out.println("Email textbox found");
					
					driver.findElement(By.id("Email")).sendKeys("rogers.bang8@gmail.com");}
				else{System.out.println("Email textbox not found");}
				
				
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5);
				if (driver.findElement(By.id("Passwd")) !=null){
					System.out.println("Password textbox found");
					Thread.sleep(5);
					driver.findElement(By.id("Passwd")).sendKeys("P@ssw0rdrogers");}
				else{System.out.println("Password textbox not found");}
					Thread.sleep(5);
				if (driver.findElement(By.id("signIn")) !=null){
					System.out.println("Sigin button found");
					driver.findElement(By.id("signIn")).click();}
				else{
		System.out.println("Sigin button  not found");}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);	
	System.out.println("Signin Complete");
		System.out.println("hello");
	}
	
	@Test
	public void testTwo() {
		System.out.println("This will be our second TestNg script");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("*** End of class***");
	}

}
