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

	public void appCloseSession() {
		tela.finaliza();
	}

	public boolean appSaveProductModel() {
		tela.limpa();
		
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
