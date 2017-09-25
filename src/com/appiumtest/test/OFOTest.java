package com.appiumtest.test;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OFOTest {

	public static void main(String[] args) throws MalformedURLException {


		AndroidDriver  driver;
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "OFOxiaohuangche.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","Android Emulator");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "so.ofo.labofo");
		capabilities.setCapability("appActivity", "so.ofo.labofo.activities.EntryActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


		List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.TextView");
		System.out.println(textFieldsList.size());
		textFieldsList.get(0).click();//登录注册
	}

}
