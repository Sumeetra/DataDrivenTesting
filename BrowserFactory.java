package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.BasePage;

public class BrowserFactory extends BasePage {
		static WebDriver driver;
		
		
		public static WebDriver startBrowser() {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
			driver.get("http://techfios.com/test/billing/?ng=login/");
			return driver;
		}
}
