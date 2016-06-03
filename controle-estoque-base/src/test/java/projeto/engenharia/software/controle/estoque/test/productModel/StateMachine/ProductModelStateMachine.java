
package projeto.engenharia.software.controle.estoque.test.productModel.StateMachine;

import projeto.engenharia.software.controle.estoque.test.adapter.ProductModelAdapter;

public class ProductModelStateMachine extends java.lang.Object implements java.lang.Cloneable{
	public Boolean valid = false;
	public ProductModelState state;
	private ProductModelAdapter adapter;
	
	public ProductModelStateMachine(){
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
					valid = ((Boolean)in_colObject[1]).booleanValue();
					
					/*descomentar quando implementar o método.
					 * valid = saveProduct();
					 */
					
									
					if((valid == false)){
						state = ProductModelState.Registering;
					}else{
						
						state = ProductModelState.Registered;
					}
			
			}else if((state == ProductModelState.Registered) && (sEventName.compareTo("newRegModelEvent") == 0)){
			
				state = ProductModelState.Registering;
				
			}else if((state == ProductModelState.Registered) && (sEventName.compareTo("finaliseEvent") == 0)){
				/*descomentar quando implementar o método
				 * closeSection();	
				 * 
				 */
			}
		}
	}

	private void closeSection() {
		adapter.appCloseSection();
		
	}

//	private Boolean saveProduct() {
//		return adapter.appSaveProductModel();
//		
//	}

	/*
	 * private Boolean modelIsValid() {
	 *	return adapter.appValidadeProductModel();
	}*/
	

}
