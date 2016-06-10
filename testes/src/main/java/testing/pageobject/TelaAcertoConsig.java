package testing.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testing.util.DriverProvider;
import testing.util.Routes;
import testing.util.Utils;

public class TelaAcertoConsig {
	private WebDriver driver;
	
	public TelaAcertoConsig(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_ACERTO);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	public void selecionaCliente(int i){
		driver.findElements(By.className("item-customer")).get(i).click();
	}
	
	public void selecionaConsig(int i){
		driver.findElements(By.className("item-consig")).get(i).click();
	}
	
	public void preencheQuantidades(){
		int numCampos = driver.findElements(By.name("nameProduct")).size();
		
		for(int i = 0 ; i < numCampos; i++){
			
			int retirado = Integer.parseInt(
					driver.findElement(By.id("quantityRetirado"+i)).getAttribute("value"));
			driver.findElement(By.id("quantityAcerto"+i)).sendKeys(""+(retirado/2));
			
		}
	}
	
	public void finaliza(){
		driver.close();
	}
	
	public void cancelaAcerto(){
		driver.findElement(By.name("btnLimparForm")).click();
	}
	
	public void salva(){
		driver.findElement(By.name("btnSalvaAcertoConsignacao")).click();
	}

	public boolean isSuccessMessageDisplayed(){
		String text = "sucesso";
		List<WebElement> list = driver.findElements(Utils.byText(text));
		return list.size() > 0;
	}
	
}
