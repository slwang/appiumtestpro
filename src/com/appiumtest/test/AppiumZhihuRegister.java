package com.appiumtest.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumZhihuRegister {
	public static AppiumDriver driver;  
	private boolean isInstall = false;  

	public void startRecord() throws IOException {  
		Runtime rt = Runtime.getRuntime();  
		// this code for record the screen of your device  
		rt.exec("cmd.exe /C adb shell screenrecord /sdcard/runCase.mp4");  
	}  


	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "zhihu.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","Android Emulator");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.zhihu.android");
		capabilities.setCapability("appActivity", "com.zhihu.android.ui.activity.GuideActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		List<WebElement> buttonsList = driver.findElementsByClassName("android.widget.Button");  
		buttonsList.get(1).click();
		driver.findElementByClassName("android.widget.CheckBox").click(); 
		Thread.sleep(10000);

		driver.findElement(By.name("忽略")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("热门收藏")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("本月热榜")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("今日热榜")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("热门推荐")).click();
		Thread.sleep(1000);
		
		
		/*List<WebElement> textViewList = driver.findElementsByClassName("android.widget.TextView");  
		for (WebElement we :textViewList ){
			we.click();
			Thread.sleep(1000);
		}*/
		
		
		
		
	}

}
