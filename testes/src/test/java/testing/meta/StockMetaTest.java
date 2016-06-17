package testing.meta;

import org.junit.Test;

import testing.pageobject.TelaEntradaEstoque;

public class StockMetaTest {
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(StockMetaTest.class);
	}
	
	@Test
	public void test1(){
		TelaEntradaEstoque tela = new TelaEntradaEstoque();
		tela.selecionaProduto(0);
		tela.setObservacao("asdfad");
		tela.setQtde(3);
		tela.setValor(3214);
		tela.envia();
	}
	
}
