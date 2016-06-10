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

}
