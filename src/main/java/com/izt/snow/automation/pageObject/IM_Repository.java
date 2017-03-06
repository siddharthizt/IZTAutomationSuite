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
/* Incident Management Web Elements */
public class IM_Repository {

	@FindBy(xpath="//div[label[span[contains(text(),'Number')]]]/following-sibling::div/input[@id='sys_readonly.incident.number']")
	private WebElement incidentNumberValueAttribute;
	
	@FindBy(xpath = "//input[@id='sys_display.incident.caller_id']")
	private WebElement callerEdit;

	@FindBy(xpath = "//a[@id='lookup.incident.caller_id']/span[1]")
	private WebElement callerLookUpListSearch;

	@FindAll({ @FindBy(xpath = "//tbody[@class='list2_body']/tr/td/a") })
	private List<WebElement> callerWindowList;

	@FindBy(xpath = "//div[a[h1[contains(text(),'Users')]]]/following-sibling::span/descendant::input[@placeholder='Search']")
	private WebElement callerWindowSearchEdit;

	@FindBy(xpath = "//input[@id='incident.u_preferred_contact_number']")
	private WebElement preferredContactNumberEdit;

	@FindBy(xpath = "//select[@id='incident.category']")
	private WebElement categoryDropDown;

	@FindBy(xpath = "//select[@id='incident.subcategory']")
	private WebElement subCategoryDropDown;

	@FindBy(xpath = "//input[@id='sys_display.incident.u_vendor']")
	private WebElement vendorEdit;

	@FindBy(xpath = "//div[label[span[contains(text(),'Vendor')]]]/following-sibling::div/div/span/a")
	private WebElement vendorLookUpListWindow;

	@FindBy(xpath = "//input[@id='sys_display.incident.business_service']")
	private WebElement businessServiceEdit;

	@FindBy(xpath = "//input[@id='sys_display.incident.business_service']/following-sibling::span/a")
	private WebElement businessServicesLookUpListWindow;

	@FindBy(xpath = "//input[@id='sys_display.incident.cmdb_ci']")
	private WebElement configurationItemEdit;

	@FindBy(xpath = "//input[@id='sys_display.incident.cmdb_ci']/following-sibling::span/a")
	private WebElement configurationItemLookUpWindow;

	@FindBy(xpath = "//input[@id='incident.short_description']")
	private WebElement shortDescriptionEdit;

	@FindBy(xpath = "//textarea[@id='incident.description']")
	private WebElement descriptionEdit;

	@FindBy(xpath = "//input[@id='sys_display.incident.assigned_to']")
	private WebElement assignedToEdit;

	@FindBy(xpath = "//input[@id='sys_display.incident.assigned_to']/following-sibling::span/a")
	private WebElement assignedtoLookUpWindow;

	@FindBy(xpath = "//input[@id='sys_display.incident.assignment_group']")
	private WebElement AssignmentGroupLookUpWindow;

	@FindBy(xpath = "//select[@id='incident.urgency']")
	private WebElement urgencyDropDown;

	@FindBy(xpath = "//select[@id='incident.impact']")
	private WebElement impactDropDown;

	@FindBy(xpath = "//select[@id='incident.state']")
	private WebElement stateDropDown;

	@FindBy(xpath = "//select[@id='incident.contact_type']")
	private WebElement contactTypeDropDown;

	@FindBy(xpath = "//div[@id='tabs2_section']/span/span/span[contains(text(),'Notes')]")
	private WebElement notesTab;

	@FindBy(xpath="//span[contains(text(),'Notes')]")
	private WebElement notesTable;
	
	@FindBy(xpath = "//div[@id='tabs2_section']/span/span/span[contains(text(),'Related')]")
	private WebElement relatedRocordsTab;

	@FindBy(xpath = "//*[@id='tabs2_section']/span[3]/span/span[2]")
	private WebElement closureInformationTab;

	@FindBy(xpath = "//textarea[@id='activity-stream-comments-textarea']")
	private WebElement additionalCommentsEdit;

	@FindBy(xpath = "//textarea[@id='activity-stream-textarea']")
	private WebElement workNotesEdit;

	@FindBy(xpath = "//span[@class='navbar_ui_actions']/button[@id='sysverb_update_and_stay']")
	private WebElement saveButton;

	@FindBy(xpath = "//span[@class='navbar_ui_actions']/button[contains(text(),'Submit')]")
	private WebElement submitButton;

	@FindBy(xpath="//span[@class='navbar_ui_actions']/button[@id='sysverb_update']")
	private WebElement updateButton;
	
	@FindBy(xpath = "//div[@id='group_tree']/descendant::td[@class='tree_item_text']")
	private WebElement assignmentGroupWindowList;

	@FindBy(xpath = "//div[a[h1[contains(text(),'Users')]]]/following-sibling::span/descendant::select")
	private WebElement searchDropDownAssignedToWindow;

	@FindBy(xpath = "//div[a[h1[contains(text(),'Users')]]]/following-sibling::span/descendant::input[@placeholder='Search']")
	private WebElement searchAssignedToWindowEdit;

	@FindAll({@FindBy(xpath = "//tbody[@class='list2_body']/tr/td[3]/a")})
	private List<WebElement> assignedToWindowNameList;


	@FindBy(xpath = "//select[@id='incident.hold_reason']")
	private WebElement onHoldReasonDropDown;

