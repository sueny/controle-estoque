package testing.adapter.impl;

import testing.adapter.StockAdapter;
import testing.pageobject.TelaEntradaEstoque;
import testing.util.Utils;

public class StockWebAdapter implements StockAdapter {
	
	private TelaEntradaEstoque tela;
	
	public StockWebAdapter() {
		this.tela = new TelaEntradaEstoque();
	}

	@Override
	public void clickEntryBt() {
		// no need to do this
	}

	@Override
	public void clickProduct() {
		tela.selecionaProduto(0);
	}

	@Override
	public boolean fillAndValidadeObs() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fillAndValidadePrice(boolean status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fillAndValidadeQnt(boolean status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clickNewSearchBt() {
		tela.cancela();
	}

	@Override
	public boolean clickRegister() {
		tela.envia();
		Utils.sleep(500);
		return tela.isSuccessMessageDisplayed();
	}

	@Override
	public void closeSession() {
		tela.finaliza();
	}

}
