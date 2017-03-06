package com.izt.snow.automation.functionLibrary;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.izt.snow.automation.pageObject.IM_Repository;
import com.izt.snow.automation.webdriver.BaseClass;
import com.izt.snow.automation.webdriver.Driver;

/**
 * 
 * @author Bharath
 * 
 */
/* Incident Management Methods */
public class Incident_Management extends BaseClass {

	BaseClass baseMethod = new BaseClass();

	/**
	 * Creating New Incident
	 * 
	 * @param callerName
	 * @param contactType
	 * @param impact
	 * @param urgency
	 * @param category
	 * @param subCategory
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void createNewIncident(String callerName, String contactType,
			String impact, String urgency, String category, String subCategory)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException, InterruptedException {
		IM_Repository incident = PageFactory.initElements(Driver.driver,
				IM_Repository.class);

		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");
		String incidentnumber = incident.getIncidentNumberValueAttribute()
				.getAttribute("value");
		String parent=	baseMethod.getWindowHandle();
		baseMethod.setExcelData("Incident", 1, 1, incidentnumber);
		Thread.sleep(5000);
		incident.getCallerLookUpListSearch().click();
		baseMethod.switchToWindow("child");	
		baseMethod.pageLoadWait();
		baseMethod.selectDropdown(incident.getCallerWindowDropDown(), "Name");
		Thread.sleep(1000);
		incident.getCallerWindowSearchEdit().sendKeys(callerName);
		Thread.sleep(2000);
		baseMethod.actions();
		baseMethod.pageLoadWait();
		Thread.sleep(2000);
		baseMethod.selectFromList(incident.getCallerWindowList(),callerName);
		baseMethod.switchTo().window(parent);
		
		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");
		baseMethod.selectDropdown(incident.getContactTypeDropDown(),
				contactType);
		baseMethod.selectDropdown(incident.getImpactDropDown(), impact);
		Thread.sleep(2000);
		baseMethod.selectDropdown(incident.getUrgencyDropDown(), urgency);
		Thread.sleep(2000);
		baseMethod.selectDropdown(incident.getCategoryDropDown(), category);
		Thread.sleep(4000);
		baseMethod.selectDropdown(incident.getSubCategoryDropDown(),
				subCategory);
		incident.getShortDescriptionEdit().sendKeys("test");
		incident.getSubmitButton().click();

	}

	/**
	 * 
	 * @param ticket
	 * @param caller
	 * @param assignedGroup
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws EncryptedDocumentException
	 */
	public void incidentValidation(String ticket, String caller,
			String assignedGroup) throws EncryptedDocumentException,
			InvalidFormatException, IOException {
		IM_Repository incident = PageFactory.initElements(Driver.driver,
				IM_Repository.class);

		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");
		List<WebElement> lst = Driver.driver.findElements(By
				.xpath("//td[a[contains(text(),'" + ticket
						+ "')]]/following-sibling::td/a"));
		for (int i = 0; i < lst.size(); i++) {
			String status = "";
			String actual = lst.get(i).getText();
			if (actual.equalsIgnoreCase(caller)) {
				status = "Pass";
			} else if (actual.equalsIgnoreCase(assignedGroup)) {
				status = "Pass";
			} else {
				status = "Fail";
				break;
			}
			baseMethod.setExcelData("Incident", 1, 8, status);
		}
	}

