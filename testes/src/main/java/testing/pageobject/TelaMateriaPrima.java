package testing.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testing.util.DriverProvider;
import testing.util.Routes;

public class TelaMateriaPrima extends TelaSistema{

	private WebElement 
		txtNome, 
		txtSku, 
		txtDescription,
		btnCadastro,
		btnExcluir;
	
	private Select selUnidade;//, selCategoria;
	
	
	public TelaMateriaPrima(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_MATERIA_PRIMA);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		this.txtNome = 			driver.findElement(By.name("nomeMateriaPrima"));
		this.txtSku = 			driver.findElement(By.name("skuMateriaPrima"));
		this.selUnidade = 		new Select(driver.findElement(By.name(".unidadeMateriaPrima")));
		//this.selCategoria = 	new Select(driver.findElement(By.name("categoriaMateriaPrima")));
		this.txtDescription = 	driver.findElement(By.name("observacaoMateriaPrima"));
		this.btnCadastro =		driver.findElement(By.name("btnCadastrarMateriaPrima"));
		this.btnExcluir = 		driver.findElement(By.name("btnExcluirMateriaPrima"));
	}
	
	public void confirmDeletion() {
		driver.findElement(By.name("btnConfirmaExclusao")).click();
	}

	public void cancelDeletion() {
		driver.findElement(By.name("btnCancelaExclusao")).click();
	}
	
	private void sleep(long x){
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement selectItem(String sku){
		WebElement e = driver.findElement(By.partialLinkText(sku));
		e.click();
		sleep(50);
		final WebElement iconWait = driver.findElement(By.id("iconAguarde"));
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !iconWait.isDisplayed();
            }
        });
		return e;
	}
	
	public boolean isSaveSuccessMessageDisplayed(){
		return super.checkAndCloseMessage("Cadastro realizado");
	}
	
	//A message with id="msgSucesso" must be displayed
	public boolean isDeletionSuccessMessageDisplayed(){
		return super.checkAndCloseMessage("excluída");
	}
	
	public WebElement getTxtNome() {
		return txtNome;
	}

	public WebElement getTxtSku() {
		return txtSku;
	}

	public WebElement getTxtDescription() {
		return txtDescription;
	}

	public WebElement getBtnCadastro() {
		return btnCadastro;
	}

	public WebElement getBtnExcluir() {
		return btnExcluir;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Select getSelUnidade() {
		return selUnidade;
	}

	public WebElement getBtnLimpar() {
		return driver.findElement(By.name("btnLimpar"));
	}

	
}
