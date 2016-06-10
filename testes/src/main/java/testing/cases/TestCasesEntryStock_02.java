package stock;

import org.junit.*;
import static org.junit.Assert.*;

// JUnit 4.3
public class TestCasesEntryStock_02{
	
	public static junit.framework.Test suite(){
		return new junit.framework.JUnit4TestAdapter(TestCasesEntryStock_02.class);
	}
	
	@Test
	public void test1()
	{
		StockStateMachine oTestObject = new StockStateMachine();
		Boolean qntVal5 = true;
		Boolean priceVal5 = true;
		assertEquals(true, (oTestObject.state == StockState.Idle));
		oTestObject.handleEvent("startEntryEvent");
		assertEquals(true, (oTestObject.state == StockState.FindProduct));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == StockState.EntryStock));
		oTestObject.handleEvent("fillParametersEvent", qntVal5, priceVal5);
		assertEquals(true, (oTestObject.state == StockState.ProdInStock));
		oTestObject.handleEvent("newEntryEvent");
		assertEquals(true, (oTestObject.state == StockState.FindProduct));
		
	}
	
	@Test
	public void test2()
	{
		StockStateMachine oTestObject = new StockStateMachine();
		Boolean qntVal5 = false;
		Boolean priceVal5 = false;
		assertEquals(true, (oTestObject.state == StockState.Idle));
		oTestObject.handleEvent("startEntryEvent");
		assertEquals(true, (oTestObject.state == StockState.FindProduct));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == StockState.EntryStock));
		oTestObject.handleEvent("fillParametersEvent", qntVal5, priceVal5);
		assertEquals(true, (oTestObject.state == StockState.EntryStock));
		
	}
	
	@Test
	public void test3()
	{
		StockStateMachine oTestObject = new StockStateMachine();
		Boolean qntVal5 = true;
		Boolean priceVal5 = true;
		assertEquals(true, (oTestObject.state == StockState.Idle));
		oTestObject.handleEvent("startEntryEvent");
		assertEquals(true, (oTestObject.state == StockState.FindProduct));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == StockState.EntryStock));
		oTestObject.handleEvent("fillParametersEvent", qntVal5, priceVal5);
		assertEquals(true, (oTestObject.state == StockState.ProdInStock));
		oTestObject.handleEvent("finaliseEvent");
		
	}
	
	@Test
	public void test4()
	{
		StockStateMachine oTestObject = new StockStateMachine();
		assertEquals(true, (oTestObject.state == StockState.Idle));
		oTestObject.handleEvent("startEntryEvent");
		assertEquals(true, (oTestObject.state == StockState.FindProduct));
		oTestObject.handleEvent("chooseProductEvent");
		assertEquals(true, (oTestObject.state == StockState.EntryStock));
		oTestObject.handleEvent("newSearchEvent");
		assertEquals(true, (oTestObject.state == StockState.FindProduct));
		
	}
	
}