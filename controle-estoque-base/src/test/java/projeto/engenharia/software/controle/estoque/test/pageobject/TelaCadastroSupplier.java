package projeto.engenharia.software.controle.estoque.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Sueny
 */
public class TelaCadastroSupplier {
    
    /*Atributos da classe Supplier*/
    private WebElement txtName;
    private WebElement txtCnpj;
    private WebElement txtIe;
    private WebElement txtPhoneNumber;
    private WebElement txtCellNumber;
    private WebElement txtAddress;
    private WebElement txtNumber;
    private WebElement txtNeighborhood;
    private WebElement txtCity;
    private Select selState;
    private WebElement txtCep;
    private WebElement txtEmail;
    private WebElement txtObs;
    
    /*Botões para interagir com a tela*/
    private WebElement btnCadastrar;
    private WebElement btnExcluir;
    private WebElement btnLimpar;
    
    
    /*Driver*/
    private final WebDriver driver;

    public TelaCadastroSupplier(WebDriver driver) {
        this.driver = driver;
        
        this.txtName = driver.findElement(By.name("nomeFornecedor"));
        this.txtCnpj = driver.findElement(By.name("cnpjFornecedor"));
        this.txtIe = driver.findElement(By.name("ieFornecedor"));
        this.txtPhoneNumber = driver.findElement(By.name("phoneNumberFornecedor"));
        this.txtCellNumber = driver.findElement(By.name("cellNumberFornecedor"));
        this.txtAddress = driver.findElement(By.name("enderecoFornecedor"));
        this.txtNumber = driver.findElement(By.name("numberFornecedor"));
        this.txtNeighborhood = driver.findElement(By.name("neighborhoodFornecedor"));
        this.txtCity = driver.findElement(By.name("cidadeFornecedor"));
        this.selState = new Select(driver.findElement(By.name("stateFornecedor")));
        this.txtCep = driver.findElement(By.name("cepFornecedor"));
        this.txtEmail = driver.findElement(By.name("emailFornecedor"));
        this.txtObs = driver.findElement(By.name("obsFornecedor"));
        
        this.btnCadastrar = driver.findElement(By.name("btnCadastrarFornecedor"));
        this.btnExcluir = driver.findElement(By.name("btnExcluirFornecedor"));
        this.btnLimpar = driver.findElement(By.name("btnLimparFornecedor"));
        
    }
    
    //A message with id="msgSucesso" must be displayed
    public boolean isSuccessMessageDisplayed() {
        final WebElement dialog = driver.findElement(By.id("msgSucesso"));
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return dialog.isDisplayed();
            }
        });
        return dialog.isDisplayed();
    }

    public WebElement getTxtName() {
        return txtName;
    }

    public WebElement getTxtCnpj() {
        return txtCnpj;
    }

    public WebElement getTxtIe() {
        return txtIe;
    }

    public WebElement getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public WebElement getTxtCellNumber() {
        return txtCellNumber;
    }

    public WebElement getTxtAddress() {
        return txtAddress;
    }

    public WebElement getTxtNumber() {
        return txtNumber;
    }

    public WebElement getTxtNeighborhood() {
        return txtNeighborhood;
    }

    public WebElement getTxtCity() {
        return txtCity;
    }

    public Select getSelState() {
        return selState;
    }

    public WebElement getTxtCep() {
        return txtCep;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }

    public WebElement getTxtObs() {
        return txtObs;
    }

    /*
     * Get BTN
     * @return 
     */
    public WebElement getBtnCadastrar() {
        return btnCadastrar;
    }

    public WebElement getBtnExcluir() {
        return btnExcluir;
    }

    public WebElement getBtnLimpar() {
        return btnLimpar;
    }
    
}
