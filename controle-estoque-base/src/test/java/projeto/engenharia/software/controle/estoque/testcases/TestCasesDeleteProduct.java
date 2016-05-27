package product;

import org.junit.*;
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
		Boolean sku3 = true;
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductState.Input));
		oTestObject.handleEvent("okEvent", sku3);
		assertEquals(true, (oTestObject.state == ProductState.Confirm));
		oTestObject.handleEvent("confirmEvent");
		assertEquals(true, (oTestObject.state == ProductState.Deleted));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test2()
	{
		ProductStateMachine oTestObject = new ProductStateMachine();
		Boolean sku3 = true;
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductState.Input));
		oTestObject.handleEvent("okEvent", sku3);
		assertEquals(true, (oTestObject.state == ProductState.Confirm));
		oTestObject.handleEvent("cancelEvent");
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		
	}
	
	@Test
	public void test3()
	{
		ProductStateMachine oTestObject = new ProductStateMachine();
		Boolean sku3 = false;
		assertEquals(true, (oTestObject.state == ProductState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductState.Input));
		oTestObject.handleEvent("okEvent", sku3);
		assertEquals(true, (oTestObject.state == ProductState.Input));
		
	}
	
}