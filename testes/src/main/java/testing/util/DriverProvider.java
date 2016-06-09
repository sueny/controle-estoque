package testing.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverProvider {
	
	//private static WebDriver instance;
	
	public static WebDriver getInstance(){
		//if(instance == null){
			//System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			WebDriver  instance = new FirefoxDriver();
		//}
		return instance;
	}

}
