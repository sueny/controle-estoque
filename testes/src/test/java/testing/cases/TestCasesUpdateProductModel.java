package testing.cases;

import org.junit.*;

import testing.stateMachine.ProductModelState;
import testing.stateMachine.ProductModelStateMachine;

import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesUpdateProductModel{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesUpdateProductModel.class);
	}
	
	@Test
	public void test1()
	{
		ProductModelStateMachine oTestObject = new ProductModelStateMachine();
		Boolean statusUpdateVal5 = true;
		Boolean btnClickSimOuNaoVal5 = true;
		assertEquals(true, (oTestObject.state == ProductModelState.Idle));
		oTestObject.handleEvent("updateEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		oTestObject.handleEvent("alterEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Confirm));
		oTestObject.handleEvent("confirmUpdateEvent", statusUpdateVal5, btnClickSimOuNaoVal5);
		assertEquals(true, (oTestObject.state == ProductModelState.Updated));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test2()
	{
		ProductModelStateMachine oTestObject = new ProductModelStateMachine();
		Boolean statusUpdateVal5 = false;
		Boolean btnClickSimOuNaoVal5 = false;
		assertEquals(true, (oTestObject.state == ProductModelState.Idle));
		oTestObject.handleEvent("updateEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		oTestObject.handleEvent("alterEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Confirm));
		oTestObject.handleEvent("confirmUpdateEvent", statusUpdateVal5, btnClickSimOuNaoVal5);
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		
	}
	
	@Test
	public void test3()
	{
		ProductModelStateMachine oTestObject = new ProductModelStateMachine();
		assertEquals(true, (oTestObject.state == ProductModelState.Idle));
		oTestObject.handleEvent("updateEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Input));
		oTestObject.handleEvent("cleanEvent");
		assertEquals(true, (oTestObject.state == ProductModelState.Idle));
		
	}
	
}