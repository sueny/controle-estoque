package estoque2;

import org.junit.*;
import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesRegisterMaterial{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesRegisterMaterial.class);
	}
	
	@Test
	public void test1()
	{
		Material oTestObject = new Material();
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
		Material oTestObject = new Material();
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
		Material oTestObject = new Material();
		Boolean registerVal3 = false;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("registerEvent");
		assertEquals(true, (oTestObject.state == State.Registering));
		oTestObject.handleEvent("validEvent", registerVal3);
		assertEquals(true, (oTestObject.state == State.Registering));
		
	}
	
}