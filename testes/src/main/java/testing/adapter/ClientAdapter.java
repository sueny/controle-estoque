package testing.adapter;

public interface ClientAdapter {

	boolean startRegister();
	
	boolean startUpdate();
	
	boolean startDelete();
	
	boolean submitDelete(boolean delete);
        
    void closeSession();

    boolean submitRegisterAndUpdate(boolean validData);
	
}
