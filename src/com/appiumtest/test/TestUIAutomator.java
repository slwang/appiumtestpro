package com.appiumtest.test;

import java.io.File;
import java.net.URL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestUIAutomator {
	
	
	AndroidDriver<MobileElement> driver;

	@Before
	public void setUp() throws Exception {
		// set up appium
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "LC4BVYA42549");
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.4");
				// if no need install don't add this
				File classpathRoot = new File(System.getProperty("user.dir"));
				File appDir = new File(classpathRoot, "apps");
				File app = new File(appDir, "loveQes.apk");
				capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

				capabilities.setCapability("appPackage", "com.tangbc.loveqes");
				/*capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
				// support Chinese
				capabilities.setCapability("unicodeKeyboard", true);
				capabilities.setCapability("resetKeyboard", true);
				// no need sign
				capabilities.setCapability("noSign", true);*/
				capabilities.setCapability("appActivity", ".MainActivity");
				System.out.println("connet to Appium server  " );
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	boolean isLogin = false;

	@Test
	public void testCase() throws Exception {
		final WebDriverWait wait = new WebDriverWait(driver, 1);
//	    driver.startActivity("com.testerhome.webview", ".ToastActivity");
		driver.findElementById("com.tangbc.loveqes:id/mainButton").click();
		Thread.sleep(1000);
		driver.findElementById("com.tangbc.loveqes:id/thisButton").click();
		Thread.sleep(1000);
		driver.findElementById("com.tangbc.loveqes:id/thisButton").click();
		
		//Thread.sleep(100);
		driver.findElement(By.xpath(".//*[contains(@text,'Toast测试')]"));
		
		System.out.println(driver.findElementByClassName("android.widget.LinearLayout").getText());
		 
		 
	/*    if(null != wait.until(
	            ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'Toast测试')]")))){
	    	 System.out.println(driver.findElementByXPath(".//*[contains(@text,'Toast测试')]").getText());
	    }
	   */
	   /* Assert.assertNotNull(wait.until(
	            ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'Toast测试')]"))));*/
	} 
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
