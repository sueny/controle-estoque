package testing.adapter.impl;

import testing.adapter.ClientAdapter;
import testing.pageobject.TelaCliente;

public class ClientWebAdapter implements ClientAdapter {
	
	private TelaCliente tela;
	
	public ClientWebAdapter(){
		this.tela = new TelaCliente();
	}

	@Override
	public boolean startRegister() {
		return true;
	}

    @Override
    public boolean startUpdate() {
        tela.selecionaItem();
        return true;
    }

    @Override
    public boolean startDelete() {
    	tela.selecionaItem();
    	tela.clicaExcluir();
        return true;
    }

    @Override
	public boolean submitRegisterAndUpdate(boolean validData) {
		tela.preencheForm(validData);
		tela.clicaSalvar();
		return tela.isSaveSuccessMessageDisplayed();
	}

	public boolean submitDelete(boolean delete) {
	    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		//return tela.isDeleteSuccessMessageDisplayed();
	}

	public void closeSession() {
		tela.finaliza();
	}

}
