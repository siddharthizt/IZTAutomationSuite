package com.izt.snow.automation.pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Bharath
 * 
 */
/* Home Page Web Elements */
public class HomePage_Repository {

	@FindBy(xpath = "//input[@id='filter']")
	private WebElement filterNavigaterEdit;

	@FindAll({@FindBy(xpath = "//span[a[contains(text(),'Incident')]]/following-sibling::ul/li/a")})
	private List<WebElement> incidentSubMenuList;

	@FindAll({@FindBy(xpath = "//span[a[contains(text(),'Problem')]]/following-sibling::ul/li/a")})
	private List<WebElement> problemSubMenuList;

	@FindBy(xpath = "//button[@id='user_info_dropdown']")
	private WebElement userInfoDropDownButton;

	@FindBy(xpath = "//button[@id='user_info_dropdown']/following-sibling::ul/descendant::a[contains(text(),'Profile')]")
	private WebElement profileLink;

	@FindBy(xpath = "//button[@id='user_info_dropdown']/following-sibling::ul/descendant::a[contains(text(),'Logout')]")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//span[contains(text(),'Go to')]/following-sibling::div/div/input")
	private WebElement searchGoToEdit;

	@FindBy(xpath = "//span[contains(text(),'Go to')]/following-sibling::div/div/span/span/select")
	private WebElement goToSearchDropDown;

	
	public WebElement getSearchGoToEdit() {
		return searchGoToEdit;
	}


	public WebElement getGoToSearchDropDown() {
		return goToSearchDropDown;
	}


	public WebElement getFilterNavigaterEdit() {
		return filterNavigaterEdit;
	}

	
	public List<WebElement> getIncidentSubMenuList() {
		return incidentSubMenuList;
	}

	public List<WebElement> getProblemSubMenuList() {
		return problemSubMenuList;
	}

	public WebElement getUserInfoDropDownButton() {
		return userInfoDropDownButton;
	}

	public WebElement getProfileLink() {
		return profileLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

}
