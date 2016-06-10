package consignment;

import org.junit.*;
import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesCloseConsig{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesCloseConsig.class);
	}
	
	@Test
	public void test1()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean soldVal7 = true;
		Boolean devVal7 = true;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startCloseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.ChooseConsig));
		oTestObject.handleEvent("chooseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.CloseConsig));
		oTestObject.handleEvent("submitConsigEvent", soldVal7, devVal7);
		assertEquals(true, (oTestObject.state == ConsigState.ClosedConsig));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test2()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean soldVal7 = true;
		Boolean devVal7 = true;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startCloseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.ChooseConsig));
		oTestObject.handleEvent("chooseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.CloseConsig));
		oTestObject.handleEvent("submitConsigEvent", soldVal7, devVal7);
		assertEquals(true, (oTestObject.state == ConsigState.ClosedConsig));
		oTestObject.handleEvent("newCloseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		
	}
	
	@Test
	public void test3()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		Boolean soldVal7 = false;
		Boolean devVal7 = false;
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startCloseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.ChooseConsig));
		oTestObject.handleEvent("chooseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.CloseConsig));
		oTestObject.handleEvent("submitConsigEvent", soldVal7, devVal7);
		assertEquals(true, (oTestObject.state == ConsigState.CloseConsig));
		
	}
	
	@Test
	public void test4()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startCloseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.ChooseConsig));
		oTestObject.handleEvent("chooseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.CloseConsig));
		oTestObject.handleEvent("newCloseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		
	}
	
	@Test
	public void test5()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startCloseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.ChooseConsig));
		oTestObject.handleEvent("newCloseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		
	}
	
	@Test
	public void test6()
	{
		ConsigStateMachine oTestObject = new ConsigStateMachine();
		assertEquals(true, (oTestObject.state == ConsigState.Idle));
		oTestObject.handleEvent("startCloseConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.FindClient));
		oTestObject.handleEvent("chooseClientConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.ChooseConsig));
		oTestObject.handleEvent("closeConsigEvent");
		assertEquals(true, (oTestObject.state == ConsigState.ChooseConsig));
		
	}
	
}