package projeto.engenharia.software.controle.estoque.testcases;

import org.junit.*;

import static org.junit.Assert.*;
import projeto.engenharia.software.controle.estoque.test.material.stateMachine.MaterialContext;
import projeto.engenharia.software.controle.estoque.test.material.stateMachine.MaterialState;

// JUnit 4.3
public class MaterialTestCases {

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MaterialTestCases.class);
    }

    @Test
    public void test1() {
        MaterialContext oTestObject = new MaterialContext();
        Integer sku3 = -366382;
        Integer unit3 = -110471;
        Integer sku6 = 147770;
        Integer unit6 = 396780;
        assertEquals(true, (oTestObject.state == MaterialState.Idle));
        oTestObject.handleEvent("registerEvent");
        assertEquals(true, (oTestObject.state == MaterialState.Registering));
        oTestObject.handleEvent("validEvent", sku3, unit3);
        assertEquals(true, (oTestObject.state == MaterialState.Registering));
        oTestObject.handleEvent("validEvent", sku6, unit6);
        assertEquals(true, (oTestObject.state == MaterialState.Registered));
        oTestObject.handleEvent("newRegisterEvent");

    }

    @Test
    public void test2() {
        MaterialContext oTestObject = new MaterialContext();
        Integer sku3 = 0;
        Integer unit3 = 0;
        Integer sku6 = 1;
        Integer unit6 = 1;
        assertEquals(true, (oTestObject.state == MaterialState.Idle));
        oTestObject.handleEvent("registerEvent");
        assertEquals(true, (oTestObject.state == MaterialState.Registering));
        oTestObject.handleEvent("validEvent", sku3, unit3);
        assertEquals(true, (oTestObject.state == MaterialState.Registering));
        oTestObject.handleEvent("validEvent", sku6, unit6);
        assertEquals(true, (oTestObject.state == MaterialState.Registered));
        oTestObject.handleEvent("newRegisterEvent");

    }

    @Test
    public void test3() {
        MaterialContext oTestObject = new MaterialContext();
        Integer sku3 = -34279;
        Integer unit3 = -878823;
        Integer sku6 = 815959;
        Integer unit6 = 620542;
        assertEquals(true, (oTestObject.state == MaterialState.Idle));
        oTestObject.handleEvent("registerEvent");
        assertEquals(true, (oTestObject.state == MaterialState.Registering));
        oTestObject.handleEvent("validEvent", sku3, unit3);
        assertEquals(true, (oTestObject.state == MaterialState.Registering));
        oTestObject.handleEvent("validEvent", sku6, unit6);
        assertEquals(true, (oTestObject.state == MaterialState.Registered));
        oTestObject.handleEvent("finaliseEvent");

    }

    @Test
    public void test4() {
        MaterialContext oTestObject = new MaterialContext();
        Integer sku3 = 0;
        Integer unit3 = 0;
        Integer sku6 = 1;
        Integer unit6 = 1;
        assertEquals(true, (oTestObject.state == MaterialState.Idle));
        oTestObject.handleEvent("registerEvent");
        assertEquals(true, (oTestObject.state == MaterialState.Registering));
        oTestObject.handleEvent("validEvent", sku3, unit3);
        assertEquals(true, (oTestObject.state == MaterialState.Registering));
        oTestObject.handleEvent("validEvent", sku6, unit6);
        assertEquals(true, (oTestObject.state == MaterialState.Registered));
        oTestObject.handleEvent("finaliseEvent");

    }
}
