package consignment;

import org.junit.*;
import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesConsig_06{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesConsig_06.class);
	}
	
	@Test
	public void test1()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean valid7 = true;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientEvent");
		assertEquals(true, (oTestObject.state == ConsigState.AddProducts));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		oTestObject.handleEvent("fillParametersEvent", valid7);
		assertEquals(true, (oTestObject.state == ConsigState.ProdAdded));
		oTestObject.handleEvent("fillDateEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FinalInfo));
		oTestObject.handleEvent("closeKitEvent");
		assertEquals(true, (oTestObject.state == ConsigState.KitReady));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test2()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean valid7 = true;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientEvent");
		assertEquals(true, (oTestObject.state == ConsigState.AddProducts));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		oTestObject.handleEvent("fillParametersEvent", valid7);
		assertEquals(true, (oTestObject.state == ConsigState.ProdAdded));
		oTestObject.handleEvent("fillDateEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FinalInfo));
		oTestObject.handleEvent("closeKitEvent");
		assertEquals(true, (oTestObject.state == ConsigState.KitReady));
		oTestObject.handleEvent("newConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		
	}
	
	@Test
	public void test3()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean valid7 = true;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientEvent");
		assertEquals(true, (oTestObject.state == ConsigState.AddProducts));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		oTestObject.handleEvent("fillParametersEvent", valid7);
		assertEquals(true, (oTestObject.state == ConsigState.ProdAdded));
		oTestObject.handleEvent("fillDateEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FinalInfo));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		
	}
	
	@Test
	public void test4()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean valid7 = true;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientEvent");
		assertEquals(true, (oTestObject.state == ConsigState.AddProducts));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		oTestObject.handleEvent("fillParametersEvent", valid7);
		assertEquals(true, (oTestObject.state == ConsigState.ProdAdded));
		oTestObject.handleEvent("fillDateEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FinalInfo));
		oTestObject.handleEvent("newConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		
	}
	
	@Test
	public void test5()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean valid7 = false;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientEvent");
		assertEquals(true, (oTestObject.state == ConsigState.AddProducts));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		oTestObject.handleEvent("fillParametersEvent", valid7);
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		
	}
	
	@Test
	public void test6()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean valid7 = true;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientEvent");
		assertEquals(true, (oTestObject.state == ConsigState.AddProducts));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		oTestObject.handleEvent("fillParametersEvent", valid7);
		assertEquals(true, (oTestObject.state == ConsigState.ProdAdded));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		
	}
	
	@Test
	public void test7()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean valid7 = true;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientEvent");
		assertEquals(true, (oTestObject.state == ConsigState.AddProducts));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		oTestObject.handleEvent("fillParametersEvent", valid7);
		assertEquals(true, (oTestObject.state == ConsigState.ProdAdded));
		oTestObject.handleEvent("newConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		
	}
	
	@Test
	public void test8()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientEvent");
		assertEquals(true, (oTestObject.state == ConsigState.AddProducts));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FillFormProduct));
		oTestObject.handleEvent("newConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		
	}
	
	@Test
	public void test9()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientEvent");
		assertEquals(true, (oTestObject.state == ConsigState.AddProducts));
		oTestObject.handleEvent("newConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		
	}
	
}