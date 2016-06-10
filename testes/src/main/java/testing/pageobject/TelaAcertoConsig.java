package testing.pageobject;

import org.openqa.selenium.WebDriver;

import testing.util.DriverProvider;
import testing.util.Routes;

public class TelaAcertoConsig {
	private WebDriver driver;
	
	public TelaAcertoConsig(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_ACERTO);
	}
	
}