	/**
	 * 
	 * @param assigenToDropDown
	 * @param assigneToName
	 * @param workNotes
	 * @param expectedStatus
	 * @param additionalComments
	 * @param closerCode
	 * @param expectedCloseCode
	 */
	public void changeStatus(String assigenToDropDown, String assigneToName,
			String workNotes, String expectedStatus, String additionalComments,
			String closerCode, String expectedCloseCode) {
		IM_Repository incident = PageFactory.initElements(Driver.driver,
				IM_Repository.class);
		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");
		if (expectedStatus.equalsIgnoreCase("In Progress")) {

			incident.getAssignedtoLookUpWindow().click();
			baseMethod.switchToWindow("child");
			baseMethod.selectDropdown(
					incident.getSearchDropDownAssignedToWindow(),
					assigenToDropDown);
			incident.getSearchAssignedToWindowEdit().sendKeys(assigneToName);
			baseMethod.actions();
			baseMethod.pageLoadWait();
			baseMethod.selectFromList(incident.getAssignedToWindowNameList(),
					assigneToName);
			baseMethod.switchTo().defaultContent();
			baseMethod.switchToFrame("gsft_main");
			incident.getSaveButton().click();
			baseMethod.pageLoadWait();
			incident.getWorkNotesEdit().sendKeys(workNotes);
			incident.getSaveButton().click();
			baseMethod.pageLoadWait();
		} else if (expectedStatus.equalsIgnoreCase("On Hold")) {

			baseMethod.selectDropdown(incident.getStateDropDown(),
					expectedStatus);
			baseMethod.selectDropdown(incident.getOnHoldReasonDropDown(),
					expectedStatus);
			incident.getAdditionalCommentsEdit().sendKeys(additionalComments);
		} else if (expectedStatus.equalsIgnoreCase("Resolved")) {

			baseMethod.selectDropdown(incident.getStateDropDown(),
					expectedStatus);
			try {

				incident.getCloseNotesEdit().sendKeys(closerCode);
				baseMethod.selectDropdown(incident.getCloseCodeDropDown(),
						expectedCloseCode);
			} catch (NoSuchElementException e) {

				incident.getClosureInformationTab().click();
				incident.getCloseNotesEdit().sendKeys(closerCode);
				baseMethod.selectDropdown(incident.getCloseCodeDropDown(),
						expectedCloseCode);

			}
		} else {

		}

		incident.getSubmitButton().click();

	}
/**
 * 
 * @param assigneToName
 * @throws InterruptedException
 */
	public void inProgress(String assigneToName)
			throws InterruptedException {

		IM_Repository incident = PageFactory.initElements(Driver.driver,
				IM_Repository.class);

		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");
	String parent=	baseMethod.getWindowHandle();
		incident.getAssignedtoLookUpWindow().click();
		baseMethod.switchToWindow("child");
		baseMethod.pageLoadWait();
		baseMethod.selectDropdown(incident.getSearchDropDownAssignedToWindow(),
				"Name");
		Thread.sleep(1000);
		incident.getSearchAssignedToWindowEdit().sendKeys(assigneToName);
		Thread.sleep(2000);
		baseMethod.actions();
		baseMethod.pageLoadWait();
		Thread.sleep(2000);
		baseMethod.selectFromList(incident.getAssignedToWindowNameList(),assigneToName);
		baseMethod.switchTo().window(parent);
		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");
		baseMethod.pageLoadWait();
		incident.getSaveButton().click();
		baseMethod.pageLoadWait();
		incident.getUpdateButton().click();

	}
/**
 * 
 * @param onholdStatus
 * @param additionalComments
 * @throws InterruptedException
 */
	public void onHold(String onholdStatus, String additionalComments) throws InterruptedException {

		IM_Repository incident = PageFactory.initElements(Driver.driver,
				IM_Repository.class);

		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");
		
		baseMethod.pageLoadWait();
		baseMethod.selectDropdown(incident.getStateDropDown(), "On Hold");
		Thread.sleep(5000);
		baseMethod.selectDropdown(incident.getOnHoldReasonDropDown(),
				onholdStatus);
		Thread.sleep(2000);
		incident.getAdditionalCommentsEdit().sendKeys(additionalComments);
		Thread.sleep(2000);
		incident.getUpdateButton().click();
	}
/**
 * 
 * @param expectedCloseCode
 * @param closeNotes
 * @param expectedDepartment
 * @param expectedRCA
 * @param expectedResolutionCategory
 * @param expectedResolutionCode
 * @throws InterruptedException
 */
	public void resolved(String expectedCloseCode, String closeNotes,String expectedDepartment,String expectedRCA,String expectedResolutionCategory,String expectedResolutionCode) throws InterruptedException {
		IM_Repository incident = PageFactory.initElements(Driver.driver,
				IM_Repository.class);

		baseMethod.switchTo().defaultContent();
		baseMethod.switchToFrame("gsft_main");

		
		baseMethod.selectDropdown(incident.getStateDropDown(), "In Progress");
		incident.getSaveButton().click();
		baseMethod.pageLoadWait();
		baseMethod.selectDropdown(incident.getStateDropDown(), "Resolved");
		incident.getDescriptionEdit().sendKeys("Test");
		Thread.sleep(2000);
		incident.getNotesTable().click();
	    	
		try {
						
			incident.getClosureInformationTab().click();
			Thread.sleep(2000);
			baseMethod.selectDropdown(incident.getDepartmentClosureInformationDropDown(),
					expectedDepartment);
			Thread.sleep(3000);
			baseMethod.selectDropdown(incident.getResolutionCategoryClosureInformationDropDown(), expectedResolutionCategory);
			Thread.sleep(3000);
			baseMethod.selectDropdown(incident.getResolutionCodeClosureInformationDropDown(), expectedResolutionCode);
			Thread.sleep(3000);
			baseMethod.selectDropdown(incident.getRcaClosureInformationDropDown(),
					expectedRCA);
			baseMethod.selectDropdown(incident.getCloseCodeDropDown(),
					expectedCloseCode);
			incident.getCloseNotesEdit().sendKeys(closeNotes);
			
			
		} catch (Exception e) {
			
			
		}
		incident.getUpdateButton().click();
		baseMethod.pageLoadWait();
//		incident.getCloseIncidentButton().click();
//		baseMethod.pageLoadWait();
	}

}