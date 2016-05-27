package product;

import estoque2.State;

public class ProductStateMachine extends java.lang.Object implements java.lang.Cloneable{
	public Boolean statusProduct = false;
	public Boolean skuProdValid = false;
	public ProductState state;
	private ProductAdapter adapter;
	
	public ProductStateMachine(){
		state = ProductState.Idle;
		statusProduct = false;
		skuProdValid = false;
	}
	
	public ProductStateMachine clone(){
		ProductStateMachine cl = new ProductStateMachine();
		cl.state = this.state;
		cl.statusProduct = this.statusProduct;
		//cl.adapter = this.adapter;
		
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
				
				}else  if((state == ProductState.Registering) && (sEventName.compareTo("validEvent") == 0)) {
					//statusProduct= ((Boolean)in_colObject[1]).booleanValue();
					
					statusProduct = productIsValid();
									
					if(statusProduct == false){
						state = ProductState.Registering;
					}else{
						saveProduct();
						state = ProductState.Registered;
					}
			
			}else if((state == ProductState.Registered) && (sEventName.compareTo("newRegisterEvent") == 0)){
			
				state = ProductState.Registering;
				
			}else if((state == ProductState.Registered) && (sEventName.compareTo("finaliseEvent") == 0)){
				closeSection();	
			}
		
			/**
			 * Delete Product 	
			 */
			if((state == ProductState.Idle) && (sEventName.compareTo("deleteEvent") == 0)){
				state = ProductState.Input;
				
			}else if((state == ProductState.Input) && (sEventName.compareTo("okEvent") == 0)){
				skuProdValid = isSkuProdValid();
				
				if(skuProdValid == true){
					state = ProductState.Confirm;
				}else{
					state = ProductState.Input;
				}
				
			}else if((state == ProductState.Confirm) && (sEventName.compareTo("confirmEvent") == 0)){
				deleteData();
				state = ProductState.Deleted;
			}else if((state == ProductState.Confirm) && (sEventName.compareTo("cancelEvent") == 0)){
				state = ProductState.Input;
			}
		}
	}
	
	protected boolean deleteData(){
		return adapter.appDeleteData();
	}
	
	protected boolean isSkuProdValid(){
		return adapter.appIsSkuValid();
		
	}
	
	protected void closeSection(){
		adapter.appCloseSection();
	}
	
	protected Boolean productIsValid(){
		return adapter.appValidadeProduct();
	}
	
	protected void saveProduct(){
		adapter.appSaveProduct();
	}
	
}
