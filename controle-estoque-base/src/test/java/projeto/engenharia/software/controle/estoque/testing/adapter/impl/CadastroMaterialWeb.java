package projeto.engenharia.software.controle.estoque.testing.adapter.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projeto.engenharia.software.controle.estoque.testing.pageobject.TelaCadastro;
import projeto.engenharia.software.controle.estoque.testing.adapter.ICadastroMaterial;

public class CadastroMaterialWeb implements ICadastroMaterial {

    private static final String PAGE_LOCATION = "http://localhost:8080/controle-estoque-web/client/views/index.html";

    public boolean erro;

    private WebDriver driver;

    private TelaCadastro telaCadastro;

    public CadastroMaterialWeb() {
        System.setProperty("webdriver.chrome.driver", "c:\\webdrivers\\chromedriver.exe");

        try {
////            driver = new FirefoxDriver();
            driver = new ChromeDriver();
        } catch (Exception e) {
        }
        System.out.println("driver created");
        driver.get(PAGE_LOCATION);
        this.telaCadastro = new TelaCadastro(driver);
    }


    /*public void envia() {
		System.out.println("commence envoyer");
		
		this.erro = true;
		
		WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        System.out.println("aguardando");
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
		
		this.erro = false;
	}*/
    public void closeSession() {
        driver.quit();
    }

    @Override
    public Boolean appSaveData(Integer sku, Integer unit) {
        telaCadastro.getTxtNome().sendKeys("Materia Prima teste 01");
        telaCadastro.getTxtDescription().sendKeys("This is a description");
        telaCadastro.getTxtSku().sendKeys(sku.toString());
        telaCadastro.getSelUnidade().getOptions().get(1).click();
//		telaCadastro.getSelCategoria().getOptions().get(1).click();

        telaCadastro.getBtnCadastro().click();
//        return telaCadastro.isSuccessMessageDisplayed();
        return Boolean.TRUE;
    }

}
