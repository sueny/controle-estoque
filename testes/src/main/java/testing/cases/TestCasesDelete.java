package estoque2;

import org.junit.*;
import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesDelete_12{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesDelete_12.class);
	}
	
	@Test
	public void test1()
	{
		Material oTestObject = new Material();
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
		Material oTestObject = new Material();
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
		Material oTestObject = new Material();
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
		Material oTestObject = new Material();
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