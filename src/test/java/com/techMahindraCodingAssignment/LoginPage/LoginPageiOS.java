package com.techMahindraCodingAssignment.LoginPage;

import com.techMahindraCodingAssignment.Pages.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPageiOS extends BasePage implements LoginPage {
	
	public LoginPageiOS(AppiumDriver<MobileElement> driver) throws Exception {
		super(driver);
	}

	@Step("Verify login page")
	public void CheckLoginPageForExceptions() {
		// TODO Auto-generated method stub
		
	}

	@Step("Clicking on login button")
	public void clickLoginButton() {
		// TODO Auto-generated method stub
		
	}

	@Step("Enter valid username")
	public void enterUsername(String username) {
		// TODO Auto-generated method stub
		
	}

	@Step("Entering on empty input to username textbox")
	public void enterEmptyUsername() {
		// TODO Auto-generated method stub
		
	}

	@Step("Entering on invalid input to username textbox")
	public void enterInvalidUsername(String InvlalidEmail) {
		// TODO Auto-generated method stub
		
	}

	@Step("Clicking on continue button")
	public void clickContinueButton() {
		// TODO Auto-generated method stub
		
	}

	@Step("Entering on valid input to password textbox")
	public void enterPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Step("Passing empty input to password textbox")
	public void enterEmptyPassword() {
		// TODO Auto-generated method stub
		
	}

	@Step("Passing invlalid input to password textbox")
	public void enterInvalidPassword(String InvlalidPassword) {
		// TODO Auto-generated method stub
		
	}

	@Step("Clicking on Submit Button")
	public void signInSubmitButton() {
		// TODO Auto-generated method stub
		
	}

}
