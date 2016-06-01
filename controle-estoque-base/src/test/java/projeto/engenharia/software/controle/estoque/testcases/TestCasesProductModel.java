package projeto.engenharia.software.controle.estoque.testcases;

import org.junit.*;
import static org.junit.Assert.*;
import projeto.engenharia.software.controle.estoque.test.productModel.StateMachine.ProductModelState;
import projeto.engenharia.software.controle.estoque.test.productModel.StateMachine.ProductModelStateMachine;

// JUnit 4.3
public class TestCasesProductModel {

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TestCasesProductModel.class);
    }

    @Test
    public void test1() {
        ProductModelStateMachine oTestObject = new ProductModelStateMachine();
        Boolean status3 = true;
        assertEquals(true, (oTestObject.state == ProductModelState.Idle));
        oTestObject.handleEvent("registerEvent");
        assertEquals(true, (oTestObject.state == ProductModelState.Registering));
        oTestObject.handleEvent("saveEvent", status3);
        assertEquals(true, (oTestObject.state == ProductModelState.Registered));
        oTestObject.handleEvent("newRegModelEvent");
        assertEquals(true, (oTestObject.state == ProductModelState.Registering));

    }

    @Test
    public void test2() {
        ProductModelStateMachine oTestObject = new ProductModelStateMachine();
        Boolean status3 = true;
        assertEquals(true, (oTestObject.state == ProductModelState.Idle));
        oTestObject.handleEvent("registerEvent");
        assertEquals(true, (oTestObject.state == ProductModelState.Registering));
        oTestObject.handleEvent("saveEvent", status3);
        assertEquals(true, (oTestObject.state == ProductModelState.Registered));
        oTestObject.handleEvent("finaliseEvent");

    }

    @Test
    public void test3() {
        ProductModelStateMachine oTestObject = new ProductModelStateMachine();
        Boolean status3 = false;
        assertEquals(true, (oTestObject.state == ProductModelState.Idle));
        oTestObject.handleEvent("registerEvent");
        assertEquals(true, (oTestObject.state == ProductModelState.Registering));
        oTestObject.handleEvent("saveEvent", status3);
        assertEquals(true, (oTestObject.state == ProductModelState.Registering));

    }

}
