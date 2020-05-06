package com.techMahindraCodingAssignment.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
/*Class which has */
public abstract class BasePage {
	
	protected static FileInputStream file;
	protected static ObjectRepositoryReader objectReading = new ObjectRepositoryReader(file);
	
	protected static String filePath = "/src/test/resources/objectRepository.properties";

	static String useMyCurrentLocationClick = objectReading.objectReading(filePath, "useMyCurrentLocationClick");
	static String closeLanguageDialog = objectReading.objectReading(filePath, "closeLanguageDialog");
	static String allowLocationButton = objectReading.objectReading(filePath, "allowLocationButton");

	public static WebDriverWait wait;

	protected static Dimension size;

	protected static AppiumDriver<MobileElement> driver;
	
	public BasePage(AppiumDriver<MobileElement> driver) throws Exception {
		BasePage.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 	
	}
	
	//Device rotation can be optimized
	public static void deviceOrientationChangeTest(Integer z) {
		driver.rotate(new DeviceRotation(0, 0, z));
		takeScreenshot("deviceOrientationChangeTest");
		BasePage.sleep(2);
	}

	public static boolean takeScreenshot(final String name) {
		String screenshotDirectory = System.getProperty("appium.screenshots.dir",
				System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}

	public static void sleep(int sleeptime) {
		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeLanguageDialog() {
		takeScreenshot("closeLanguageDialog");
		try {
			driver.findElement(By.xpath(closeLanguageDialog)).click();
		} catch (Exception e) {
			System.err.println("Unable to observe language button");
		}
		takeScreenshot("closeLanguageDialog2");
	}
	
	public static void useMyCurrentLocationClick() {
		takeScreenshot("useMyCurrentLocationClick");
		try {
			driver.findElement(By.xpath(useMyCurrentLocationClick)).click();
		} catch (Exception e) {
			System.err.println("use My Current Location button not present");
		}
		takeScreenshot("useMyCurrentLocationClick2");
		
		takeScreenshot("allowLocationButton");
		try {
			driver.findElement(By.xpath(allowLocationButton)).click();
		} catch (Exception e) {
			System.err.println("allow Location Button  not present");
		}
		takeScreenshot("allowLocationButton2");
	}
	
	public static void orientationTest() {
		driver.rotate(new DeviceRotation(0, 0, 90));
		takeScreenshot("selectItem");
		BasePage.sleep(2);
		driver.rotate(new DeviceRotation(0, 0, 180));
		takeScreenshot("selectItem");
		BasePage.sleep(2);
		driver.rotate(new DeviceRotation(0, 0, 270));
		takeScreenshot("selectItem");
		BasePage.sleep(2);
		driver.rotate(new DeviceRotation(0, 0, 0));
		takeScreenshot("selectItem");
		BasePage.sleep(2);
	}
}
