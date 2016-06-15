package testing.cases;

import org.junit.Test;

import junit.framework.TestCase;
import testing.stateMachine.ClientStateMachine;
import testing.stateMachine.ClientState;

// JUnit 4.3
public class TestCasesClient extends TestCase {

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TestCasesClient.class);
    }

    @Test
    public void test1() {
        ClientStateMachine oTestObject = new ClientStateMachine();
        Boolean validParam3 = false;
        assertEquals(true, (oTestObject.state == ClientState.idle));
        oTestObject.handleEvent("startRegisterEv");
        assertEquals(true, (oTestObject.state == ClientState.registering));
        oTestObject.handleEvent("submitEv", validParam3);
        assertEquals(true, (oTestObject.state == ClientState.notRegistered));
        oTestObject.handleEvent("clear");
        assertEquals(true, (oTestObject.state == ClientState.idle));

    }

    @Test
    public void test2() {
        ClientStateMachine oTestObject = new ClientStateMachine();
        Boolean validParam3 = true;
        Boolean validParam11 = false;
        assertEquals(true, (oTestObject.state == ClientState.idle));
        oTestObject.handleEvent("startRegisterEv");
        assertEquals(true, (oTestObject.state == ClientState.registering));
        oTestObject.handleEvent("submitEv", validParam3);
        assertEquals(true, (oTestObject.state == ClientState.registered));
        oTestObject.handleEvent("back2idle");
        assertEquals(true, (oTestObject.state == ClientState.idle));
        //assertEquals(true, (oTestObject.qtddRegistro.intValue() >= 1));
        oTestObject.handleEvent("startUpdateEv");
        assertEquals(true, (oTestObject.state == ClientState.updating));
        oTestObject.handleEvent("submitEv", validParam11);
        assertEquals(true, (oTestObject.state == ClientState.notUpdated));
        oTestObject.handleEvent("clear");
        assertEquals(true, (oTestObject.state == ClientState.idle));

    }

    @Test
    public void test3() {
        ClientStateMachine oTestObject = new ClientStateMachine();
        Boolean validParam3 = true;
        Boolean validParam10 = true;
        assertEquals(true, (oTestObject.state == ClientState.idle));
        oTestObject.handleEvent("startRegisterEv");
        assertEquals(true, (oTestObject.state == ClientState.registering));
        oTestObject.handleEvent("submitEv", validParam3);
        assertEquals(true, (oTestObject.state == ClientState.registered));
        oTestObject.handleEvent("back2idle");
        assertEquals(true, (oTestObject.state == ClientState.idle));
        //assertEquals(true, (oTestObject.qtddRegistro.intValue() >= 1));
        oTestObject.handleEvent("startDeleteEv");
        assertEquals(true, (oTestObject.state == ClientState.deleting));
        oTestObject.handleEvent("submitEv", validParam10);
        assertEquals(true, (oTestObject.state == ClientState.deleted));
        oTestObject.handleEvent("back2idle");
        assertEquals(true, (oTestObject.state == ClientState.idle));
        oTestObject.close();
    }

    @Test
    public void test4() {
        ClientStateMachine oTestObject = new ClientStateMachine();
        Boolean validParam3 = true;
        Boolean validParam10 = false;
        assertEquals(true, (oTestObject.state == ClientState.idle));
        oTestObject.handleEvent("startRegisterEv");
        assertEquals(true, (oTestObject.state == ClientState.registering));
        oTestObject.handleEvent("submitEv", validParam3);
        assertEquals(true, (oTestObject.state == ClientState.registered));
        oTestObject.handleEvent("back2idle");
        assertEquals(true, (oTestObject.state == ClientState.idle));
        //assertEquals(true, (oTestObject.qtddRegistro.intValue() >= 1));
        oTestObject.handleEvent("startDeleteEv");
        assertEquals(true, (oTestObject.state == ClientState.deleting));
        oTestObject.handleEvent("submitEv", validParam10);
        assertEquals(true, (oTestObject.state == ClientState.notDeleted));
        oTestObject.handleEvent("back2idle");
        assertEquals(true, (oTestObject.state == ClientState.idle));
        oTestObject.close();
    }

    @Test
    public void test5() {
        ClientStateMachine oTestObject = new ClientStateMachine();
        Boolean validParam3 = true;
        Boolean validParam11 = true;
        assertEquals(true, (oTestObject.state == ClientState.idle));
        oTestObject.handleEvent("startRegisterEv");
        assertEquals(true, (oTestObject.state == ClientState.registering));
        oTestObject.handleEvent("submitEv", validParam3);
        assertEquals(true, (oTestObject.state == ClientState.registered));
        oTestObject.handleEvent("back2idle");
        assertEquals(true, (oTestObject.state == ClientState.idle));
        //assertEquals(true, (oTestObject.qtddRegistro.intValue() >= 1));
        oTestObject.handleEvent("startUpdateEv");
        assertEquals(true, (oTestObject.state == ClientState.updating));
        oTestObject.handleEvent("submitEv", validParam11);
        assertEquals(true, (oTestObject.state == ClientState.updated));
        oTestObject.handleEvent("back2idle");
        assertEquals(true, (oTestObject.state == ClientState.idle));
        oTestObject.close();
    }

    @Override
    protected void tearDown() throws Exception {
        
    }
}
