package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ViewCartPopUpPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productNames = By.cssSelector(".table.table-striped td.text-left a");

	public ViewCartPopUpPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	
	public List<String> getProductsValueListInCart() {
		List<WebElement> cartList = eleUtil.waitForElementsVisible(productNames, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		ArrayList<String> cartProdList = new ArrayList<String>();
		for(WebElement e : cartList) {
			String text = e.getText();
			cartProdList.add(text);
		}
		return cartProdList;
	}
	
	
	
	

}
