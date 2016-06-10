package testing.adapter.impl;

import testing.adapter.ConsigAdapter;
import testing.pageobject.TelaAcertoConsig;
import testing.pageobject.TelaInicioConsig;
import testing.util.Utils;

public class ConsigWebAdapter implements ConsigAdapter {
	
	private TelaInicioConsig tela;
	private TelaAcertoConsig tela2;

	public ConsigWebAdapter(){
		
	}
	
	@Override
	public void openConsigScreen() {
		this.tela = new TelaInicioConsig();
	}

	@Override
	public void chooseClient() {
		if(tela != null)
			tela.selecionaCliente(0);
		if(tela2 != null)
			tela2.selecionaCliente(0);
	}

	@Override
	public void chooseProduct() {
		tela.selecionaProduto(0);
	}

	@Override
	public void cancelConsig() {
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
		if(tela != null)
			tela.finaliza();
		if(tela2 != null)
			tela2.finaliza();
	}

	@Override
	public boolean fillAndValidateQnt(boolean status) {
		if(status)
			tela.setQtde(3);
		else
			tela.setQtde(-3);
		return status;
	}
	
	@Override
	public boolean addProduct(){
		tela.adicionaProduto();
		return !tela.isBtnAdicionaProdutoVisivel();
	}
	
	/**
	 * Acerto de Consignação
	 */
	 
	 @Override
	public void saveConsigAdjustment() {
		 tela2.salva();
	}

	@Override
	public void openConsigAdjustmentScreen() {
		this.tela2 = new TelaAcertoConsig();
	}

	@Override
	public void showErrorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseConsig() {
		tela2.selecionaConsig(0);
	}

	@Override
	public boolean fillSoldProductAmounts(boolean soldStatus) {
		tela2.preencheQuantidades(soldStatus);
		return soldStatus;
	}

	@Override
	public void cancelConsigAdjustment() {
		tela2.cancelaAcerto();
	}


}
