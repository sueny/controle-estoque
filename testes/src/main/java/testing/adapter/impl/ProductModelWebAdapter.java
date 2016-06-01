package testing.adapter.impl;

import java.util.Random;

import testing.adapter.ProductModelAdapter;
import testing.pageobject.TelaModeloProduto;

import static org.junit.Assert.*;

public class ProductModelWebAdapter implements ProductModelAdapter {
	
	public TelaModeloProduto tela;
	
	public ProductModelWebAdapter(){
		this.tela = new TelaModeloProduto();
	}

	public void appCloseSession() {
		tela.finaliza();
	}

	public void appSaveProductModel() {
		tela.limpa();
		
		tela.setNome("nome modelo teste "+(new Random()).nextLong());
		tela.setEstacao(1);
		assertTrue(tela.aguardaCategorias());
		tela.setCategoria(1);
		assertTrue(tela.aguardaSubcategorias());
		tela.setSubCategoria(1);
		tela.setDescricao("texto descritivo");
		
		tela.envia();
	}

	public Boolean appValidadeProductModel() {
		return tela.formValido();
	}

}
