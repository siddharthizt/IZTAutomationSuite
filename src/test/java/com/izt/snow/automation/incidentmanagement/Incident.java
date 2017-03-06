package com.izt.snow.automation.incidentmanagement;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.izt.snow.automation.functionLibrary.Common;
import com.izt.snow.automation.functionLibrary.Filter_Navigator;
import com.izt.snow.automation.functionLibrary.Incident_Management;
import com.izt.snow.automation.webdriver.BaseClass;
import com.izt.snow.automation.webdriver.Driver;

/**
 * 
 * @author Bharath
 * 
 */
/**
 * 
 * Step 1: Login to Application 
 * Step 2: Navigate to Create New Incident 
 * Step 3: Create New Incident 
 * Step 4: Change Status to Inprogress Step 5: Change Status to On Hold 
 * Step 6: Change Status to In progress and Resolved
 * 
 * 
 */
public class Incident {

	/* Intializing objects */
	BaseClass baseMethod;
	Incident_Management incident;
	Common com;
	Filter_Navigator filter;

	@BeforeClass
	public void beforeClass() throws EncryptedDocumentException,
			InvalidFormatException, IOException {
		/* Creating Objects */
		baseMethod = new BaseClass();
		incident = new Incident_Management();
		com = new Common();
		filter = new Filter_Navigator();

		/* intializing Browser Object and Navigating to Application Login Page */
		String url = baseMethod.getExcelData("Credentials", 1, 3);
		Driver.getDriver("firefox");
		Driver.driver.get(url);
		Driver.driver.manage().window().maximize();

	}

	@BeforeMethod
	public void beforeMethod() throws EncryptedDocumentException,
			InvalidFormatException, IOException, InterruptedException {
		/* Logging to Application */
		String username = baseMethod.getExcelData("Credentials", 1, 1);
		String password = baseMethod.getExcelData("Credentials", 1, 2);
		com.login(username, password);
		baseMethod.pageLoadWait();
		Thread.sleep(23000);

	}

	@Test(priority = 1)
	public void createNewIncident() throws EncryptedDocumentException,
			InvalidFormatException, IOException, InterruptedException {

		/* Navigating to Create New Incident Page */
		filter.navigator("incident", "Create New");
		/* Fetching Data from Excel Sheet */
		String callerName = baseMethod.getExcelData("Incident", 1, 2);
		String contactType = baseMethod.getExcelData("Incident", 1, 3);
		String impact = baseMethod.getExcelData("Incident", 1, 4);
		String urgency = baseMethod.getExcelData("Incident", 1, 5);
		String category = baseMethod.getExcelData("Incident", 1, 6);
		String subCategory = baseMethod.getExcelData("Incident", 1, 7);
		/* Creating New Incident */
		incident.createNewIncident(callerName, contactType, impact, urgency,
				category, subCategory);
		baseMethod.pageLoadWait();

		/* Filtering Created Incident */
		String ticket = baseMethod.getExcelData("Incident", 1, 1);
		filter.searchTicket(ticket);
		/*
		 * Validating Created Incident with Caller and Assigned Group
		 * Information using Asserts
		 */
		String assignedGroup = "IT AnyTime Support";
		incident.incidentValidation(ticket, callerName, assignedGroup);
		String actual = baseMethod.getExcelData("Incident", 1, 8);
		String expected = "Pass";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 2)
	public void inProgress() throws InterruptedException,
			EncryptedDocumentException, InvalidFormatException, IOException {
		/* Navigating to All Incident Page */
		filter.navigator("incident", "All");

		/* Opens Existing Incident using Incident Number */
		String ticket = baseMethod.getExcelData("Incident", 1, 1);
		filter.openExistingTicket(ticket);

		baseMethod.pageLoadWait();
		String assigneToName = baseMethod.getExcelData("Incident", 1, 9);
		/* Changing Status to In Progress */
		incident.inProgress(assigneToName);

		baseMethod.pageLoadWait();
		filter.openExistingTicket(ticket);
		/* Changing Status to On Hold */
		baseMethod.pageLoadWait();
		String onholdStatus = baseMethod.getExcelData("Incident", 1, 10);
		String additionalComments = baseMethod.getExcelData("Incident", 1, 11);
		incident.onHold(onholdStatus, additionalComments);
		/* Changing Status to Resolved */
		baseMethod.pageLoadWait();
		filter.openExistingTicket(ticket);
		String expectedCloseCode = baseMethod.getExcelData("Incident", 1, 12);
		String closeNotes = baseMethod.getExcelData("Incident", 1, 13);
		String expectedDepartment = baseMethod.getExcelData("Incident", 1, 14);
		String expectedRCA = baseMethod.getExcelData("Incident", 1, 15);
		String ResolutionCategory = baseMethod.getExcelData("Incident", 1, 16);
		String ResolutionCode = baseMethod.getExcelData("Incident", 1, 17);
		incident.resolved(expectedCloseCode, closeNotes, expectedDepartment,
				expectedRCA, ResolutionCategory, ResolutionCode);

	}

	@AfterMethod
	public void afterMethod(ITestResult t) throws InterruptedException,
			IOException {

		if (t.isSuccess()) {
			/* Loging out from Application */
			com.logout();
		} else {
			/* Capturing Screen Shot if Error Occurs and Logout from Application */
			String fileName = t.getMethod().getMethodName();
			baseMethod.getScreenShot(fileName);
			com.logout();
		}

	}

	@AfterClass
	public void afterClass() {
		/* Closing all existing Browsers opended by WebDriver */
		 baseMethod.quit();

	}

}