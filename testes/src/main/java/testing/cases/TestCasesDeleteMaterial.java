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
		Boolean registerVal5 = true;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent");
		oTestObject.handleEvent("confirmEvent", registerVal5);
		assertEquals(true, (oTestObject.state == State.Deleted));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
/*	@Test
	public void test2()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Boolean registerVal5 = false;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent");
		oTestObject.handleEvent("confirmEvent", registerVal5);
		assertEquals(true, (oTestObject.state == State.Input));		
	}*/
	
	@Test
	public void test3()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent");
		oTestObject.handleEvent("cancelEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		
	}
	
}