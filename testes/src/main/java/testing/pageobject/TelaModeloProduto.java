package testing.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

import testing.components.MdSelect;
import testing.util.DriverProvider;
import testing.util.Routes;

public class TelaModeloProduto {
	
	private WebDriver driver;
	
	public TelaModeloProduto(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_MODELO);
		sleep(3000);
	}
	
	private void sleep(long s){
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void finaliza(){
		this.driver.close();
	}
	
	public boolean formValido(){
		return !driver.findElement(By.name("formModel")).getAttribute("class").contains("ng-invalid");
	}
	
	public void setNome(String nome){
		driver.findElement(By.name("txtNome")).sendKeys(nome);
	}
	
	public void setEstacao(int estacao){
		new Select(driver.findElement(By.name(".selEstacao"))).getOptions().get(estacao).click();
	}
	
	public void setCategoria(int categoria){
		new MdSelect(driver.findElement(By.name("selCategoria")), driver).selectItem(categoria);
	}
	
	public void setSubCategoria(int sub){
		new MdSelect(driver.findElement(By.name("selSubcategoria")), driver).selectItem(sub);
	}
	
	public void setDescricao(String descr){
		driver.findElement(By.name("txtDescricao")).sendKeys(descr);
	}
	
	public void envia(){
		try{
			driver.findElement(By.name("btnCadastrarModelo")).click();
		}catch(Exception e){
			System.out.println("falha ao clicar em cadastrar");
		}
	}
	
	public void limpa(){
		driver.findElement(By.name("btnLimparForm")).click();
	}
	
	public void clicaExcluir(){
		driver.findElement(By.name("btnExcluirModelo")).click();
	}

}
