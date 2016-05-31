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
public class TelaCadastroClient {
    
    /*Atributos da classe Client*/
    private WebElement txtName;
    private WebElement txtType;
    private WebElement txtDate;
    private WebElement txtGender;
    private WebElement txtPhoneNumber;
    private WebElement txtCellNumber;
    private WebElement txtRg;
    private WebElement txtCpfCnpj;
    private WebElement txtIe;
    private WebElement txtAddress;
    private WebElement txtNumber;
    private WebElement txtNeighborhood;
    private WebElement txtCity;
    private Select selState;
    private WebElement txtZipCode;
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
        
        this.txtName = driver.findElement(By.name("nameClient"));
        this.txtType = driver.findElement(By.name("typeClient"));
        this.txtDate = driver.findElement(By.name("dateClient"));
        this.txtGender = driver.findElement(By.name("genderClient"));
        this.txtPhoneNumber = driver.findElement(By.name("phoneNumberClient"));
        this.txtCellNumber = driver.findElement(By.name("cellNumberClient"));
        this.txtRg = driver.findElement(By.name("rgClient"));
        this.txtCpfCnpj = driver.findElement(By.name("cpfCnpjClient"));
        this.txtIe = driver.findElement(By.name("ieClient"));
        this.txtAddress = driver.findElement(By.name("addressClient"));
        this.txtNumber = driver.findElement(By.name("numberClient"));
        this.txtNeighborhood = driver.findElement(By.name("neighborhoodClient"));
        this.txtCity = driver.findElement(By.name("cityClient"));
        this.selState = new Select(driver.findElement(By.name("stateClient")));
        this.txtZipCode = driver.findElement(By.name("zipCodeClient"));
        this.txtEmail = driver.findElement(By.name("emailClient"));
        this.txtObs = driver.findElement(By.name("obsClient"));
        
        this.btnCadastrar = driver.findElement(By.name("btnCadastrarClient"));
        this.btnExcluir = driver.findElement(By.name("btnExcluirClient"));
        this.btnLimpar = driver.findElement(By.name("btnLimparClient"));
        
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
    
    

    public WebElement getTxtName() {
        return txtName;
    }

    public void setTxtName(WebElement txtName) {
        this.txtName = txtName;
    }

    public WebElement getTxtType() {
        return txtType;
    }

    public void setTxtType(WebElement txtType) {
        this.txtType = txtType;
    }

    public WebElement getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(WebElement txtDate) {
        this.txtDate = txtDate;
    }

    public WebElement getTxtGender() {
        return txtGender;
    }

    public void setTxtGender(WebElement txtGender) {
        this.txtGender = txtGender;
    }

    public WebElement getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public void setTxtPhoneNumber(WebElement txtPhoneNumber) {
        this.txtPhoneNumber = txtPhoneNumber;
    }

    public WebElement getTxtCellNumber() {
        return txtCellNumber;
    }

    public void setTxtCellNumber(WebElement txtCellNumber) {
        this.txtCellNumber = txtCellNumber;
    }

    public WebElement getTxtRg() {
        return txtRg;
    }

    public void setTxtRg(WebElement txtRg) {
        this.txtRg = txtRg;
    }

    public WebElement getTxtCpfCnpj() {
        return txtCpfCnpj;
    }

    public void setTxtCpfCnpj(WebElement txtCpfCnpj) {
        this.txtCpfCnpj = txtCpfCnpj;
    }

    public WebElement getTxtIe() {
        return txtIe;
    }

    public void setTxtIe(WebElement txtIe) {
        this.txtIe = txtIe;
    }

    public WebElement getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(WebElement txtAddress) {
        this.txtAddress = txtAddress;
    }

    public WebElement getTxtNumber() {
        return txtNumber;
    }

    public void setTxtNumber(WebElement txtNumber) {
        this.txtNumber = txtNumber;
    }

    public WebElement getTxtNeighborhood() {
        return txtNeighborhood;
    }

    public void setTxtNeighborhood(WebElement txtNeighborhood) {
        this.txtNeighborhood = txtNeighborhood;
    }

    public WebElement getTxtCity() {
        return txtCity;
    }

    public void setTxtCity(WebElement txtCity) {
        this.txtCity = txtCity;
    }

    public Select getSelState() {
        return selState;
    }

    public void setSelState(Select selState) {
        this.selState = selState;
    }

    public WebElement getTxtZipCode() {
        return txtZipCode;
    }

    public void setTxtZipCode(WebElement txtZipCode) {
        this.txtZipCode = txtZipCode;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(WebElement txtEmail) {
        this.txtEmail = txtEmail;
    }

    public WebElement getTxtObs() {
        return txtObs;
    }

    public void setTxtObs(WebElement txtObs) {
        this.txtObs = txtObs;
    }

    public WebElement getSuccess() {
        return success;
    }

    public void setSuccess(WebElement success) {
        this.success = success;
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

    public WebElement getBtnMostrarLista() {
        return btnMostrarLista;
    }

    public void setBtnMostrarLista(WebElement btnMostrarLista) {
        this.btnMostrarLista = btnMostrarLista;
    }
    
}
