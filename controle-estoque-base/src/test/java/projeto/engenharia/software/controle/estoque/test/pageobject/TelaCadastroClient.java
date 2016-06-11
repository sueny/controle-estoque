package projeto.engenharia.software.controle.estoque.test.pageobject;

import java.util.List;
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
public class TelaCadastroClient {
    
    /*Atributos da classe Client*/
    private Select selType;
    private WebElement txtName;
    private WebElement txtPhoneNumber;
    private WebElement txtCellNumber;
    private WebElement txtRg;
    private WebElement txtCpf;
    private WebElement txtCnpj;
    private WebElement txtIe;
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
    private WebElement btnMostrarLista;
    
    private WebElement success;
    
    
    /*Driver*/
    private final WebDriver driver;

    public TelaCadastroClient(WebDriver driver) {
        this.driver = driver;
        
        selType = new Select(driver.findElement(By.name("typeClient")));
        this.txtName = driver.findElement(By.name("nomeClient"));
        this.txtCpf = driver.findElement(By.name("cpfClient"));
        this.txtRg = driver.findElement(By.name("rgClient"));
        this.txtCnpj = driver.findElement(By.name("cnpjClient"));
        this.txtIe = driver.findElement(By.name("ieClient"));
        this.txtPhoneNumber = driver.findElement(By.name("phoneNumberClient"));
        this.txtCellNumber = driver.findElement(By.name("cellNumberClient"));
        this.txtAddress = driver.findElement(By.name("addressClient"));
        this.txtNumber = driver.findElement(By.name("numberClient"));
        this.txtNeighborhood = driver.findElement(By.name("neighborhoodClient"));
        this.txtCity = driver.findElement(By.name("cityClient"));
        this.selState = new Select(driver.findElement(By.name("stateClient")));
        this.txtEmail = driver.findElement(By.name("emailClient"));
        this.txtCep = driver.findElement(By.name("cepClient"));
        this.txtObs = driver.findElement(By.name("obsClient"));
        
        this.btnCadastrar = driver.findElement(By.name("btnCadastrarClient"));
        this.btnExcluir = driver.findElement(By.name("btnExcluirClient"));
        this.btnLimpar = driver.findElement(By.name("btnNovoClient"));
        
        this.success = driver.findElement(By.name("success"));
        
    }
    
    //A message with id="msg" must be displayed
    public boolean isSuccessMessageDisplayed() {
        final WebElement dialog = driver.findElement(By.id("msg"));
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return dialog.isDisplayed();
            }
        });
        
        return Boolean.valueOf(success.getText());
    }

    /**
     * Get inputs 
     * @return 
     */
    
    public Select getSelType() {
        return selType;
    }

    public WebElement getTxtName() {
        return txtName;
    }

    public WebElement getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public WebElement getTxtCellNumber() {
        return txtCellNumber;
    }

    public WebElement getTxtRg() {
        return txtRg;
    }

    public WebElement getTxtCpf() {
        return txtCpf;
    }

    public WebElement getTxtCnpj() {
        return txtCnpj;
    }

    public WebElement getTxtIe() {
        return txtIe;
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

    public WebElement getBtnCadastrar() {
        return btnCadastrar;
    }

    public WebElement getBtnExcluir() {
        return btnExcluir;
    }

    public WebElement getBtnLimpar() {
        return btnLimpar;
    }

    public WebElement getBtnMostrarLista() {
        return btnMostrarLista;
    }

    public WebElement getSuccess() {
        return success;
    }
    
       
}
