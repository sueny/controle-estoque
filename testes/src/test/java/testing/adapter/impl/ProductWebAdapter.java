package testing.adapter.impl;

import org.openqa.selenium.By;
import testing.adapter.ProductAdapter;
import testing.pageobject.TelaProduto;
import testing.util.Utils;

public class ProductWebAdapter implements ProductAdapter {

    private TelaProduto tela;

    public ProductWebAdapter() {
        this.tela = new TelaProduto();
    }

    @Override
    public void closeSession() {
        tela.finaliza();
    }

    @Override
    public boolean trySaveProduct(boolean valid) {
        tela.limparInputs();

        tela.setModeloProduto(0);
        if (valid) {
            tela.setNomeProduto("Produto teste " + Utils.getRandomNumString(20));
            tela.setSizeProduto(0);
            tela.setSkuProduto("TST" + Utils.getRandomNumString(7));
        }
        tela.setVariationProduto("Teste");

        addMaterials();

        tela.clicaCadastrar();
        Utils.sleep(1000);
        return tela.isSaveSuccessMessageDisplayed();
    }

    private void addMaterials() {
        tela.escolheMateriaPrima(0);
        tela.setQtdeMateriaPrima(2);
        tela.addMateriaPrima();
    }

    @Override
    public boolean tryDeleteProduct(boolean valid) {
        if (valid) {
            tela.confirma();
        } else {
            tela.cancela();
        }
        Utils.sleep(1000);
        return tela.isDeleteSuccessMessageDisplayed();
    }

    @Override
    public void clickToChooseProduct() {
        tela.selecionaProduto();
    }

    @Override
    public void clickCleanBt() {
        tela.clicaLimpar();
    }

    @Override
    public void clickDelete() {
        tela.clicaExcluir();
    }

}
