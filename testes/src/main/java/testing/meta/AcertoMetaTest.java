package testing.meta;

import org.junit.Test;

import testing.pageobject.TelaAcertoConsig;

public class AcertoMetaTest {

	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(AcertoMetaTest.class);
	}
	
	@Test
	public void test1(){
		TelaAcertoConsig tela = new TelaAcertoConsig();
		tela.selecionaCliente(0);
		tela.selecionaConsig(0);
		tela.preencheQuantidades(true);
		tela.salva();
	}
	
}
