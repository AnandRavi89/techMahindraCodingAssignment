package com.techMahindraCodingAssignment.LoginPage;

import org.openqa.selenium.By;

import com.techMahindraCodingAssignment.Pages.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPageAndroid extends BasePage implements LoginPage {

	public LoginPageAndroid(AppiumDriver<MobileElement> driver) throws Exception {
		super(driver);
	}
	
	String LoginButton = objectReading.objectReading(filePath, "LoginButton");
	String emailTextField = objectReading.objectReading(filePath, "emailTextField");
	String continueButton = objectReading.objectReading(filePath, "continueButton");
	String enterPassword = objectReading.objectReading(filePath, "enterPassword");
	String signInSubmitButton = objectReading.objectReading(filePath, "signInSubmitButton");
	
	@Step("Check Login Page For Exceptions")
	public void CheckLoginPageForExceptions() {
		driver.findElement(By.id(LoginButton)).isDisplayed();
	}
	
	@Step("Clicking on login button")
	public void clickLoginButton() {
		driver.findElement(By.id(LoginButton)).click();
		takeScreenshot("login2");
	}
	
	@Step("Enter valid username")
	public void enterUsername(String username) {
		takeScreenshot("enterUsername");
		BasePage.sleep(5);
		driver.findElement(By.xpath(emailTextField)).sendKeys(username);
		takeScreenshot("enterUsername2");
	}
	
	@Step("Entering on empty input to username textbox")
	public void enterEmptyUsername() {
		takeScreenshot("enterEmptyUsername");
		driver.findElement(By.xpath(emailTextField)).sendKeys("");
		takeScreenshot("enterEmptyUsername2");
	}
	
	@Step("Entering on invalid input to username textbox")
	public void enterInvalidUsername(String InvalidEmail) {
		takeScreenshot("enterInvalidUsername");
		BasePage.sleep(5);
		driver.findElement(By.xpath(emailTextField)).sendKeys(InvalidEmail);
		takeScreenshot("enterInvalidUsername2");
	}
	
	@Step("Clicking on continue button")
	public void clickContinueButton() {
		takeScreenshot("continueButton");
		driver.findElement(By.xpath(continueButton)).click();
		takeScreenshot("continueButton2");
	}
	
	@Step("Entering on valid input to password textbox")
	public void enterPassword(String password) {
		takeScreenshot("enterPassword");
		BasePage.sleep(5);
		driver.findElement(By.xpath(enterPassword)).sendKeys(password);
		takeScreenshot("enterPassword2");
	}
	
	@Step("Passing empty input to password textbox")
	public void enterEmptyPassword() {
		takeScreenshot("enterEmptyPassword");
		BasePage.sleep(5);
		driver.findElement(By.xpath(enterPassword)).sendKeys("");
		takeScreenshot("enterEmptyPassword2");
	}
	
	@Step("Passing invlalid input to password textbox")
	public void enterInvalidPassword(String InvalidPassword) {
		takeScreenshot("enterInvalidPassword");
		BasePage.sleep(5);
		driver.findElement(By.xpath(enterPassword)).sendKeys(InvalidPassword);
		takeScreenshot("enterInvalidPassword2");
	}

	@Step("Clicking on Submit Button")
	public void signInSubmitButton() {
		takeScreenshot("signInSubmitButton");
		driver.findElement(By.xpath(signInSubmitButton)).click();
		takeScreenshot("signInSubmitButton2");
	}
}
