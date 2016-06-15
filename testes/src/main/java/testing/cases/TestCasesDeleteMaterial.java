package estoque2;

import org.junit.*;
import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesDeleteMaterial{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesDeleteMaterial.class);
	}
	
	@Test
	public void test1()
	{
		Material oTestObject = new Material();
		Boolean registerVal5 = true;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent");
		oTestObject.handleEvent("confirmEvent", registerVal5);
		assertEquals(true, (oTestObject.state == State.Deleted));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test2()
	{
		Material oTestObject = new Material();
		Boolean registerVal5 = false;
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent");
		oTestObject.handleEvent("confirmEvent", registerVal5);
		assertEquals(true, (oTestObject.state == State.Input));
		
	}
	
	@Test
	public void test3()
	{
		Material oTestObject = new Material();
		assertEquals(true, (oTestObject.state == State.Idle));
		oTestObject.handleEvent("deleteEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		oTestObject.handleEvent("okEvent");
		oTestObject.handleEvent("cancelEvent");
		assertEquals(true, (oTestObject.state == State.Input));
		
	}
	
}