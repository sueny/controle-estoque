package testing.pageobject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testing.util.Utils;

public class TelaSistema {
	
	protected WebDriver driver;
	
	public void confirma(){
		driver.findElement(By.tagName("md-dialog")).findElement(Utils.byText("Sim")).click();
	}
	
	public void cancela(){
		driver.findElement(By.tagName("md-dialog")).findElement(Utils.byText("Não")).click();
	}
	
	public void selecionaEmLista(By seletor, int indice){
		try {
			driver.findElements(seletor)
			.get(0).click();
		} catch (IndexOutOfBoundsException e) {
			throw new RuntimeException("Não foram encontrados itens na listagem");
		}
	}
	
	public void selecionaEmLista(By seletor, String filtro, int indice){
		try {
			driver.findElements(seletor)
			.stream()
			.filter(x -> x.getText().contains(filtro))
			.collect(Collectors.toList())
			.get(indice).click();
		} catch (IndexOutOfBoundsException e) {
			throw new RuntimeException("Não foram encontrados na listagem itens contendo '"+filtro+"' no nome");
		}
	}
	
	public boolean checaEFechaMensage(String text){
		Utils.sleep(900);
		List<WebElement> list = driver.findElements(Utils.byText(text));
		boolean exists = list.size() > 0 && list.get(0).isDisplayed();
		if(exists){
			driver.findElement(By.className("btn-close-toast")).click();
		}
		return exists;
	}
	
	public void mostraListagem(){
		WebElement btnListar = null, btnOcultar = null;
		try{
			btnListar = driver.findElement(Utils.byText("Listar"));
		}catch(NoSuchElementException e){
			
		}
		try{
			btnOcultar = driver.findElement(Utils.byText("Ocultar Lista"));
		}catch(NoSuchElementException e){
			
		}
		
		if(btnListar == null && btnOcultar == null)
			throw new RuntimeException("Não há o botão listar nem ocultar lista nessa tela");
		if(btnListar != null && btnListar.isDisplayed())
			btnListar.click();
	}
}
