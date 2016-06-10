package testing.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testing.util.DriverProvider;
import testing.util.Routes;
import testing.util.Utils;

public class TelaInicioConsig {
	private WebDriver driver;
	
	public TelaInicioConsig(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_CONSIG);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	public void selecionaCliente(int i){
		driver.findElements(By.className("item-customer")).get(i).click();
	}
	
	public void selecionaProduto(int i){
		driver.findElements(By.className("item-product")).get(i).click();
	}
	
	public void setQtde(int i){
		driver.findElement(By.name("quantity")).sendKeys(""+ i);
	}
	
	public void setValor(int i){
		driver.findElement(By.name("price")).sendKeys(""+ i);
	}
	
	public void setObs(String s){
		driver.findElement(By.name("obsConsignacao")).sendKeys(s);
	}
	
	public void finaliza(){
		driver.close();
	}
	
	public void cancelaConsig(){
		driver.findElement(By.name("btnLimparForm")).click();
	}
	
	public void cancelaProduto(){
		driver.findElement(By.name("btnCancelaProduto")).click();
	}
	
	public void salva(){
		driver.findElement(By.name("btnSalvar")).click();
	}
	
	public void adicionaProduto(){
		driver.findElement(By.name("btnAdicionaProduto")).click();
	}
	
	public boolean isSuccessMessageDisplayed(){
		String text = "sucesso";
		List<WebElement> list = driver.findElements(Utils.byText(text));
		return list.size() > 0;
	}
	
}
