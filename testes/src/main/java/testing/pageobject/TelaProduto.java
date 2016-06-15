package testing.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testing.uicomponent.MdSelect;
import testing.util.DriverProvider;
import testing.util.Routes;
import testing.util.Utils;

public class TelaProduto {

	private WebDriver driver;
	
	public TelaProduto(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_PRODUTO);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	public void finaliza(){
		driver.close();
	}
	
	public void setModeloProduto(int i){
		new MdSelect(driver.findElement(By.name("modeloProduto")), driver).selectItem(i);
	}
	
	public void setSkuProduto(String str){
		driver.findElement(By.name("modeloProduto")).sendKeys(str);
	}
	
	public void setNomeProduto(String str){
		driver.findElement(By.name("nomeProduto")).sendKeys(str);
	}
	
	public void setSizeProduto(int i){
		//new MdSelect(driver.findElement(By.name("sizeEnumProduto")), driver).selectItem(i);
		new Select(driver.findElement(By.name(".sizeEnumProduto"))).getOptions().get(i).click();
	}
	
	public void setVariationProduto(String text){
		driver.findElement(By.name("variationProduto")).sendKeys(text);
	}
	
	public void clicaLimpar(){
		driver.findElement(By.name("btnLimpar")).click();
	}
	
	public void clicaCadastrar(){
		driver.findElement(By.name("btnCadastrarProduto")).click();
	}
	
	public void clicaExcluir(){
		driver.findElement(By.name("btnExcluirProduto")).click();
	}
	
	public void confirmaExcluir(){
		driver.findElement(By.tagName("md-dialog")).findElement(Utils.byText("Sim")).click();
	}
	
	public void cancelaExcluir(){
		driver.findElement(By.tagName("md-dialog")).findElement(Utils.byText("Não")).click();
	}

	public boolean isSaveSuccessMessageDisplayed() {
		String text = "Produto cadastrado";
		List<WebElement> list = driver.findElements(Utils.byText(text));
		boolean displayed = list.size() > 0 && list.get(0).isDisplayed();
		if(displayed){
			driver.findElement(By.className("btn-close-toast")).click();
		}
		return displayed;
	}
	
	public boolean isDeleteSuccessMessageDisplayed(){
		String text = "excluído";
		List<WebElement> list = driver.findElements(Utils.byText(text));
		boolean displayed = list.size() > 0 && list.get(0).isDisplayed();
		if(displayed){
			driver.findElement(By.className("btn-close-toast")).click();
		}
		return displayed;
	}
	
	public void escolheMateriaPrima(int i){
		driver.findElement(By.name("nameMateriaPrima")).click();
		Utils.sleep(500);
		driver.findElements(By.className("item-material")).get(i).click();
		//driver.findElement(By.name("nameMateriaPrima")).sendKeys(nome);
	}
	
	public void setQtdeMateriaPrima(int qtde){
		driver.findElement(By.name("quantityMateriaPrima")).sendKeys(qtde+"");
	}
	
	public void addMateriaPrima(){
		driver.findElement(By.name("addMateriaPrima")).click();
	}

	public void selecionaProduto() {
		driver.findElement(By.id("btnListar")).click();
		List<WebElement> list = driver.findElements(By.className("item-product"));
		list.get(0).click();
	}

	public void clicaAlterar() {
		driver.findElement(By.name("btnAlterarProduto")).click();
	}
	
	
}
