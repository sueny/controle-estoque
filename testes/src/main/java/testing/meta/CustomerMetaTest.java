package testing.meta;

import org.junit.Test;

import testing.cases.TestCasesCreateMaterial;
import testing.pageobject.TelaCliente;

public class CustomerMetaTest {
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(CustomerMetaTest.class);
	}
	
	@Test
	public void preencheForm(){
		new TelaCliente().preencheForm();
	}
}
