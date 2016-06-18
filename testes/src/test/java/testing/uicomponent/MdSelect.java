package testing.uicomponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MdSelect {

	private WebElement element;
	private WebDriver driver;
	
	public MdSelect(WebElement element, WebDriver driver){
		this.element = element;
		this.driver = driver;
	}
	
	private List<WebElement> getOptions(){
		return driver.findElement(By.cssSelector("[class~=\"md-select-menu-container\"][aria-hidden=\"false\"]")).findElements(By.tagName("md-option"));
	}
	
	public void selectItem(final int i){
		this.element.click();
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return getOptions().size() > i;
            }
        });
		getOptions().get(i).click();
	}
	
}
