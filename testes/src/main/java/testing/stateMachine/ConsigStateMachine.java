package testing.stateMachine;

import testing.adapter.ConsigAdapter;
import testing.adapter.impl.ConsigWebAdapter;

public class ConsigStateMachine extends java.lang.Object implements java.lang.Cloneable{
	public ConsigState state;
	public boolean status;
	public boolean dateValid;
	public boolean qntValid;
	public boolean priceValid;
	public boolean obsValid;
	public boolean statusKit;
	public boolean statusBt;
	public boolean soldStatus;
	public boolean devStatus;
	private ConsigAdapter adapter;
	
	public ConsigStateMachine(){
		state = ConsigState.Idle;
		status = false;
		dateValid = false;
		priceValid = false;
		obsValid = false;
		qntValid = false;
		statusKit = false;
		statusBt = false;
		soldStatus = false;
		devStatus = false;
		this.adapter = new ConsigWebAdapter();
	}
	
	public ConsigStateMachine clone(){
		ConsigStateMachine cl = new ConsigStateMachine();
		cl.state = this.state;
		cl.status = this.status;
		cl.dateValid = this.dateValid;
		cl.priceValid = this.priceValid;
		cl.obsValid = this.obsValid;
		cl.statusKit = this.statusKit;
		cl.qntValid = this.qntValid;
		cl.adapter = this.adapter;
		cl.statusBt = this.statusBt;
		cl.soldStatus = this.soldStatus;
		cl.devStatus = this.devStatus;
		return cl;
	}
	
	public void handleEvent(Object...objects){
		if(objects.length <= 0){
			return;
		}
		
		String sEventName = (String)objects[0];
		
		switch(state){
		
		case Idle:
			/**
			 * Consig StateMachine
			 */
			if(sEventName.compareTo("startConsigEvent") == 0){
				adapter.openConsigScreen();
				state = ConsigState.FindClient;
				
			}
			
			/**
			 * CloseConsigStateMachine
			 */
			if(sEventName.compareTo("startCloseConsigEvent") == 0){
				adapter.openConsigAdjustmentScreen();
				state = ConsigState.FindClient;
			}
			
		case FindClient:
			
			/**
			 * Consig StateMachine
			 */
			if(sEventName.compareTo("chooseClientEvent") == 0){
				adapter.chooseClient();
				state = ConsigState.AddProducts;
			}
			
			/**
			 * CloseConsig StateMachine
			 */
			if(sEventName.compareTo("chooseClientConsigEvent") == 0){
				adapter.chooseClient();
				
				state = ConsigState.ChooseConsig;
			}
			
		case AddProducts:
			if(sEventName.compareTo("chooseProductEvent") == 0){
				adapter.chooseProduct();
				state = ConsigState.FillFormProduct;
			}
			
			if(sEventName.compareTo("newConsigEvent") == 0){
				adapter.cancelConsig();
				state = ConsigState.FindClient;
			}
			
		case FillFormProduct:
			if(sEventName.compareTo("fillParametersEvent") == 0){
				
				priceValid = ((Boolean)objects[1]).booleanValue();
				qntValid = ((Boolean)objects[2]).booleanValue();
				
				qntValid = adapter.fillAndValidateQnt(qntValid);
				priceValid = adapter.fillAndValidadePrice(priceValid);
				statusBt = adapter.addProduct();
				
				if(qntValid && priceValid && statusBt){
				//if(qntValid && priceValid){
					
					state = ConsigState.ProdAdded;
				}else{
					state = ConsigState.FillFormProduct;
				}
			}
			
			if(sEventName.compareTo("newConsigEvent") == 0){
				adapter.cancelConsig();
				state = ConsigState.FindClient;
			}
			
			
			
		//case Adding:	
		case ProdAdded:
			if(sEventName.compareTo("fillDateEvent") == 0){
				dateValid = adapter.fillAndValidateDate();
				obsValid = adapter.fillAndValidadeObs();
				
				if(dateValid && obsValid){
					state = ConsigState.FinalInfo;
				}
				
			}
			
			if(sEventName.compareTo("newConsigEvent") == 0){
				adapter.cancelConsig();
				state = ConsigState.FindClient;
			}
			
			if(sEventName.compareTo("chooseProductEvent") == 0){
				adapter.chooseProduct();
				state = ConsigState.FillFormProduct;
			}
			
		case FinalInfo:
			if(sEventName.compareTo("closeKitEvent") == 0){
				obsValid = adapter.fillAndValidadeObs();
				statusKit = adapter.clickCloseKit();
				
				if(statusKit && obsValid){
					state = ConsigState.KitReady;
				}else{
					state = ConsigState.FinalInfo;
				}
			}
			
			if(sEventName.compareTo("newConsigEvent") == 0){
				adapter.cancelConsig();
				state = ConsigState.FindClient;
			}
			
			if(sEventName.compareTo("chooseProductEvent") == 0){
				state = ConsigState.FillFormProduct;
				adapter.chooseProduct();
			}
			
		case KitReady:
			if(sEventName.compareTo("finaliseEvent") == 0){
				adapter.closeSession();
			}
			
			if(sEventName.compareTo("newConsigEvent") == 0){
				adapter.cancelConsig();
				state = ConsigState.FindClient;
			}
			
		case ChooseConsig:
			if(sEventName.compareTo("closeConsigEvent") == 0){
				adapter.saveConsigAdjustment();
				adapter.showErrorMessage();
				
				state = ConsigState.ChooseConsig;
			}
			
			if(sEventName.compareTo("newCloseConsigEvent") == 0){
				adapter.cancelConsigAdjustment();
				state = ConsigState.FindClient;
			}
			
			if(sEventName.compareTo("chooseConsigEvent") == 0){
				adapter.chooseConsig();
				state = ConsigState.CloseConsig;
			}
			
		case CloseConsig:
			if(sEventName.compareTo("newCloseConsigEvent") == 0){
				adapter.cancelConsigAdjustment();
				state = ConsigState.FindClient;
			}
			
			if(sEventName.compareTo("submitConsigEvent") == 0){
				soldStatus = ((Boolean)objects[1]).booleanValue();
				devStatus = ((Boolean)objects[2]).booleanValue();
				
				soldStatus = adapter.fillSoldProductAmounts(soldStatus);
				adapter.saveConsigAdjustment();
				
				if(soldStatus && devStatus){
					state = ConsigState.ClosedConsig;
				}else{
					state = ConsigState.CloseConsig;
				}
			}
		
		case ClosedConsig:
			if(sEventName.compareTo("finaloseOp") == 0){
				adapter.closeSession();
			}
			
			if(sEventName.compareTo("newCloseConsigEvent") == 0){
				adapter.cancelConsigAdjustment();
				state = ConsigState.FindClient;
			}
		
		}
		
	}

}
