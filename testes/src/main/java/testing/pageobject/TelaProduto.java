package testing.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testing.components.MdSelect;
import testing.util.DriverProvider;

public class TelaProduto {

	private WebDriver driver;
	
	public TelaProduto(){
		this.driver = DriverProvider.getInstance();
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
	
	
}
