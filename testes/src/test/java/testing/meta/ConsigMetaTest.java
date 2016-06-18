package testing.meta;

import org.junit.Test;

import testing.pageobject.TelaInicioConsig;

public class ConsigMetaTest {
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(ConsigMetaTest.class);
	}
	
	@Test
	public void test1(){
		TelaInicioConsig tela = new TelaInicioConsig();
		tela.selecionaCliente(0);
		tela.setObs("ajkljlkj");
		tela.selecionaProduto(0);
		tela.setQtde(3);
		tela.setValor(3214);
		tela.adicionaProduto();
		tela.salva();
	}
	
}
