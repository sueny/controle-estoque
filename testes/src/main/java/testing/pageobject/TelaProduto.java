package testing.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testing.uicomponent.MdSelect;
import testing.util.DriverProvider;
import testing.util.Utils;

public class TelaProduto {

	private WebDriver driver;
	
	public TelaProduto(){
		this.driver = DriverProvider.getInstance();
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
		new MdSelect(driver.findElement(By.name("sizeProduto")), driver).selectItem(i);
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
		String text = "Cadastrado";
		List<WebElement> list = driver.findElements(Utils.byText(text));
		return list.size() > 0;
	}
	
	public boolean isDeleteSuccessMessageDisplayed(){
		String text = "excluído";
		List<WebElement> list = driver.findElements(Utils.byText(text));
		return list.size() > 0;
	}
	
	public void setNomeMateriaPrima(String nome){
		driver.findElement(By.name("nameMateriaPrima")).sendKeys(nome);
	}
	
	public void setQtdeMateriaPrima(int qtde){
		driver.findElement(By.name("quantityMateriaPrima")).sendKeys(qtde+"");
	}
	
	public void addMateriaPrima(){
		driver.findElement(By.name("addMateriaPrima")).click();
	}
	
	
}
