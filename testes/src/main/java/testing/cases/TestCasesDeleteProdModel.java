package modelo;

import org.junit.*;
import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesDeleteProdModel{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesDeleteProdModel.class);
	}
	
	@Test
	public void test1()
	{
		ProductModelStateMachine oTestObject = new ProductModelStateMachine();
		Boolean statusVal5 = true;
		assertEquals(true, (oTestObject.state == ProductModelState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		oTestObject.handleEvent("okEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Confirm));
		oTestObject.handleEvent("confirmEvent", statusVal5);
		assertEquals(true, (oTestObject.state == ProductModelState.Deleted));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test2()
	{
		ProductModelStateMachine oTestObject = new ProductModelStateMachine();
		Boolean statusVal5 = false;
		assertEquals(true, (oTestObject.state == ProductModelState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		oTestObject.handleEvent("okEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Confirm));
		oTestObject.handleEvent("confirmEvent", statusVal5);
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		
	}
	
	@Test
	public void test3()
	{
		ProductModelStateMachine oTestObject = new ProductModelStateMachine();
		assertEquals(true, (oTestObject.state == ProductModelState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		oTestObject.handleEvent("okEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Confirm));
		oTestObject.handleEvent("cancelEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		
	}
	
	@Test
	public void test4()
	{
		ProductModelStateMachine oTestObject = new ProductModelStateMachine();
		assertEquals(true, (oTestObject.state == ProductModelState.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		oTestObject.handleEvent("CleanEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Idle));
		
	}
	
}