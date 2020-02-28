package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {
	
	WebDriver driver; // Global //

	// Every Page must have a constructor to invite the driver
	public DashboardPage(WebDriver driver) {
	this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//span[text() = 'CRM']")
	WebElement CRM;
	@FindBy(how = How.LINK_TEXT, using = "Add Contact")
	WebElement AddContactButton;

	// Methods to interact with the elements
	public void waitForPage() {
	waitForElement(CRM, driver);
	}
	
	public void clickOnCRMButton() {
	CRM.click();
	}
	
	public void clickOnAddContactButton() {
	AddContactButton.click();
	}

	public boolean isAddContactPageDisplayed() {
	try {
	waitForPage();
	return true;
	} catch (Exception e) {

	}
	return false;
	}
}
