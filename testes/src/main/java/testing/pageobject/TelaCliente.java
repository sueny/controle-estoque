package testing.pageobject;

import org.openqa.selenium.WebDriver;

import testing.util.DriverProvider;
import testing.util.Routes;

public class TelaCliente {

	private WebDriver driver;
	
	public TelaCliente(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_CLIENTE);
	}
	
	
}
