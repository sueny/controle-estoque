package testing.pageobject;

import org.openqa.selenium.WebDriver;

import testing.util.DriverProvider;
import testing.util.Routes;

public class TelaInicioConsig {
	private WebDriver driver;
	
	public TelaInicioConsig(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_CONSIG);
	}
	
}
