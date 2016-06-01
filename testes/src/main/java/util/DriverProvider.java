package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {
	
	public static WebDriver getInstance(){
		WebDriver driver;
		//System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		System.out.println("driver created");
		return driver;
	}

}
