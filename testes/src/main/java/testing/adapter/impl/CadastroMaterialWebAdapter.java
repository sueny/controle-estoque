package testing.adapter.impl;

import org.openqa.selenium.WebDriver;

import testing.adapter.CadastroMaterialAdapter;
import testing.pageobject.TelaMateriaPrima;

public class CadastroMaterialWebAdapter implements CadastroMaterialAdapter{

	public boolean erro;
	
	private WebDriver driver;
	
	private TelaMateriaPrima telaCadastro;
	
	public CadastroMaterialWebAdapter(){
		this.telaCadastro = new TelaMateriaPrima();
	}
	

	/*public void envia() {
		System.out.println("commence envoyer");
		
		this.erro = true;
		
		WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        System.out.println("aguardando");
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
		
		this.erro = false;
	}*/
	

	public void closeSession() {
		driver.quit();
	}

	public Boolean register(Integer sku, Integer unit) {
		telaCadastro.getTxtNome().sendKeys("Materia Prima teste 01");
		telaCadastro.getTxtDescription().sendKeys("This is a description");
		telaCadastro.getTxtSku().sendKeys(sku.toString());
		telaCadastro.getSelUnidade().getOptions().get(1).click();
		telaCadastro.getSelCategoria().getOptions().get(1).click();
		
		telaCadastro.getBtnCadastro().click();
		
		return telaCadastro.isSuccessMessageDisplayed();
	}


	public Boolean deleteData(Integer sku) {
		telaCadastro.getBtnExcluir().click();
		
		return telaCadastro.isDeletionSuccessMessageDisplayed();
	}


	public void confirmDeletion(boolean confirm) {
		if(confirm){
			telaCadastro.confirmDeletion();
		}else{
			telaCadastro.cancelDeletion();
		}
	}
	
	

}