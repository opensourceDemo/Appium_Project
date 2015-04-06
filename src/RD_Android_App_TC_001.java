package RealDevicesAutomation;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@test
public class RD_Android_App_TC_001 {


//	public static void main(String[] args) throws Exception
	 {
	  
		RemoteWebDriver driver;
		DesiredCapabilities capabilities =new DesiredCapabilities();	
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","4d007715d1c3303b");
		capabilities.setCapability("VERSION","5.1");	
		capabilities.setCapability("app-package","com.ABCBS");
		capabilities.setCapability("app-activity",".ABCBS");
		capabilities.setCapability("app","/Users/test/Desktop/Softwares/mobile-apps/WellPointMobileABCBSAndroid.apk");
				
		driver=new RemoteWebDriver( new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("ABCBS test app is launching now... check your test device");
		Thread.sleep(10000);
		
		System.out.println("Entering the user name...");
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("test");
		Thread.sleep(3000);
		
		System.out.println("Entering the password...");
		driver.findElement(By.xpath("//android.widget.EditText[@password='true']")).sendKeys("password");
		Thread.sleep(3000);
		
		System.out.println("Enable remember username...");
		driver.findElement(By.xpath("//android.widget.CheckBox")).click();
		Thread.sleep(3000);
		
		System.out.println("Click Member Login");
		driver.findElement(By.xpath("//android.widget.Button")).click();
		System.out.println("Done..Exiting now..");
		driver.close();
		driver.quit();
		
  }

 
}

