package com.izt.snow.automation.incidentmanagement;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.izt.snow.automation.functionLibrary.Common;
import com.izt.snow.automation.functionLibrary.Filter_Navigator;
import com.izt.snow.automation.functionLibrary.Incident_Management;
import com.izt.snow.automation.webdriver.BaseClass;
import com.izt.snow.automation.webdriver.Driver;

public class test {

	BaseClass baseMethod;
	Incident_Management incident;
	Common com;
	Filter_Navigator filter;

	@BeforeClass
	public void beforeClass() throws EncryptedDocumentException,
			InvalidFormatException, IOException {
		baseMethod = new BaseClass();
		incident = new Incident_Management();
		com = new Common();
		filter=new Filter_Navigator();
		
		String url = baseMethod.getExcelData("Credentials", 1, 3);

		Driver.getDriver("firefox");
		Driver.driver.get(url);
		Driver.driver.manage().window().maximize();

	}

	@BeforeMethod
	public void beforeMethod() throws EncryptedDocumentException,
			InvalidFormatException, IOException, InterruptedException {

		String username = baseMethod.getExcelData("Credentials", 1, 1);
		String password = baseMethod.getExcelData("Credentials", 1, 2);
		com.login(username, password);
		baseMethod.pageLoadWait();
		Thread.sleep(23000);

	}

	@Test(priority=1)
	public void createNewIncident() throws EncryptedDocumentException,
			InvalidFormatException, IOException, InterruptedException {

		
		filter.navigator("incident", "Create New");
		
		String callerName = baseMethod.getExcelData("Incident", 1, 2);
		String contactType = baseMethod.getExcelData("Incident", 1, 3);
		String impact = baseMethod.getExcelData("Incident", 1, 4);
		String urgency = baseMethod.getExcelData("Incident", 1, 5);
		String category = baseMethod.getExcelData("Incident", 1, 6);
		String subCategory = baseMethod.getExcelData("Incident", 1, 7);

		incident.createNewIncident(callerName, contactType, impact, urgency,
				category, subCategory);
		baseMethod.pageLoadWait();
		String ticket = baseMethod.getExcelData("Incident", 1, 1);
		filter.searchTicket(ticket);
		
		
		String assignedGroup = "IT AnyTime Support";
		incident.incidentValidation(ticket, callerName, assignedGroup);
		String actual = baseMethod.getExcelData("Incident", 1, 8);
		String expected = "Pass";
		Assert.assertEquals(actual, expected);

	}
	@Test(priority=2)
	public void inProgress() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		filter.navigator("incident", "All");
		String ticket = baseMethod.getExcelData("Incident", 1, 1);
		filter.openExistingTicket(ticket);
		
		baseMethod.pageLoadWait();
		String assigneToName = "Test Agent";
		String workNotes = "TEST INCIDENT";
		incident.inProgress(assigneToName);
		
		baseMethod.pageLoadWait();
		filter.openExistingTicket(ticket);
		
		baseMethod.pageLoadWait();
		String onholdStatus="Awaiting Caller";
		String additionalComments="Test Comments";
		incident.onHold(onholdStatus, additionalComments);
		
		baseMethod.pageLoadWait();
		filter.openExistingTicket(ticket);
		
		baseMethod.pageLoadWait();
		String expectedCloseCode="Solved (Work Around)";
		String closeNotes="Solved ";
		String expectedDepartment ="IT";
		String expectedRCA ="Defect";
		String expectedResolutionCategory="IT Internal";
		String expectedResolutionCode="Other";
		incident.resolved(expectedCloseCode, closeNotes, expectedDepartment, expectedRCA, expectedResolutionCategory, expectedResolutionCode);
		
	
	}
		
	@AfterMethod
	public void afterMethod(ITestResult t) throws InterruptedException,
			IOException {

		if (t.isSuccess()) {

			com.logout();
		} else {

			String fileName = t.getMethod().getMethodName();
			baseMethod.getScreenShot(fileName);
			com.logout();
		}

	}

	@AfterClass
	public void afterClass() {

	//	baseMethod.quit();

	}

}