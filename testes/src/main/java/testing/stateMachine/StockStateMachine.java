package testing.stateMachine;

import testing.adapter.StockAdapter;
import testing.adapter.impl.StockWebAdapter;

public class StockStateMachine {
	public StockState state;
	public boolean status; 
	public boolean statusQnt;
	public boolean statusPrice;
	public boolean statusObs;
	public boolean statusBt;
	public boolean qntValid;
	public boolean priceValid;
	private StockAdapter adapter;
	
	public StockStateMachine(){
		state = StockState.Idle;
		status = false;
		statusQnt = false;
		statusPrice = false;
		statusObs = false;
		statusBt = false;
		this.adapter = new StockWebAdapter();
	}
	
	public StockStateMachine clone(){
		StockStateMachine cl = new StockStateMachine();
		cl.state = this.state;
		cl.status = this.status;
		cl.statusQnt = this.statusQnt;
		cl.statusObs = this.statusObs;
		cl.statusPrice = this.statusPrice;
		cl.statusBt = this.statusBt;
		return cl;
	}
	
	public void handleEvent(Object...objects){
		if(objects.length <= 0){
			return;
		}
		
		String sEventName = (String)objects[0];
		
		switch(state){
		case Idle:
			if(sEventName.compareTo("startEntryEvent") == 0){
				adapter.clickEntryBt();
				state = StockState.FindProduct;
			}
			
		case FindProduct:
			if(sEventName.compareTo("chooseProductEvent") == 0){
				adapter.clickProduct();
				state = StockState.EntryStock;
			}
		
		case EntryStock:
			if(sEventName.compareTo("fillParametersEvent") == 0){
				statusQnt = ((Boolean)objects[1]).booleanValue();
				statusPrice = ((Boolean)objects[2]).booleanValue();
				
				statusQnt = adapter.fillAndValidadeQnt(statusQnt);
				statusPrice = adapter.fillAndValidadePrice(statusPrice);
				statusObs = adapter.fillAndValidadeObs();
				statusBt = adapter.clickRegister();
				
				if (statusBt && statusQnt && statusPrice){
				//if (statusQnt && statusPrice){
					state = StockState.ProdInStock;
				}else{
					state = StockState.EntryStock;
				}
			}
			
			if(sEventName.compareTo("newSearchEvent") == 0){
				adapter.clickNewSearchBt();
				state = StockState.FindProduct;
			}
			
		//case Registering:
		case ProdInStock:
			if(sEventName.compareTo("finaliseEvent") == 0){
				adapter.closeSession();
			}
			
			if(sEventName.compareTo("newEntryEvent") == 0){
				adapter.clickNewSearchBt();
				state = StockState.FindProduct;
			}
		//case ProdNotInStock:
			
		}
	}

}
