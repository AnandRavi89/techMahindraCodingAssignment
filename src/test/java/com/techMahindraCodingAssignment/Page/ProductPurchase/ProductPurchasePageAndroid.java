package com.techMahindraCodingAssignment.Page.ProductPurchase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.techMahindraCodingAssignment.Pages.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import ru.yandex.qatools.allure.annotations.Step;

public class ProductPurchasePageAndroid extends BasePage implements ProductPurchase {
	
	String searchTextBox = objectReading.objectReading(filePath, "searchTextBox");
	String selectItem = objectReading.objectReading(filePath, "selectItem");
	String addToCartButton = objectReading.objectReading(filePath, "addToCartButton");

	public ProductPurchasePageAndroid(AppiumDriver<MobileElement> driver) throws Exception {
		super(driver);
	}
	
	/*Beginning of the product purchase flow*/
	@Step("Click on search textbox and enter a product name to search")
	public void clickSearchTextbox(String productName) {
		takeScreenshot("searchTextBox");
		driver.findElement(By.xpath(searchTextBox)).click();
		BasePage.sleep(10);
		driver.findElement(By.xpath(searchTextBox)).sendKeys(productName);
		takeScreenshot("searchTextBox2");
	}
	
	/*Clicking on first suggested from listing*/
	@Step("Click on first suggested product from listing")
	public void clickFirstSuggestionFromSearchBox(String SelectItem, String ItemAssertion) {
		takeScreenshot("firstSuggestedSearchClick");
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+SelectItem+"']")).click();
		takeScreenshot("firstSuggestedSearchClick2");
		
		/*Verify first Item*/
		String actualText = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ItemAssertion+"']")).getText();
		assertEquals(actualText, ItemAssertion);
		
	}
	
	/*
	 * This methods performs following:
	 * Select item which is needed to be added to wishlist
	 * Scrolling to Add the product to wishlist
	 */
	@Step("Click on Add to Cart button")
	public void selectItemAfterScroll() {
		takeScreenshot("selectItem");
		driver.findElement(By.xpath(selectItem)).click();
		BasePage.sleep(5);
		BasePage.closeLanguageDialog();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
				+ "instance(0)).scrollIntoView(new UiSelector()."
				+ "textContains(\""+"Add to Cart"+"\").instance(0))"));
		driver.findElement(By.xpath(addToCartButton)).click();
		BasePage.sleep(5);
		takeScreenshot("selectItem2");
	}
}
