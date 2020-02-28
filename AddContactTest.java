package test2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.BasePage;
import page.ContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest extends BasePage {
	

	ExcelReader reader = new ExcelReader("./data/Book1.xlsx");

	String username = reader.getCellData("Sheet1", "Username", 2);
	String password = reader.getCellData("Sheet1", "Password", 2);
	String account = reader.getCellData("Sheet1", "FullName", 2);
	String company = reader.getCellData("Sheet1", "Company", 2);
	String email = reader.getCellData("Sheet1", "Email", 2);
	String phone = reader.getCellData("Sheet1", "Phone", 2);
	String address = reader.getCellData("Sheet1", "Address", 2);
	String city = reader.getCellData("Sheet1", "City", 2);
	String state = reader.getCellData("Sheet1", "State", 2);
	String zip = reader.getCellData("Sheet1", "Zip", 2);

	@Test
	public void addContact() {
	WebDriver	driver = BrowserFactory.startBrowser();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		// Call the login method from the LoginPage Class
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSignIn();

		// Validate page show up using the title
		String expectedTitle = "Dashboard- TechFios Test Application - Billing"; // To store the actual title
		String actualTitle = loginPage.getPageTitle(); // To get and store the title
		System.out.println(actualTitle); // To print
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong page!");

		// Validate page show up using the Explicit Wait
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		// Object Reference
		dashboardPage.waitForPage();

		dashboardPage.clickOnCRMButton();
		dashboardPage.clickOnAddContactButton();

		ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
		contactPage.fillContactForm(account, company, email, phone, address, city, state, zip);
		contactPage.clickSubmitButton();

	}
}
