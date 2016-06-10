package testing.adapter.impl;

import testing.adapter.ConsigAdapter;
import testing.pageobject.TelaInicioConsig;
import testing.util.Utils;

public class ConsigWebAdapter implements ConsigAdapter {
	
	private TelaInicioConsig tela;

	public ConsigWebAdapter(){
		this.tela = new TelaInicioConsig();
	}
	
	@Override
	public void clickConsig() {
		//no need to implement
	}

	@Override
	public void clickClient() {
		tela.selecionaCliente(0);
	}

	@Override
	public void clickProduct() {
		tela.selecionaProduto(0);
	}

	@Override
	public void clickNewConsig() {
		tela.cancelaConsig();
	}

	@Override
	public boolean fillAndValidateDate() {
		return true;
	}

	@Override
	public boolean fillAndValidadePrice(boolean status) {
		if(status)
			tela.setValor(13);
		else
			tela.setValor(-13);
		return status;
	}

	@Override
	public boolean fillAndValidadeObs() {
		tela.setObs("Observacao teste");
		return true;
	}

	@Override
	public boolean clickCloseKit() {
		tela.salva();
		Utils.sleep(500);
		return tela.isSuccessMessageDisplayed();
	}

	@Override
	public void closeSession() {
		tela.finaliza();
	}

	@Override
	public boolean fillAndValidateQnt(boolean status) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean clickAddBt(){
		return false;
	}
	
	/**
	 * Acerto de Consignação
	 */
	 
	 @Override
	public void clickCloseConsig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillClientName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickSearch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickArrangConsig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showErrorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickToChooseConsig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean informSoldProducts(boolean soldStatus) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean informDevProducts(boolean devStatus) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickNewArrangBt() {
		// TODO Auto-generated method stub
		
	}


}
