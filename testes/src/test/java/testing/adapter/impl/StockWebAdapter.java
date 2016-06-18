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
		tela.buscarProduto();
	}

	@Override
	public void clickProduct() {
		tela.selecionaProduto(0);
	}

	@Override
	public boolean fillAndValidadeObs() {
		tela.setObservacao("observacao teste");
		return true;
	}

	@Override
	public boolean fillAndValidadePrice(boolean status) {
		if(status)
			tela.setValor(5);
		return status;
	}

	@Override
	public boolean fillAndValidadeQnt(boolean status) {
		if(status)
			tela.setQtde(4);
		return status;
	}

	@Override
	public void cancela() {
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
