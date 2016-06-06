package testing.adapter.impl;

import testing.adapter.ProductAdapter;
import testing.pageobject.TelaProduto;
import testing.util.Utils;

public class ProductWebAdapter implements ProductAdapter {
	
	private TelaProduto tela;
	
	public ProductWebAdapter(){
		this.tela = new TelaProduto();
	}

	public void closeSession() {
		tela.finaliza();
	}

	public boolean trySaveProduct() {
		tela.clicaLimpar();
		
		tela.setModeloProduto(0);
		tela.setNomeProduto("Produto teste "+ Utils.getRandomId());
		tela.setSizeProduto(0);
		tela.setSkuProduto("TST"+ Utils.getRandomId());
		tela.setVariationProduto("Teste");
		
		addMaterials();
		
		tela.clicaCadastrar();
		Utils.sleep(1000);
		return tela.isSaveSuccessMessageDisplayed();
	}
	
	private void addMaterials(){
		tela.setNomeMateriaPrima("velcro");
		tela.setQtdeMateriaPrima(2);
		tela.addMateriaPrima();
	}

	public void clickDelete() {
		tela.clicaExcluir();
	}

	public void cancelDeletion() {
		tela.cancelaExcluir();
	}

	public boolean tryDeleteProduct() {
		tela.confirmaExcluir();
		Utils.sleep(1000);
		return tela.isDeleteSuccessMessageDisplayed();
	}

	public void clickToChooseProduct() {
		// TODO Auto-generated method stub
		
	}

	public void clickUpdate() {
		// TODO Auto-generated method stub
		
	}

}
