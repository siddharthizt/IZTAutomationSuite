package com.izt.snow.automation.incidentmanagement;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;

import com.izt.snow.automation.webdriver.Driver;

public class iztvirtusa {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		
		
		
		Incident inc=new Incident();
		inc.createNewIncident();
	}

}
