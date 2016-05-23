package testing.cases;

import org.junit.*;

import testing.stateMachine.CadastroMaterialStateMachine;
import testing.stateMachine.State;

import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesCreateMaterial{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesCreateMaterial.class);
	}
	
	@Test
	public void test1()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Integer sku3 = -46328;
		Integer unit3 = 299390;
		Integer sku6 = 184639;
		Integer unit6 = 25363;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("registerEvent");
		assertEquals(true, (oTestObject.state == State.Registering));
		oTestObject.handleEvent("validEvent", sku3, unit3);
		assertEquals(true, (oTestObject.state == State.Registering));
		oTestObject.handleEvent("validEvent", sku6, unit6);
		assertEquals(true, (oTestObject.state == State.Registered));
		oTestObject.handleEvent("newRegisterEvent");
		
	}
	
	@Test
	public void test2()
	{
		CadastroMaterialStateMachine oTestObject = new CadastroMaterialStateMachine();
		Integer sku3 = -447786;
		Integer unit3 = 345416;
		Integer sku6 = -306210;
		Integer unit6 = 374261;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("registerEvent");
		assertEquals(true, (oTestObject.state == State.Registering));
		oTestObject.handleEvent("validEvent", sku3, unit3);
		assertEquals(true, (oTestObject.state == State.Registering));
		oTestObject.handleEvent("validEvent", sku6, unit6);
		assertEquals(true, (oTestObject.state == State.Registered));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
}