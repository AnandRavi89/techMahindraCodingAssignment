package com.techMahindraCodingAssignment.Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import ru.yandex.qatools.allure.annotations.Step;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.techMahindraCodingAssignment.Pages.DataReading;
import com.techMahindraCodingAssignment.drivers.android;
import com.techMahindraCodingAssignment.drivers.iOS;

public abstract class TestBase {

	private final static String URL_STRING = "http://127.0.0.1:4723/wd/hub";

	public static AppiumDriver<MobileElement> driver;
	static WebDriverWait wait;

	/*
	 * Depending upon which platform is to tested, tester need to change the OS
	 * value either to: ANDROID, IOS
	 */
	public static OS executionOS = OS.ANDROID;

	public enum OS {
		ANDROID, IOS
	}

	public static final String File_TestData = "AssignmentData.xlsx";

	/* This to set the File path and to open the Excel file, Pass Excel Path
	* and Sheetname as Arguments to this method protected ExcelReading
	*/
	protected DataReading dataReading = new DataReading(File_TestData);

	public TestBase() throws Exception {
	
	}

	@BeforeTest
	public abstract void setUpPage() throws Exception;

	@Step("Starting the test")
	@BeforeSuite
	public static void initAppium() throws MalformedURLException {

		URL url = new URL(URL_STRING);
		
		String appDir = System.getProperty("user.dir"); 

		switch (executionOS) {
		case ANDROID:

			DesiredCapabilities capabilitiesAndroid = new DesiredCapabilities();
			capabilitiesAndroid.setCapability(MobileCapabilityType.PLATFORM_NAME, android.platformName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.DEVICE_NAME, android.deviceName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.AUTOMATION_NAME, android.automationName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.APP, appDir + "/apps/" + android.appName);
			capabilitiesAndroid.setCapability("appPackage", android.appPackage);
			capabilitiesAndroid.setCapability(MobileCapabilityType.NO_RESET, false);

			driver = new AppiumDriver<MobileElement>(url, capabilitiesAndroid);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			break;

		case IOS:

			DesiredCapabilities capabilitiesIOS = new DesiredCapabilities();
			capabilitiesIOS.setCapability(MobileCapabilityType.PLATFORM_NAME, iOS.platformName);
			capabilitiesIOS.setCapability(MobileCapabilityType.PLATFORM_VERSION, iOS.platformVersion);
			capabilitiesIOS.setCapability(MobileCapabilityType.DEVICE_NAME, iOS.deviceName);
			capabilitiesIOS.setCapability(MobileCapabilityType.AUTOMATION_NAME, iOS.automationName);
			capabilitiesIOS.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilitiesIOS.setCapability(MobileCapabilityType.UDID, iOS.udid);
			capabilitiesIOS.setCapability(MobileCapabilityType.APP, appDir + "/apps/" + iOS.appName);
			capabilitiesIOS.setCapability("useNewWDA", "true");
			driver = new AppiumDriver<MobileElement>(url, capabilitiesIOS);
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			
		default:
			break;
		}
	}

	@Step("Closing the test")
	@AfterSuite
	public void tearDownAppium() {
		if (driver != null) {
			driver.quit();
		}
	}
}