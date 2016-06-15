package testing.adapter.impl;

import testing.adapter.ProductAdapter;
import testing.pageobject.TelaProduto;
import testing.util.Utils;

public class ProductWebAdapter implements ProductAdapter {
	
	private TelaProduto tela;
	
	public ProductWebAdapter(){
		this.tela = new TelaProduto();
	}

	@Override
	public void closeSession() {
		tela.finaliza();
	}

	@Override
	public boolean trySaveProduct(boolean valid) {
		tela.clicaLimpar();
		
		tela.setModeloProduto(0);
		if(valid){
			tela.setNomeProduto("Produto teste "+ Utils.getRandomId());
			tela.setSizeProduto(0);
			tela.setSkuProduto("TST"+ Utils.getRandomId());
		}
		tela.setVariationProduto("Teste");
		
		addMaterials();
		
		tela.clicaCadastrar();
		Utils.sleep(1000);
		return tela.isSaveSuccessMessageDisplayed();
	}
	
	private void addMaterials(){
		tela.escolheMateriaPrima(0);
		tela.setQtdeMateriaPrima(2);
		tela.addMateriaPrima();
	}

	@Override
	public void clickDelete() {
		tela.clicaExcluir();
	}

	@Override
	public void cancelDeletion() {
		tela.cancelaExcluir();
	}

	@Override
	public boolean tryDeleteProduct(boolean valid) {
		tela.confirmaExcluir();
		Utils.sleep(1000);
		return tela.isDeleteSuccessMessageDisplayed();
	}

	@Override
	public void clickToChooseProduct() {
		tela.selecionaProduto();
	}

	@Override
	public void clickUpdate() {
		tela.clicaAlterar();
	}

	@Override
	public void clickCleanBt() {
		tela.clicaLimpar();
	}

}