	@FindBy(xpath = "//textarea[@id='incident.close_notes']")
	private WebElement closeNotesEdit;

	@FindBy(xpath = "//select[@id='incident.close_code']")
	private WebElement closeCodeDropDown;

	@FindBy(xpath="//span[@class='navbar_ui_actions']/button[@id='close_incident']")
	private WebElement closeIncidentButton;
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement callerWindowDropDown;
	
	@FindBy(xpath="//select[@id='incident.u_department']")
	private WebElement departmentClosureInformationDropDown;
	
	@FindBy(xpath="//select[@id='incident.u_rca']")
	private WebElement rcaClosureInformationDropDown;
	
	@FindBy(xpath="//select[@id='incident.u_resolution_category']")
	private WebElement resolutionCategoryClosureInformationDropDown;
	
	@FindBy(xpath="//select[@id='incident.u_resolution_code']")
	private WebElement resolutionCodeClosureInformationDropDown;
	
	@FindBy(xpath="//select[@id='incident.u_module']")
	private WebElement moduleClosureInformationDropDown;
	
	@FindBy(xpath="//select[@id='incident.u_journey']")
	private WebElement journeyClosureInformationDropDown;
	
	
	
	
	public WebElement getNotesTable() {
		return notesTable;
	}

	public WebElement getResolutionCategoryClosureInformationDropDown() {
		return resolutionCategoryClosureInformationDropDown;
	}

	public WebElement getResolutionCodeClosureInformationDropDown() {
		return resolutionCodeClosureInformationDropDown;
	}

	public WebElement getModuleClosureInformationDropDown() {
		return moduleClosureInformationDropDown;
	}

	public WebElement getJourneyClosureInformationDropDown() {
		return journeyClosureInformationDropDown;
	}

	public WebElement getDepartmentClosureInformationDropDown() {
		return departmentClosureInformationDropDown;
	}

	public WebElement getRcaClosureInformationDropDown() {
		return rcaClosureInformationDropDown;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getCallerWindowDropDown() {
		return callerWindowDropDown;
	}

	public WebElement getCloseIncidentButton() {
		return closeIncidentButton;
	}

	public List<WebElement> getAssignedToWindowNameList() {
		return assignedToWindowNameList;
	}

	public WebElement getIncidentNumberValueAttribute() {
		return incidentNumberValueAttribute;
	}

	public WebElement getCallerEdit() {
		return callerEdit;
	}

	public WebElement getCallerLookUpListSearch() {
		return callerLookUpListSearch;
	}

	public List<WebElement> getCallerWindowList() {
		return callerWindowList;
	}

	public WebElement getCallerWindowSearchEdit() {
		return callerWindowSearchEdit;
	}

	public WebElement getPreferredContactNumberEdit() {
		return preferredContactNumberEdit;
	}

	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}

	public WebElement getSubCategoryDropDown() {
		return subCategoryDropDown;
	}

	public WebElement getVendorEdit() {
		return vendorEdit;
	}

	public WebElement getVendorLookUpListWindow() {
		return vendorLookUpListWindow;
	}

	public WebElement getBusinessServiceEdit() {
		return businessServiceEdit;
	}

	public WebElement getBusinessServicesLookUpListWindow() {
		return businessServicesLookUpListWindow;
	}

	public WebElement getConfigurationItemEdit() {
		return configurationItemEdit;
	}

	public WebElement getConfigurationItemLookUpWindow() {
		return configurationItemLookUpWindow;
	}

	public WebElement getShortDescriptionEdit() {
		return shortDescriptionEdit;
	}

	public WebElement getDescriptionEdit() {
		return descriptionEdit;
	}

	public WebElement getAssignedToEdit() {
		return assignedToEdit;
	}

	public WebElement getAssignedtoLookUpWindow() {
		return assignedtoLookUpWindow;
	}

	public WebElement getAssignmentGroupLookUpWindow() {
		return AssignmentGroupLookUpWindow;
	}

	public WebElement getUrgencyDropDown() {
		return urgencyDropDown;
	}

	public WebElement getImpactDropDown() {
		return impactDropDown;
	}

	public WebElement getStateDropDown() {
		return stateDropDown;
	}

	public WebElement getContactTypeDropDown() {
		return contactTypeDropDown;
	}

	public WebElement getNotesTab() {
		return notesTab;
	}

	public WebElement getRelatedRocordsTab() {
		return relatedRocordsTab;
	}

	public WebElement getClosureInformationTab() {
		return closureInformationTab;
	}

	public WebElement getAdditionalCommentsEdit() {
		return additionalCommentsEdit;
	}

	public WebElement getWorkNotesEdit() {
		return workNotesEdit;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getAssignmentGroupWindowList() {
		return assignmentGroupWindowList;
	}

	public WebElement getSearchDropDownAssignedToWindow() {
		return searchDropDownAssignedToWindow;
	}

	public WebElement getSearchAssignedToWindowEdit() {
		return searchAssignedToWindowEdit;
	}



	public WebElement getOnHoldReasonDropDown() {
		return onHoldReasonDropDown;
	}

	public WebElement getCloseNotesEdit() {
		return closeNotesEdit;
	}

	public WebElement getCloseCodeDropDown() {
		return closeCodeDropDown;
	}

}
