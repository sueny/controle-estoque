package testing.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {
	
	private static WebDriver instance;
	
	public static WebDriver getInstance(){
		if(instance == null){
			//System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			instance = new FirefoxDriver();
			System.out.println("driver created");
		}
		return instance;
	}

}
