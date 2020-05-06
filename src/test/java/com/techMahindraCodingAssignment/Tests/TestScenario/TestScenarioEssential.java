package com.techMahindraCodingAssignment.Tests.TestScenario;

import org.testng.annotations.Test;

import com.techMahindraCodingAssignment.LoginPage.LoginPage;
import com.techMahindraCodingAssignment.LoginPage.LoginPageAndroid;
import com.techMahindraCodingAssignment.LoginPage.LoginPageiOS;
import com.techMahindraCodingAssignment.Page.ProductPurchase.ProductPurchase;
import com.techMahindraCodingAssignment.Page.ProductPurchase.ProductPurchasePageAndroid;
import com.techMahindraCodingAssignment.Page.ProductPurchase.ProductPurchasePageiOS;
import com.techMahindraCodingAssignment.Pages.BasePage;
import com.techMahindraCodingAssignment.Tests.TestBase;

import org.testng.annotations.BeforeTest;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class TestScenarioEssential extends TestBase {

	public TestScenarioEssential() throws Exception {
		super();
	}

	private LoginPage loginPage;
	private ProductPurchase searchProductPage;
	
	String username = dataReading.getCellData("TVAssignment", "Email", 2);
	String password = dataReading.getCellData("TVAssignment", "Password", 2);
	String productName = dataReading.getCellData("TVAssignment", "ProductSearch", 2);
	String searchString = dataReading.getCellData("TVAssignment", "ItemFromDropdown", 2);
	String itemAssertion = dataReading.getCellData("TVAssignment", "ItemAssertion", 2);
	String InvalidPassword = dataReading.getCellData("TVAssignment", "InvalidPassword", 2);
	String InvalidEmail = dataReading.getCellData("TVAssignment", "InvalidEmail", 2);

	@BeforeTest
	public void setUpPage() throws Exception {
		switch (TestBase.executionOS) {
		case ANDROID:
			loginPage = new LoginPageAndroid(driver);
			searchProductPage = new ProductPurchasePageAndroid(driver);

			break;
			
		case IOS:
			loginPage = new LoginPageiOS(driver);
			searchProductPage = new ProductPurchasePageiOS(driver);
			break;
			
		default:
			break;
		}
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test
	@Description("This is coding demonstration test")
	public void TestScenarioEssentialItem() {
		/* LoginPageTests */
		loginPage.CheckLoginPageForExceptions();
		loginPage.clickLoginButton();
		
		loginPage.enterEmptyUsername();
		loginPage.clickContinueButton();
		
		loginPage.enterInvalidUsername(InvalidEmail);
		loginPage.clickContinueButton();
		
		loginPage.enterUsername(username);
		loginPage.clickContinueButton();
		
		BasePage.deviceOrientationChangeTest(90);
		loginPage.enterEmptyPassword();
		loginPage.signInSubmitButton();
		
		loginPage.enterInvalidPassword(InvalidPassword);
		loginPage.signInSubmitButton();
		
		loginPage.enterPassword(password);
		loginPage.signInSubmitButton();
		
		BasePage.deviceOrientationChangeTest(270);
		BasePage.closeLanguageDialog();
		searchProductPage.clickSearchTextbox(productName);
		searchProductPage.clickFirstSuggestionFromSearchBox(searchString, itemAssertion);
		
		BasePage.deviceOrientationChangeTest(0);
		BasePage.sleep(5);
		BasePage.useMyCurrentLocationClick();
		searchProductPage.selectItemAfterScroll();
	}
}
