package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
	
	WebDriver driver; //Global
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	//Element Library
	@FindBy(how = How.ID, using = "username")
	WebElement UserName;
	@FindBy(how = How.ID, using = "password")
	WebElement Password;
	@FindBy(how = How.NAME, using = "login")
	WebElement SignInButton;
	
	public void enterUsername (String userName) {
		UserName.sendKeys(userName);
	}
	public void enterPassword (String passWord) {	
		Password.sendKeys(passWord);
	}	
	public void clickSignIn () {	
		SignInButton.click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
}
