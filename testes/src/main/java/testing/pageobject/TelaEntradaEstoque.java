package testing.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testing.util.DriverProvider;
import testing.util.Routes;
import testing.util.Utils;

public class TelaEntradaEstoque {
	
	private WebDriver driver;
	
	public TelaEntradaEstoque(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_ENTRADA);
	}
	
	public void selecionaProduto(int i){
		driver.findElements(By.className("item-product")).get(i).click();
	}
	
	public void envia(){
		driver.findElement(By.name("btnEntradaEstoque")).click();
	}
	
	public void setQtde(int v){
		driver.findElement(By.name("quantityEstoque")).sendKeys(""+v);
	}
	
	public void setValor(int v){
		driver.findElement(By.name("priceEstoque")).sendKeys(""+v);
	}
	
	public void setObservacao(String obs){
		driver.findElement(By.name("obsEstoque")).sendKeys(obs);
	}
	
	public void cancela(){
		driver.findElement(By.name("btnLimparForm")).click();
	}
	
	public boolean isSuccessMessageDisplayed(){
		String text = "sucesso";
		List<WebElement> list = driver.findElements(Utils.byText(text));
		return list.size() > 0;
	}
	
	public void finaliza(){
		this.driver.close();
	}

}
