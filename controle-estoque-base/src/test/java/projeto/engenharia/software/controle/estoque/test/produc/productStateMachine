package product;


public class ProductStateMachine extends java.lang.Object implements java.lang.Cloneable{
	public Boolean statusProduct = false;
	public ProductState state;
	private ProductAdapter adapter;
	
	public ProductStateMachine(){
		state = ProductState.Idle;
		statusProduct = false;
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
		}
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
