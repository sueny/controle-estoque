package testing.cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import testing.stateMachine.CadastroMaterialStateMachine;
import testing.stateMachine.State;

// JUnit 4.3
public class TestCasesRegisterMaterial{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesRegisterMaterial.class);
	}
	
	@Test
	public void test1()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Boolean registerVal3 = true;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("registerEvent");
		assertEquals(true, (oTestObject.state == State.Registering));
		oTestObject.handleEvent("validEvent", registerVal3);
		assertEquals(true, (oTestObject.state == State.Registered));
		oTestObject.handleEvent("newRegisterEvent");
		assertEquals(true, (oTestObject.state == State.Registering));
		
	}
	
	@Test
	public void test2()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Boolean registerVal3 = true;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("registerEvent");
		assertEquals(true, (oTestObject.state == State.Registering));
		oTestObject.handleEvent("validEvent", registerVal3);
		assertEquals(true, (oTestObject.state == State.Registered));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test3()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Boolean registerVal3 = false;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("registerEvent");
		assertEquals(true, (oTestObject.state == State.Registering));
		oTestObject.handleEvent("validEvent", registerVal3);
		assertEquals(true, (oTestObject.state == State.Registering));
		
	}
	
}