package seleniumGrid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.testng.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GmailLogin {

WebDriver driver = null;
private StringBuffer verificationErrors = new StringBuffer();


@Parameters({ "platform","browser","version", "url" })
@BeforeTest(alwaysRun=true)
public void setup(String platform, String browser, String version, String url) throws MalformedURLException 
			{
				DesiredCapabilities caps = new DesiredCapabilities();

				//Platforms
					if(platform.equalsIgnoreCase("WINDOWS"))
					caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
					if(platform.equalsIgnoreCase("MAC"))
					caps.setPlatform(org.openqa.selenium.Platform.MAC);
					if(platform.equalsIgnoreCase("Andorid"))
					caps.setPlatform(org.openqa.selenium.Platform.ANDROID);
				
				//Browsers
					if(browser.equalsIgnoreCase("chrome"))
					caps = DesiredCapabilities.chrome();
					if(browser.equalsIgnoreCase("Safari"))
					caps = DesiredCapabilities.safari();
					if(browser.equalsIgnoreCase("iPhone"))
					caps = DesiredCapabilities.iphone();
					if(browser.equalsIgnoreCase("Android"))
					caps = DesiredCapabilities.android();
				
				//Version
					caps.setVersion(version);
					driver = new RemoteWebDriver(new URL("http://10.199.54.43:4444/wd/hub"), caps);
				
				// Open the Gmail
					driver.get(url);
			}


@Test(description="Test Gmail")
public void testGmailLogin() throws InterruptedException {

			
	//if (driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div/div[2]/div[3]/div/a")).isEnabled())
		//{
		//driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div/div[2]/div[3]/div/a")).click();
		//System.out.println("Click on Sign in buttton");
	//}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(5);
			if (driver.findElement(By.id("Email")) !=null){
				System.out.println("Email textbox found");
				
				driver.findElement(By.id("Email")).sendKeys("rogers.bdc8@gmail.com");}
			else{System.out.println("Email textbox not found");}
			
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5);
			if (driver.findElement(By.id("Passwd")) !=null){
				System.out.println("Password textbox found");
				Thread.sleep(5);
				driver.findElement(By.id("Passwd")).sendKeys("P@ssw0rdrogers");}
			else{System.out.println("Password textbox not found");}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Thread.sleep(5);
			if (driver.findElement(By.id("signIn")) !=null){
				System.out.println("Sigin button found");
				driver.findElement(By.id("signIn")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
			
			else{
	System.out.println("Sigin button  not found");}
	
	
			try {
				System.out.println("Signed in to Gmail");
				
			driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div/div[3]/div[1]/a")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div/div[2]/div[3]/div/a")).isEnabled()) {
			driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div/div[2]/div[3]/div/a")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
				//WebElement eid = driver.findElement(By.xpath("//*[@id=':2w']"));
						//assertEquals(eid.getAttribute("value"),"24.4");
						//assertEquals(eid.getText(), "Primary");
						//WebElement bmi_category = driver.findElement(By.name("bmi_category"));
						//assertEquals(bmi_category.getAttribute("value"),"Normal");
						} 
			catch (Error e) {
						//Capture and append Exceptions/Errors
						verificationErrors.append(e.toString());
						}
						}


			@AfterTest
			public void afterTest() {
			//Close the browser
			driver.quit();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
		}

}
