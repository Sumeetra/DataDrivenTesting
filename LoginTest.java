package test2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	
	ExcelReader reader = new ExcelReader("./data/Book1.xlsx");
	
	String username = reader.getCellData("Sheet1", "Username", 2);
	String password = reader.getCellData("Sheet1", "Password", 2);

	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.startBrowser();
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
	}

		
	@AfterMethod
	public void closeBrowser() {
		
		
	}
	}
