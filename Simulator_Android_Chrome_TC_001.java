package Simulator_Automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//import com.thoughtworks.selenium.Selenium;
//testing git setup for mac
public class Simulator_Android_Chrome_TC_001 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		RemoteWebDriver driver;
		DesiredCapabilities capabilities =new DesiredCapabilities();	
		
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName","iPhone 4s");
		capabilities.setCapability("platformVersion","8.2");	
		capabilities.setCapability("safariAllowPopups", false);
		capabilities.setCapability("safariIgnoreFraudWarning", true);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
		driver=new RemoteWebDriver( new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
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
		
	System.out.println("Signin Complete");
	Thread.sleep(10000);
	System.out.println("Exiting now..");
	driver.close();
	driver.quit();
	
		}

	} 
