package testing.adapter.impl;

import testing.adapter.ProductModelAdapter;
import testing.pageobject.TelaModeloProduto;

public class ProductModelWebAdapter implements ProductModelAdapter {
	
	public TelaModeloProduto tela;
	
	public ProductModelWebAdapter(){
		this.tela = new TelaModeloProduto();
	}

	public void appCloseSession() {
		tela.finaliza();
	}

	public void appSaveProductModel() {
		tela.setNome("nome modelo teste");
		tela.setEstacao(1);
		tela.setCategoria(1);
		tela.aguardaSubcategorias();
		tela.setSubCategoria(1);
		tela.setDescricao("texto descritivo");
		
		tela.envia();
	}

	public Boolean appValidadeProductModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
