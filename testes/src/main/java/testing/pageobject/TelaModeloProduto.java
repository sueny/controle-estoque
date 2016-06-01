package testing.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverProvider;
import util.Routes;

public class TelaModeloProduto {
	
	private WebDriver driver;
	
	public TelaModeloProduto(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_MODELO);
	}
	
	public void finaliza(){
		this.driver.close();
	}
	
	public void setNome(String nome){
		driver.findElement(By.name("txtNome")).sendKeys(nome);
	}
	
	public void setEstacao(int estacao){
		new Select(driver.findElement(By.name("selEstacao"))).getOptions().get(estacao).click();
	}
	
	public void setCategoria(int categoria){
		new Select(driver.findElement(By.name("selCategoria"))).getOptions().get(categoria).click();
	}
	
	public boolean aguardaSubcategorias(){
		final Select sel = new Select(driver.findElement(By.name("selSubcategoria")));
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return sel.getOptions().size() > 0;
            }
        });
		return sel.getOptions().size() > 0;
	}
	
	public void setSubCategoria(int sub){
		new Select(driver.findElement(By.name("selSubcategoria"))).getOptions().get(sub).click();
	}
	
	public void setDescricao(String descr){
		driver.findElement(By.name("txtDescricao")).sendKeys(descr);
	}
	
	public void envia(){
		driver.findElement(By.name("btnCadastrarModelo")).click();
	}
	
	public void limpa(){
		driver.findElement(By.name("btnLimparForm")).click();
	}
	
	public void clicaExcluir(){
		driver.findElement(By.name("btnExcluirModelo")).click();
	}

}
