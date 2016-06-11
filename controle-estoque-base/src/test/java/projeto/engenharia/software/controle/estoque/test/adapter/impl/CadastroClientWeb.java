package projeto.engenharia.software.controle.estoque.test.adapter.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import projeto.engenharia.software.controle.estoque.base.entity.Client;
import projeto.engenharia.software.controle.estoque.test.adapter.IAdapterClient;
import projeto.engenharia.software.controle.estoque.test.pageobject.TelaCadastroClient;

/**
 *
 * @author Sueny
 */
public class CadastroClientWeb implements IAdapterClient {

    private static final String PAGE_LOCATION = "http://localhost:3000/client/views/index.html";

    private static WebDriver driver;

    private static TelaCadastroClient telaClient;

    public CadastroClientWeb() {
        System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        System.out.println("driver created");
        driver.get(PAGE_LOCATION);
        telaClient = new TelaCadastroClient(driver);
    }

    @Override
    public boolean startRegister() {
        System.out.println("Tela de cadastro já está aberta!");
        return true;
    }

    @Override
    public boolean startUpdate() {
        telaClient.getBtnMostrarLista().click();
        //clicar em um elemento da lista TODO
        return true;
    }

    @Override
    public boolean startDelete() {
        telaClient.getBtnMostrarLista().click();
        //clicar em um elemento da lista TODO
        telaClient.getBtnExcluir().click();
        return true;
    }

    @Override
    public boolean submitRegisterAndUpdate(Client client) {        
        telaClient.getSelType().getOptions().get(0).click();
        telaClient.getTxtName().sendKeys(client.getName());
        telaClient.getTxtPhoneNumber().sendKeys(client.getPhoneNumber());
        telaClient.getTxtCellNumber().sendKeys(client.getCellNumber());
        telaClient.getTxtRg().sendKeys(client.getRg());
        telaClient.getTxtCpf().sendKeys("85953621493");
        telaClient.getTxtIe().sendKeys(client.getIe());
        telaClient.getTxtAddress().sendKeys(client.getAddress());
        telaClient.getTxtNumber().sendKeys(client.getNumber());
        telaClient.getTxtNeighborhood().sendKeys(client.getNeighborhood());
        telaClient.getTxtCity().sendKeys(client.getCity());
        telaClient.getSelState().getOptions().get(0).click();
        telaClient.getTxtCep().sendKeys(client.getCep());
        telaClient.getTxtEmail().sendKeys(client.getEmail());
        telaClient.getTxtObs().sendKeys(client.getObs());

        telaClient.getBtnCadastrar().click();
        return telaClient.isSuccessMessageDisplayed();
    }

    /**
     * O parametro boolean delete é corresponde a clicar no botão Excluir "Sim" se true, e "NÃO" se false.
     * @param delete
     * @return 
     */
    @Override
    public boolean submitDelete(boolean delete) {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeSession() {
        driver.quit();
    }

    @Override
    public void clickLimpar() {
        telaClient.getBtnLimpar().click();
    }

}
