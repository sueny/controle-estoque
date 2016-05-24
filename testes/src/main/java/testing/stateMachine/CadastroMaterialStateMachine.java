package testing.stateMachine;

import testing.adapter.CadastroMaterial;

public class CadastroMaterialStateMachine extends java.lang.Object implements java.lang.Cloneable{
	
	public State state;
	public Integer skuMaterial;
	public Integer unitMaterial;
	public Boolean registerStatus;
	private CadastroMaterial adapter; 
	
	public CadastroMaterialStateMachine(){
		state = State.Idle;
		registerStatus = false;
		skuMaterial = 0;
		unitMaterial = 0;
		
	}
	
	public CadastroMaterialStateMachine clone(){
		CadastroMaterialStateMachine cl = new CadastroMaterialStateMachine();
		
		cl.state = this.state;
		cl.skuMaterial = this.skuMaterial;
		cl.unitMaterial = this.unitMaterial;
		cl.registerStatus = this.registerStatus;
		cl.adapter = this.adapter;
		
		return cl;
	}
	
	public void handleEvent(Object... in_colObject){
		if(in_colObject.length > 0){
			
			String sEventName = (String)in_colObject[0];
			if ((state == State.Idle) && (sEventName.compareTo("registerEvent") == 0)){
				//values generated by parteg
				//skuMaterial = ((Integer)in_colObject[1]).intValue();
				//unitMaterial = ((Integer)in_colObject[1]).intValue();
				
				state = State.Registering;
				
				}else  if((state == State.Registering) && (sEventName.compareTo("validEvent") == 0)) {
					skuMaterial = ((Integer)in_colObject[1]).intValue();
					unitMaterial = ((Integer)in_colObject[2]).intValue();
					
					registerStatus = registerIsValid(skuMaterial, unitMaterial);
					
					if(registerStatus == false){
						state = State.Registering;
					}else{
						state = State.Registered;
					}
			
			}else if((state == State.Registered) && (sEventName.compareTo("newRegisterEvent") == 0)){
				state = State.Registering;
				
			}else if((state == State.Registered) && (sEventName.compareTo("finaliseEvent") == 0)){
				closeSection();
				
			}
			
			if((state == State.Idle) && (sEventName.compareTo("deleteEvent") == 0)){
				state = State.Input;
				
			}else if((state == State.Input) && (sEventName.compareTo("okEvent") == 0)){
				
				registerStatus = registerIsValid(skuMaterial, unitMaterial);
				
				if(registerStatus == true){
					state = State.Confirm;
				}else{
					state = State.Input;
				}
				
			}else if((state == State.Confirm) && (sEventName.compareTo("confirmEvent") == 0)){
				deleteData(skuMaterial);
				state = State.Deleted;
			}else if((state == State.Confirm) && (sEventName.compareTo("cancelEvent") == 0)){
				state = State.Input;
			}
			
		}
	}
	
	protected Boolean registerIsValid(Integer sku, Integer unit){
		
		return adapter.register(sku, unit);
	}
	protected void closeSection(){
		adapter.closeSession();
	}
	
	protected Boolean deleteData(Integer sku){
		return adapter.deleteData(sku);
	}
}
