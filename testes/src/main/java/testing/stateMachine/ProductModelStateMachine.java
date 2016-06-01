package testing.stateMachine;

import testing.adapter.ProductModelAdapter;
import testing.adapter.impl.ProductModelWebAdapter;

public class ProductModelStateMachine extends java.lang.Object implements java.lang.Cloneable{
	public Boolean valid = false;
	public ProductModelState state;
	private ProductModelAdapter adapter;
	
	public ProductModelStateMachine(){
		this.adapter = new ProductModelWebAdapter();
		state = ProductModelState.Idle;
		valid = false;
		
	}
	
	public ProductModelStateMachine clone(){
		ProductModelStateMachine cl = new ProductModelStateMachine();
		cl.state = this.state;
		cl.valid = this.valid;
		cl.adapter = this.adapter;
		
		return cl;
	}
	
	public void handleEvent(Object... in_colObject){
		if(in_colObject.length > 0){
			
			String sEventName = (String)in_colObject[0];
			
			/**
			 * Register Product Model
			 * */
			
			if ((state == ProductModelState.Idle) && (sEventName.compareTo("registerEvent") == 0)){
						
				state = ProductModelState.Registering;
				
				}else  if((state == ProductModelState.Registering) && (sEventName.compareTo("saveEvent") == 0)) {
					//statusProduct= ((Boolean)in_colObject[1]).booleanValue();
					saveProduct();
					valid = modelIsValid();
									
					if(valid == false){
						state = ProductModelState.Registering;
					}else{
						state = ProductModelState.Registered;
					}
			
			}else if((state == ProductModelState.Registered) && (sEventName.compareTo("newRegisterEvent") == 0)){
			
				state = ProductModelState.Registering;
				
			}else if((state == ProductModelState.Registered) && (sEventName.compareTo("finaliseEvent") == 0)){
				closeSection();	
			}
		}
	}

	private void closeSection() {
		adapter.appCloseSession();
		
	}

	private void saveProduct() {
		adapter.appSaveProductModel();
		
	}

	private Boolean modelIsValid() {
		return adapter.appValidadeProductModel();
	}
	

}
