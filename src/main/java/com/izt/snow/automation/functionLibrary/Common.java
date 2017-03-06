package com.izt.snow.automation.functionLibrary;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import com.izt.snow.automation.pageObject.HomePage_Repository;
import com.izt.snow.automation.pageObject.LoginPage_Repository;
import com.izt.snow.automation.webdriver.BaseClass;
import com.izt.snow.automation.webdriver.Driver;

/**
 * 
 * @author Bharath
 * 
 */
/* Login Function */
public class Common extends BaseClass {

	public void login(String username, String password) {

		LoginPage_Repository log = PageFactory.initElements(Driver.driver,
				LoginPage_Repository.class);
		BaseClass baseMethod = new BaseClass();

		try{
		baseMethod.switchToFrame("gsft_main");
		log.getUserNameEdit().sendKeys(username);
		log.getPasswordEdit().sendKeys(password);
		log.getLogInButton().click();
		}catch(NoSuchElementException e){
			
			Driver.driver.get("https://virtusadev.service-now.com");
			baseMethod.pageLoadWait();
			baseMethod.switchTo().defaultContent();
			baseMethod.switchToFrame("gsft_main");
			log.getUserNameEdit().sendKeys(username);
			log.getPasswordEdit().sendKeys(password);
		}

	}
/**
 * 
 * @throws InterruptedException
 */
	public void logout() throws InterruptedException {

		HomePage_Repository home = PageFactory.initElements(Driver.driver,
				HomePage_Repository.class);
		
		Driver.driver.switchTo().defaultContent();
		Thread.sleep(3000);
		home.getUserInfoDropDownButton().click();
		Thread.sleep(3000);
		home.getLogoutLink().click();
	}

}
