package testing.cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import testing.stateMachine.CadastroMaterialStateMachine;
import testing.stateMachine.State;

// JUnit 4.3
public class TestCasesDeleteMaterial{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesDeleteMaterial.class);
	}
	
	@Test
	public void test1()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Integer sku3 = -567501;
		Integer sku6 = 331495;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent", sku3);
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent", sku6);
		oTestObject.handleEvent("confirmEvent");
		
	}
	
	@Test
	public void test2()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Integer sku3 = 0;
		Integer sku6 = 1;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent", sku3);
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent", sku6);
		oTestObject.handleEvent("confirmEvent");
		
	}
	
	@Test
	public void test3()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Integer sku3 = -501177;
		Integer sku6 = 713919;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent", sku3);
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent", sku6);
		oTestObject.handleEvent("cancelEvent");
		
	}
	
	@Test
	public void test4()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Integer sku3 = 0;
		Integer sku6 = 1;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent", sku3);
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent", sku6);
		oTestObject.handleEvent("cancelEvent");
		
	}
	
}
