package testing.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import testing.uicomponent.MdSelect;
import testing.util.DriverProvider;
import testing.util.Routes;
import testing.util.Utils;

public class TelaCliente extends TelaSistema{

	public TelaCliente(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_CLIENTE);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
	
	public void preencheForm(boolean validData){
		new MdSelect(driver.findElement(By.name("typeClient")), driver).selectItem(0);
		Utils.sleep(1000);
		driver.findElement(By.name("nomeClient")).clear();
		driver.findElement(By.name("cpfClient")).clear();
		if(validData){
			driver.findElement(By.name("nomeClient")).sendKeys("Cliente teste "+Utils.getRandomId());
			driver.findElement(By.name("cpfClient")).sendKeys(Utils.getRandomNumString(11));
		}
		driver.findElement(By.name("rgClient")).sendKeys(Utils.getRandomNumString(9));
        driver.findElement(By.name("phoneNumberClient")).sendKeys(Utils.getRandomNumString(11));
        driver.findElement(By.name("cellNumberClient")).sendKeys(Utils.getRandomNumString(11));
        driver.findElement(By.name("addressClient")).sendKeys("Rua dos bobos");
        driver.findElement(By.name("neighborhoodClient")).sendKeys("Setor 8");
		driver.findElement(By.name("numberClient")).sendKeys(Utils.getRandomNumString(4));
		driver.findElement(By.name("cityClient")).sendKeys("Campinas");
		new MdSelect(driver.findElement(By.name("stateClient")), driver).selectItem(1);
		driver.findElement(By.name("cepClient")).sendKeys(Utils.getRandomNumString(8));
		driver.findElement(By.name("emailClient")).clear();
		driver.findElement(By.name("emailClient")).sendKeys("example"+Utils.getRandomNumString(6)+"@host.com");
		driver.findElement(By.name("obsClient")).sendKeys("lorem ipsum dolor sit amet");
	}
	
	public void selecionaItem(){
		driver.findElement(By.name("btnListar")).click();
		List<WebElement> list = driver.findElements(By.className("item-client"));
		if(list.size() == 0)
			throw new RuntimeException("Não foi possível encontrar um cliente na listagem de clientes da tela cadastro de cliente");
		list.get(0).click();
	}
	
	public boolean isSaveSuccessMessageDisplayed() {
		return super.checaEFechaMensage("com sucesso");
	}
	
	public boolean isDeleteSuccessMessageDisplayed(){
		return super.checaEFechaMensage("com sucesso");
	}
	
	public void clicaSalvar(){
		try{
			driver.findElement(By.name("btnCadastrarClient")).click();
		}catch(ElementNotVisibleException e){
			driver.findElement(By.name("btnAlterarClient")).click();
		}
	}
	
	public void clicaExcluir(){
		driver.findElement(By.name("btnExcluirClient")).click();
	}
	
	public void limpa(){
		driver.findElement(By.name("btnLimparForm")).click();
	}

	public void finaliza() {
		driver.close();
	}
	
}
