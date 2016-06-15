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

	public void closeSession() {
		driver.quit();
	}

	public Boolean register(Integer sku, Integer unit) {
		telaCadastro.getBtnLimpar().click();
		
		telaCadastro.getTxtNome().sendKeys("Materia Prima teste 01");
		telaCadastro.getTxtDescription().sendKeys("This is a description");
		if(sku > 0)
			telaCadastro.getTxtSku().sendKeys(sku.toString());
		telaCadastro.getSelUnidade().getOptions().get(1).click();
		
		telaCadastro.getBtnCadastro().click();
		
		return telaCadastro.isSaveSuccessMessageDisplayed();
	}


	public Boolean deleteData(Integer sku) {
		telaCadastro.getBtnExcluir().click();
		
		return telaCadastro.isDeletionSuccessMessageDisplayed();
	}


	public void confirmDeletion(boolean confirm) {
		if(confirm){
			telaCadastro.confirma();
		}else{
			telaCadastro.cancelDeletion();
		}
	}
	
	

}
