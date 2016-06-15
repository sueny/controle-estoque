package testing.adapter.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testing.adapter.CadastroMaterialAdapter;
import testing.pageobject.TelaMateriaPrima;
import testing.util.Utils;

public class CadastroMaterialWebAdapter implements CadastroMaterialAdapter{

	public boolean erro;
	
	private TelaMateriaPrima telaCadastro;
	
	public CadastroMaterialWebAdapter(){
		this.telaCadastro = new TelaMateriaPrima();
	}

	@Override
	public void closeSession() {
		telaCadastro.finaliza();
	}

	@Override
	public boolean register(boolean valid) {
		telaCadastro.getBtnLimpar().click();
		
		telaCadastro.getTxtNome().sendKeys("Materia Prima teste "+Utils.getRandomNumString(4));
		telaCadastro.getTxtDescription().sendKeys("This is a description");
		if(valid)
			telaCadastro.getTxtSku().sendKeys(Utils.getRandomNumString(8));
		telaCadastro.getSelUnidade().getOptions().get(1).click();
		
		telaCadastro.getBtnCadastro().click();
		
		return telaCadastro.isSaveSuccessMessageDisplayed();
	}

	@Override
	public boolean confirmDeletion() {
		telaCadastro.confirma();
		return telaCadastro.isDeletionSuccessMessageDisplayed();
	}

	@Override
	public void clickToDeleteMaterial() {
		telaCadastro.mostraListagem();
		telaCadastro.selecionaEmLista(By.className("item-material"), "teste", 0);
		Utils.sleep(500);
		telaCadastro.getBtnExcluir().click();
	}

	@Override
	public void cancelDeletion() {
		telaCadastro.cancela();
	}
	
	

}
