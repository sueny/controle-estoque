package testing.adapter.impl;

import java.util.Random;

import testing.adapter.ProductModelAdapter;
import testing.pageobject.TelaModeloProduto;
import testing.util.Utils;

public class ProductModelWebAdapter implements ProductModelAdapter {
	
	public TelaModeloProduto tela;
	
	public ProductModelWebAdapter(){
		this.tela = new TelaModeloProduto();
	}

	@Override
	public void appCloseSession() {
		tela.finaliza();
	}
	
	@Override
	public boolean appSaveProductModel(boolean valid) {
		tela.limpa();
		//if !valid we must create some invalid data
		if(valid)
			tela.setNome("nome modelo teste "+Math.abs((new Random()).nextLong()));
		tela.setEstacao(1);
		//assertTrue(tela.aguardaCategorias());
		tela.setCategoria(0);
		//assertTrue(tela.aguardaSubcategorias());
		tela.setSubCategoria(0);
		tela.setDescricao("texto descritivo");
		
		tela.envia();
		Utils.sleep(1000);
		return tela.isSaveSuccessMessageDisplayed();
	}

	public Boolean appValidadeProductModel() {
		return tela.formValido();
	}
	
	@Override
	public void clickDelete(){
		tela.clicaExcluir();
	}
	
	@Override
	public void cancelDeletion(){
		tela.cancela();
	}
	
	@Override
	public boolean confirmDeletion(boolean status){
		tela.confirma();
		return tela.isDeleteSuccessMessageDisplayed();
	}
	
	
	@Override
	public void clickClean(){
		tela.limpa();
	}
	
	@Override
	public void chooseProductModel() {
		tela.selecionaModelo(0);
	}

	@Override
	public void fillFormAndClickUpdate(boolean valid) {
		tela.limpaNome();
		if(valid)
			tela.setNome("Produto teste alterado "+Utils.getRandomNumString(6));
		
		tela.clicaAlterar();
	}

	@Override
	public void cancelUpdate() {
		tela.cancela();
	}

	@Override
	public boolean confirmUpdate() {
		tela.confirma();
		return tela.isUpdateSuccessMessageDisplayed();
	}

}
