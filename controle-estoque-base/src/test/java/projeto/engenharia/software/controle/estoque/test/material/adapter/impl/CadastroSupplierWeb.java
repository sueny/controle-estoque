package projeto.engenharia.software.controle.estoque.test.material.adapter.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projeto.engenharia.software.controle.estoque.base.entity.Supplier;
import projeto.engenharia.software.controle.estoque.test.adapter.IAdapterSupplier;
import projeto.engenharia.software.controle.estoque.test.pageobject.TelaCadastroSupplier;

/**
 *
 * @author Sueny
 */
public class CadastroSupplierWeb implements IAdapterSupplier{

    private static final String PAGE_LOCATION = "http://localhost:8027/controle-estoque-web/client/views/index.html";

    private static WebDriver driver;

    private static TelaCadastroSupplier telaSupplier;

    public CadastroSupplierWeb() {
        System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        System.out.println("driver created");
        driver.get(PAGE_LOCATION);
        telaSupplier = new TelaCadastroSupplier(driver);
    }
    
    @Override
    public boolean startRegister() {
        System.out.println("Tela de cadastro já está aberta!");
        return true;
    }

    @Override
    public boolean startUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean startDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean submitRegisterAndUpdate(Supplier supplier) {
        telaSupplier.getTxtName().sendKeys(supplier.getName());
        telaSupplier.getTxtCnpj().sendKeys(supplier.getCnpj());
        telaSupplier.getTxtIe().sendKeys(supplier.getIe());
        telaSupplier.getTxtPhoneNumber().sendKeys(supplier.getPhoneNumber());
        telaSupplier.getTxtCellNumber().sendKeys(supplier.getCellNumber());
        telaSupplier.getTxtAddress().sendKeys(supplier.getAddress());
        telaSupplier.getTxtNumber().sendKeys(supplier.getNumber());
        telaSupplier.getTxtNeighborhood().sendKeys(supplier.getNeighborhood());
        telaSupplier.getTxtCity().sendKeys(supplier.getCity());
        telaSupplier.getSelState().getOptions().get(0).click();
        telaSupplier.getTxtCep().sendKeys(supplier.getCep());
        telaSupplier.getTxtEmail().sendKeys(supplier.getEmail());
        telaSupplier.getTxtObs().sendKeys(supplier.getObs());
        
        telaSupplier.getBtnCadastrar().click();
        return telaSupplier.isSuccessMessageDisplayed();
    }

    @Override
    public boolean submitDelete(boolean delete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public void closeSession() {
        driver.quit();
    }

}
