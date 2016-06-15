package testing.cases;

import org.junit.*;

import testing.stateMachine.ProductState;
import testing.stateMachine.ProductStateMachine;

import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesDeleteProduct{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesDeleteProduct.class);
	}
	
	@Test
	public void test1()
	{
		ProductStateMachine oTestObject = new ProductStateMachine();
		Boolean message5 = true;
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductState.Input));
		oTestObject.handleEvent("okEvent");
		assertEquals(true, (oTestObject.state == ProductState.Confirm));
		oTestObject.handleEvent("confirmEvent", message5);
		assertEquals(true, (oTestObject.state == ProductState.Deleted));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test2()
	{
		ProductStateMachine oTestObject = new ProductStateMachine();
		Boolean message5 = false;
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductState.Input));
		oTestObject.handleEvent("okEvent");
		assertEquals(true, (oTestObject.state == ProductState.Confirm));
		oTestObject.handleEvent("confirmEvent", message5);
		assertEquals(true, (oTestObject.state == ProductState.Input));
		
	}
	
	@Test
	public void test3()
	{
		ProductStateMachine oTestObject = new ProductStateMachine();
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductState.Input));
		oTestObject.handleEvent("okEvent");
		assertEquals(true, (oTestObject.state == ProductState.Confirm));
		oTestObject.handleEvent("cancelEvent");
		assertEquals(true, (oTestObject.state == ProductState.Input));
		
	}
	
	@Test
	public void test4()
	{
		ProductStateMachine oTestObject = new ProductStateMachine();
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductState.Input));
		oTestObject.handleEvent("cleanEvent");
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		
	}
	
}