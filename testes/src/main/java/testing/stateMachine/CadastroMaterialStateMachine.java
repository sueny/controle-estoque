package testing.stateMachine;

import testing.adapter.CadastroMaterialAdapter;
import testing.adapter.impl.CadastroMaterialWebAdapter;

public class CadastroMaterialStateMachine extends java.lang.Object implements java.lang.Cloneable{
	
	public State state;
	public Integer skuMaterial;
	public Integer unitMaterial;
	public Boolean registerStatus;
	private CadastroMaterialAdapter adapter; 
	
	public CadastroMaterialStateMachine(){
		state = State.Idle;
		registerStatus = false;
		skuMaterial = 0;
		unitMaterial = 0;
		this.adapter = new CadastroMaterialWebAdapter();
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
			
			/**
			 * Register Material
			 */
			if ((state == State.Idle) && (sEventName.compareTo("registerEvent") == 0)){
				state = State.Registering;
				
				}else  if((state == State.Registering) && (sEventName.compareTo("validEvent") == 0)) {
					registerStatus = ((Boolean)in_colObject[1]).booleanValue();
					
					registerStatus = adapter.tryRegister(registerStatus);
					
					if(registerStatus == false){
						state = State.Registering;
					}else{
						
						state = State.Registered;
					}
			
			}else if((state == State.Registered) && (sEventName.compareTo("newRegisterEvent") == 0)){
			
				state = State.Registering;
				
			}else if((state == State.Registered) && (sEventName.compareTo("finaliseEvent") == 0)){
				adapter.closeSession();	
			}
			
			/**
			 * Delete Material
			 */
			
			if((state == State.Idle) && (sEventName.compareTo("deleteEvent") == 0)){
				state = State.Input;
				
			}else if((state == State.Input) && (sEventName.compareTo("okEvent") == 0)){
				adapter.clickToDeleteMaterial();
				state = State.Confirm;
				
			}else if((state == State.Confirm) && (sEventName.compareTo("confirmEvent") == 0)){
				registerStatus = ((Boolean)in_colObject[1]).booleanValue();
				
				registerStatus = adapter.confirmDeletion(registerStatus);
				
				if(registerStatus == false){
					state = State.Input;
				}else{
					
					state = State.Deleted;
				}
		
				
			}else if((state == State.Confirm) && (sEventName.compareTo("cancelEvent") == 0)){
				adapter.cancelDeletion();
				state = State.Input;
				
			}else if((state == State.Deleted) && (sEventName.compareTo("finaliseEvent") == 0)){
				adapter.closeSession();
			}
			
		}
	}
	
}
