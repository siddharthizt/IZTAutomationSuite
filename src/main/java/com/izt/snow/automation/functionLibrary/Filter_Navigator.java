package com.izt.snow.automation.functionLibrary;




import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.izt.snow.automation.pageObject.HomePage_Repository;
import com.izt.snow.automation.pageObject.IM_Repository;
import com.izt.snow.automation.webdriver.BaseClass;
import com.izt.snow.automation.webdriver.Driver;

/**
 * 
 * @author Bharath
 * 
 */

public class Filter_Navigator extends BaseClass {
	/**
	 * 
	 * @param filterSearch
	 * @param exceptedValue
	 * @throws InterruptedException
	 */

	HomePage_Repository home = PageFactory.initElements(Driver.driver,
			HomePage_Repository.class);
	IM_Repository incident = PageFactory.initElements(Driver.driver,
			IM_Repository.class);
	BaseClass baseMethod = new BaseClass();

	public void navigator(String filterSearch, String exceptedValue)
			throws InterruptedException {

		HomePage_Repository home = PageFactory.initElements(Driver.driver,
				HomePage_Repository.class);
		BaseClass baseMethod = new BaseClass();

		home.getFilterNavigaterEdit().sendKeys(filterSearch);
		Thread.sleep(3000);
		baseMethod.selectFromList(home.getIncidentSubMenuList(), exceptedValue);
		baseMethod.pageLoadWait();

	}

	/**
	 * 
	 * @param ticket
	 */
	public void searchTicket(String ticket) {
		
		HomePage_Repository home = PageFactory.initElements(Driver.driver,
				HomePage_Repository.class);
		
		BaseClass baseMethod = new BaseClass();

		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");
		baseMethod.selectDropdown(home.getGoToSearchDropDown(), "Number");
		home.getSearchGoToEdit().sendKeys(ticket);
		baseMethod.actions();
		baseMethod.pageLoadWait();

	}

	public void openExistingTicket(String ticket) {
		HomePage_Repository home = PageFactory.initElements(Driver.driver,
				HomePage_Repository.class);
		
		BaseClass baseMethod = new BaseClass();
		
		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");
		baseMethod.selectDropdown(home.getGoToSearchDropDown(), "Number");
		home.getSearchGoToEdit().sendKeys(ticket);
		baseMethod.actions();
		baseMethod.pageLoadWait();
		Driver.driver.findElement(
				By.xpath("//td[a[contains(text(),'" + ticket + "')]]/a"))
				.click();
		
	}

}
