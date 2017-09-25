package com.appiumtest.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class appiumTest {

	public static AppiumDriver driver;  
	private boolean isInstall = false;  

	public void startRecord() throws IOException {  
		Runtime rt = Runtime.getRuntime();  
		// this code for record the screen of your device  
		rt.exec("cmd.exe /C adb shell screenrecord /sdcard/runCase.mp4");  
	}  


	public static void main(String[] args) throws MalformedURLException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "ContactManager.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","Android Emulator");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.example.android.contactmanager");
		capabilities.setCapability("appActivity", ".ContactManager");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


		WebElement el = driver.findElement(By.name("Add Contact"));  
		el.click();  
		List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");  
		textFieldsList.get(0).sendKeys("Some Name");  
		textFieldsList.get(2).sendKeys("Some@example.com");  
		//driver.swipe(100, 500, 100, 100, 2);  

//		List<WebElement> buttonsList = driver.findElementsByClassName("android.widget.Button");  
//		buttonsList.get(0).click();
		driver.findElementByName("Save").click();  
	}

}
