package testing.pageobject;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import testing.uicomponent.MdSelect;
import testing.util.DriverProvider;
import testing.util.Routes;

public class TelaModeloProduto extends TelaSistema{
	
	//private WebDriver driver;
	
	public TelaModeloProduto(){
		this.driver = DriverProvider.getInstance();
		driver.get(Routes.TELA_MODELO);
		sleep(3000);
	}
	
	private void sleep(long s){
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void finaliza(){
		this.driver.close();
	}
	
	public boolean formValido(){
		return !driver.findElement(By.name("formModel")).getAttribute("class").contains("ng-invalid");
	}
	
	public void limpaNome(){
		driver.findElement(By.name("txtNome")).clear();
	}
	
	public void setNome(String nome){
		driver.findElement(By.name("txtNome")).sendKeys(nome);
	}
	
	public void setEstacao(int estacao){
		new Select(driver.findElement(By.name(".selEstacao"))).getOptions().get(estacao).click();
		//new MdSelect(driver.findElement(By.name("selEstacao")), driver).selectItem(estacao);
	}
	
	public void setCategoria(int categoria){
		new MdSelect(driver.findElement(By.name("selCategoria")), driver).selectItem(categoria);
	}
	
	public void setSubCategoria(int sub){
		new MdSelect(driver.findElement(By.name("selSubcategoria")), driver).selectItem(sub);
	}
	
	public void setDescricao(String descr){
		driver.findElement(By.name("txtDescricao")).sendKeys(descr);
	}
	
	public void envia(){
		try{
			driver.findElement(By.name("btnCadastrarModelo")).click();
		}catch(Exception e){
			System.out.println("falha ao clicar em cadastrar");
		}
	}
	
	public void limpa(){
		driver.findElement(By.name("btnLimparForm")).click();
	}
	
	public void clicaExcluir(){
		driver.findElement(By.name("btnExcluirModelo")).click();
	}

	public void confirma() {
		super.confirma();
	}

	public void cancela() {
		super.cancela();
	}

	public void clicaAlterar() {
		driver.findElement(By.name("btnAlterarModelo")).click();
	}
	
	public boolean isSaveSuccessMessageDisplayed(){
		String text = "Cadastro realizado com sucesso";
		return super.checaEFechaMensage(text);
	}

	public boolean isDeleteSuccessMessageDisplayed() {
		return super.checaEFechaMensage("Excluído com sucesso");
	}

	public boolean isUpdateSuccessMessageDisplayed() {
		return super.checaEFechaMensage("Cadastro realizado com sucesso");
	}

	public void selecionaModelo(int i) {
		super.mostraListagem();
		try {
			driver.findElements(By.className("item-model"))
			.stream()
			.filter(x -> x.getText().contains("teste"))
			.collect(Collectors.toList())
			.get(i).click();
		} catch (IndexOutOfBoundsException e) {
			throw new RuntimeException("Não foram encontrados na listagem Modelos contendo 'teste' no nome");
		}
	}

}
