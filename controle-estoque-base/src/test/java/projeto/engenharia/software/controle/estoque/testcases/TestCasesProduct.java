package projeto.engenharia.software.controle.estoque.testcases;

import org.junit.*;
import static org.junit.Assert.*;
import projeto.engenharia.software.controle.estoque.test.product.stateMachine.ProductState;
import projeto.engenharia.software.controle.estoque.test.product.stateMachine.ProductStateMachine;

// JUnit 4.3
public class TestCasesProduct{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesProduct.class);
	}
	
	@Test
	public void test1()
	{
		ProductStateMachine oTestObject = new ProductStateMachine();
		Boolean status3 = true;
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("registerEvent");
		assertEquals(true, (oTestObject.state == ProductState.Registering));
		oTestObject.handleEvent("validProdEvent", status3);
		assertEquals(true, (oTestObject.state == ProductState.Registered));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test2()
	{
		ProductStateMachine oTestObject = new ProductStateMachine();
		Boolean status3 = true;
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("registerEvent");
		assertEquals(true, (oTestObject.state == ProductState.Registering));
		oTestObject.handleEvent("validProdEvent", status3);
		assertEquals(true, (oTestObject.state == ProductState.Registered));
		oTestObject.handleEvent("newRegProdEvent");
		assertEquals(true, (oTestObject.state == ProductState.Registering));
		
	}
	
	@Test
	public void test3()
	{
		ProductStateMachine oTestObject = new ProductStateMachine();
		Boolean status3 = false;
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("registerEvent");
		assertEquals(true, (oTestObject.state == ProductState.Registering));
		oTestObject.handleEvent("validProdEvent", status3);
		assertEquals(true, (oTestObject.state == ProductState.Registering));
		
	}
	
}