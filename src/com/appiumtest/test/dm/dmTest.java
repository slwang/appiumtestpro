package com.appiumtest.test.dm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class dmTest {
	public static AppiumDriver driver;  

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "app-debug.apk");
		//File app = new File(appDir, "duomanzhiduo.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName","Android Emulator");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("newCommandTimeout",240);
		capabilities.setCapability("appPackage", "com.zlot.app.douman");
		capabilities.setCapability("appActivity", ".activity.main.welcome.WelcomeTwoActivity");

		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		capabilities.setCapability("noReset", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		driver.findElement(By.id("com.zlot.app.douman:id/dialog_icon_delete")).click();

		//WebElement lendList = driver.findElement(by)

		//出借
		driver.findElement(By.id("com.zlot.app.douman:id/rb_sanbiao_text")).click();
		Thread.sleep(1000);

		//散标债权
		driver.findElement(By.id("com.zlot.app.douman:id/title_san")).click();
		Thread.sleep(1000);

		//精选产品
		driver.findElement(By.id("com.zlot.app.douman:id/title_product")).click();
		Thread.sleep(1000);

		//小豆机器人
		driver.findElement(By.id("com.zlot.app.douman:id/title_robot")).click();
		Thread.sleep(1000);


		//wo de 
		driver.findElement(By.id("com.zlot.app.douman:id/rb_my_text")).click();
		Thread.sleep(1000);

		WebElement mobile =driver.findElement(By.id("com.zlot.app.douman:id/login_phone"));
		//System.out.println(mobile.getCssValue(""));
		mobile.clear();
		mobile.sendKeys("13000000001");

		WebElement password =driver.findElement(By.id("com.zlot.app.douman:id/login_password"));
		password.clear();

		password.sendKeys("Ww111111");
		/*String str = password.getAttribute("value");
		System.out.println(str);*/



		driver.findElement(By.id("com.zlot.app.douman:id/login_bt")).click();
		Thread.sleep(1000);



		//出借
		driver.findElement(By.id("com.zlot.app.douman:id/rb_sanbiao_text")).click();
		Thread.sleep(1000);

		//散标债权
		driver.findElement(By.id("com.zlot.app.douman:id/title_san")).click();
		Thread.sleep(1000);


	}

}
