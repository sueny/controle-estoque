//package product;
package projeto.engenharia.software.controle.estoque.testcases;

import org.junit.*;
import static org.junit.Assert.*;
import projeto.engenharia.software.controle.estoque.test.product.stateMachine.ProductState;
import projeto.engenharia.software.controle.estoque.test.product.stateMachine.ProductStateMachine;

// JUnit 4.3
public class TestCasesUpdateProduct {

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TestCasesUpdateProduct.class);
    }

    @Test
    public void test1() {
        ProductStateMachine oTestObject = new ProductStateMachine();
        Boolean status5 = true;
        assertEquals(true, (oTestObject.state == ProductState.Idle));
        oTestObject.handleEvent("updateEvent");
        assertEquals(true, (oTestObject.state == ProductState.Principal));
        oTestObject.handleEvent("chooseProd");
        assertEquals(true, (oTestObject.state == ProductState.Updating));
        oTestObject.handleEvent("validProdEvent", status5);
        assertEquals(true, (oTestObject.state == ProductState.Updated));
        oTestObject.handleEvent("finaliseEvent");

    }

    @Test
    public void test2() {
        ProductStateMachine oTestObject = new ProductStateMachine();
        Boolean status5 = true;
        assertEquals(true, (oTestObject.state == ProductState.Idle));
        oTestObject.handleEvent("updateEvent");
        assertEquals(true, (oTestObject.state == ProductState.Principal));
        oTestObject.handleEvent("chooseProd");
        assertEquals(true, (oTestObject.state == ProductState.Updating));
        oTestObject.handleEvent("validProdEvent", status5);
        assertEquals(true, (oTestObject.state == ProductState.Updated));
        oTestObject.handleEvent("newUpdate");
        assertEquals(true, (oTestObject.state == ProductState.Principal));

    }

    @Test
    public void test3() {
        ProductStateMachine oTestObject = new ProductStateMachine();
        Boolean status5 = false;
        assertEquals(true, (oTestObject.state == ProductState.Idle));
        oTestObject.handleEvent("updateEvent");
        assertEquals(true, (oTestObject.state == ProductState.Principal));
        oTestObject.handleEvent("chooseProd");
        assertEquals(true, (oTestObject.state == ProductState.Updating));
        oTestObject.handleEvent("validProdEvent", status5);
        assertEquals(true, (oTestObject.state == ProductState.Principal));

    }

}