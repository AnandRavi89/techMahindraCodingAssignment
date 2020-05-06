package com.techMahindraCodingAssignment.LoginPage;
/*
 * For flexibity of the automation regression testing and efficiency
 * as well low cost maintainence  
 */
public interface LoginPage {
	public void CheckLoginPageForExceptions();
	public void clickLoginButton();
	public void enterUsername(String username);
	public void enterEmptyUsername();
	public void enterInvalidUsername(String InvalidEmail);
	public void clickContinueButton();
	public void enterPassword(String password);
	public void enterEmptyPassword();
	public void enterInvalidPassword(String InvalidPassword);
	public void signInSubmitButton();
}
