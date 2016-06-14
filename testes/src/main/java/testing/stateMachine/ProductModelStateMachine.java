package testing.stateMachine;
//package projeto.engenharia.software.controle.estoque.test.productModel.StateMachine;

import testing.adapter.ProductModelAdapter;

//import projeto.engenharia.software.controle.estoque.test.adapter.ProductModelAdapter;

public class ProductModelStateMachine extends java.lang.Object implements java.lang.Cloneable{
	public Boolean valid = false;
	public boolean confirmStatus = false;
	public ProductModelState state;
	private ProductModelAdapter adapter;
	
	public ProductModelStateMachine(){
		state = ProductModelState.Idle;
		valid = false;
		confirmStatus = false;
	}
	
	public ProductModelStateMachine clone(){
		ProductModelStateMachine cl = new ProductModelStateMachine();
		cl.state = this.state;
		cl.valid = this.valid;
		cl.confirmStatus = this.confirmStatus;
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
					valid = ((Boolean)in_colObject[1]).booleanValue();
					
					valid = saveProduct(valid);
					 
					
									
					if((valid == false)){
						state = ProductModelState.Registering;
					}else{
						
						state = ProductModelState.Registered;
					}
			
			}else if((state == ProductModelState.Registered) && (sEventName.compareTo("newRegModelEvent") == 0)){
			
				state = ProductModelState.Registering;
				
			}else if((state == ProductModelState.Registered) && (sEventName.compareTo("finaliseEvent") == 0)){
				closeSession();	
				 
			}
			
			/**
			 * Delete Product Model
			 * */
			
			if((state == ProductModelState.Idle) && (sEventName.compareTo("deleteEvent")) == 0){
				state = ProductModelState.Input;
				
			}else if((state == ProductModelState.Input) && (sEventName.compareTo("okEvent")) == 0){
				adapter.clickDelete();
				state = ProductModelState.Confirm;
				
			}else if((state == ProductModelState.Confirm)&&(sEventName.compareTo("cancelEvent")) == 0){
				adapter.clickCancelDeletion();
				state = ProductModelState.Input;
				
			}else if((state == ProductModelState.Confirm)&&(sEventName.compareTo("confirmEvent")) == 0){
				confirmStatus = ((Boolean)in_colObject[1]).booleanValue();
				confirmStatus = adapter.tryDeleteProductModel(confirmStatus);
				
				if(confirmStatus){
					state = ProductModelState.Deleted;
				}else{
					state = ProductModelState.Input;
				}
				
			}else if((state == ProductModelState.Deleted)&&(sEventName.compareTo("finaliseEvent")) == 0){
				adapter.appCloseSession();
			}
			
		}
	}

	private void closeSession() {
		adapter.appCloseSession();
		
	}

	private Boolean saveProduct(boolean valid) {
		return adapter.appSaveProductModel(valid);
	}

	/*
	 * private Boolean modelIsValid() {
	 *	return adapter.appValidadeProductModel();
	}*/
	

}
