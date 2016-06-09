package testing.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testing.components.MdSelect;
import testing.util.DriverProvider;
import testing.util.Routes;
import testing.util.Utils;

public class TelaCliente {

	private WebDriver driver;
	 
	
	public TelaCliente(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_CLIENTE);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
	
	public void preencheForm(){
		new Select(driver.findElement(By.name(".typeClient"))).getOptions().get(1).click();
		
	    WebElement txtName = driver.findElement(By.name("nomeClient"));;
	    WebElement txtPhoneNumber = driver.findElement(By.name("phoneNumberClient"));
	    WebElement txtCellNumber = driver.findElement(By.name("cellNumberClient"));
	    WebElement txtAddress = driver.findElement(By.name("addressClient"));
	    WebElement txtNumber = driver.findElement(By.name("numberClient"));
	    WebElement txtNeighborhood = driver.findElement(By.name("neighborhoodClient"));
	    WebElement txtCity = driver.findElement(By.name("cityClient"));
	    MdSelect selState = new MdSelect(driver.findElement(By.name("stateClient")), driver);
	    WebElement txtZipCode = driver.findElement(By.name("cepClient"));
	    WebElement txtEmail  = driver.findElement(By.name("emailClient"));
	    WebElement txtObs = driver.findElement(By.name("obsClient"));
		
		txtName.sendKeys("Cliente teste "+Utils.getRandomId());
		driver.findElement(By.name("cpfClient")).sendKeys(Utils.getRandomNumString(11));
        driver.findElement(By.name("rgClient")).sendKeys(Utils.getRandomNumString(9));
		txtPhoneNumber.sendKeys(Utils.getRandomNumString(11));
		txtCellNumber.sendKeys(Utils.getRandomNumString(11));
		txtAddress.sendKeys("Rua dos bobos");
		txtNeighborhood.sendKeys("Setor 8");
		txtNumber.sendKeys(Utils.getRandomNumString(4));
		txtCity.sendKeys("Campinas");
		selState.selectItem(1);
		txtZipCode.sendKeys(Utils.getRandomNumString(8));
		txtEmail.sendKeys("example"+Utils.getRandomNumString(6)+"@host.com");
		txtObs.sendKeys("lorem ipsum dolor sit amet");
	}
	
	public void selecionaItem(){
		//TODO implementar
	}
	
	public boolean isSaveSuccessMessageDisplayed() {
		String text = "Cadastrado";
		List<WebElement> list = driver.findElements(Utils.byText(text));
		return list.size() > 0;
	}
	
	public boolean isDeleteSuccessMessageDisplayed(){
		String text = "excluído";
		List<WebElement> list = driver.findElements(Utils.byText(text));
		return list.size() > 0;
	}
	
	public void clicaSalvar(){
		driver.findElement(By.name("btnCadastrarClient")).click();
	}
	
	public void clicaExcluir(){
		driver.findElement(By.name("btnExcluirClient")).click();
	}
	
	public void limpaForm(){
		driver.findElement(By.name("btnLimparClient")).click();
	}

	public void finaliza() {
		driver.close();
	}
	
}
