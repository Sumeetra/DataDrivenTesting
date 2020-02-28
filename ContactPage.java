package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactPage extends BasePage {
	WebDriver driver;	
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		}
	
	//Element Library
	@FindBy(how = How.ID, using = "account")
	WebElement FullName;
	@FindBy(how = How.ID, using = "company")
	WebElement Company;
	@FindBy(how = How.ID, using = "email")
	WebElement Email;
	@FindBy(how = How.ID, using = "phone")
	WebElement Phone;
	@FindBy(how = How.ID, using = "address")
	WebElement Address;
	@FindBy(how = How.ID, using = "city")
	WebElement City;
	@FindBy(how = How.ID, using = "state")
	WebElement State;
	@FindBy(how = How.ID, using = "zip")
	WebElement Zip;
	@FindBy(how = How.ID, using = "submit")
	WebElement Submit;
	
	public void fillContactForm(String account, String company, String email, String phone, String address, String city, String state, String zip ) {
	FullName.sendKeys(account);	
	Company.sendKeys(company);
	Email.sendKeys(email);
	Phone.sendKeys(phone);
	Address.sendKeys(address);
	City.sendKeys(city);
	State.sendKeys(state);
	Zip.sendKeys(zip);	
	}
	
	public void clickSubmitButton () {
		Submit.click();
	}
}
