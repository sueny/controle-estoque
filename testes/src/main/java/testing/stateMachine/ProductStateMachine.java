package testing.stateMachine;

import testing.adapter.ProductAdapter;
import testing.adapter.impl.ProductWebAdapter;

public class ProductStateMachine extends java.lang.Object implements java.lang.Cloneable{
	public Boolean statusProduct = false;
	public Boolean skuProdValid = false;
	public Boolean successStatus = false;
	public ProductState state;
	private ProductAdapter adapter;
	
	public ProductStateMachine(){
		state = ProductState.Idle;
		statusProduct = false;
		skuProdValid = false;
		successStatus = false;
		adapter = new ProductWebAdapter();
	}
	
	public ProductStateMachine clone(){
		ProductStateMachine cl = new ProductStateMachine();
		cl.state = this.state;
		cl.statusProduct = this.statusProduct;
		cl.successStatus = this.successStatus;
		cl.adapter = this.adapter;
		
		return cl;
	}
	
	public void handleEvent(Object... in_colObject){
		if(in_colObject.length > 0){
			
			String sEventName = (String)in_colObject[0];
			
			/**
			 * Register Product 
			 * */
			
			if ((state == ProductState.Idle) && (sEventName.compareTo("registerEvent") == 0)){
						
				state = ProductState.Registering;
				
				}else  if((state == ProductState.Registering) && (sEventName.compareTo("validProdEvent") == 0)) {
					statusProduct= ((Boolean)in_colObject[1]).booleanValue();
						
					statusProduct = adapter.trySaveProduct(statusProduct);
									
					if(statusProduct == false){
						state = ProductState.Registering;
					}else{
						
						state = ProductState.Registered;
					}
			
			}else if((state == ProductState.Registered) && (sEventName.compareTo("newRegProdEvent") == 0)){
			
				state = ProductState.Registering;
				
			}else if((state == ProductState.Registered) && (sEventName.compareTo("finaliseEvent") == 0)){
				
				adapter.closeSession();	
				 
			}
		
			
			/**
			 * Update Product 
			 * */
			
			if ((state == ProductState.Idle) && (sEventName.compareTo("updateEvent") == 0)){
						
				state = ProductState.Principal;
				
			}else  if((state == ProductState.Principal) && (sEventName.compareTo("chooseProd") == 0)) {
				adapter.clickToChooseProduct();
				state = ProductState.Updating;
			
			}else if((state == ProductState.Principal) && (sEventName.compareTo("cleanEvent") == 0)){
				adapter.clickCleanBt();
				state = ProductState.Idle;
				
			}else if((state == ProductState.Updating) && (sEventName.compareTo("validProdEvent") == 0)){
				adapter.clickUpdate();
				statusProduct= ((Boolean)in_colObject[1]).booleanValue();
				
				statusProduct = adapter.trySaveProduct(statusProduct);
				
				if(statusProduct == false){
					state = ProductState.Principal;
				}else{
					state = ProductState.Updated;
				}
				
				
			}else if((state == ProductState.Updated) && (sEventName.compareTo("finaliseEvent") == 0)){
				
				adapter.closeSession();	
				 
				
			}else if((state == ProductState.Updated) && (sEventName.compareTo("newUpdate") == 0)){
				state = ProductState.Principal;
			}
		
			
			
			/**
			 * Delete Product 	
			 */
			if((state == ProductState.Idle) && (sEventName.compareTo("deleteEvent") == 0)){
				adapter.clickToChooseProduct();
				state = ProductState.Input;
				
			}else if((state == ProductState.Input) && (sEventName.compareTo("okEvent") == 0)){
				adapter.clickDelete();
				state = ProductState.Confirm;

			}else if((state == ProductState.Input) && (sEventName.compareTo("cleanEvent") == 0)){
				adapter.clickCleanBt();
				state = ProductState.Idle;
				
			}else if((state == ProductState.Confirm) && (sEventName.compareTo("confirmEvent") == 0)){
				successStatus = ((Boolean)in_colObject[1]).booleanValue();
				
				successStatus = adapter.tryDeleteProduct(successStatus);
				
				if(successStatus){
					state = ProductState.Deleted;
				}else{
					state = ProductState.Input;
				}
				
				
			}else if((state == ProductState.Confirm) && (sEventName.compareTo("cancelEvent") == 0)){
				adapter.cancelDeletion();
				state = ProductState.Input;
				
			}else if((state == ProductState.Deleted) && (sEventName.compareTo("finaliseEvent") == 0) ){
				adapter.closeSession();
			}
		}
	}
	
}
