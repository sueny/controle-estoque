package testing.adapter;

public interface ConsigAdapter {

	/**
	 * This method will allow the user to hit the Consignacao bt in the menu
	 */
	public void openConsigScreen();

	/**
	 * This method will allow the user to choose the client in the list of clients 
	 */
	public void chooseClient();

	/**
	 * This method will allow the user to choose the product in the list
	 */
	public void chooseProduct();

	/**
	 * This method will allow the user to hit "Nova Consignacao" bt 
	 */
	public void cancelConsig();
	
	/**
	 * This method will allow the user to fill the date and then will validate the date the user has chosen
	 * Return true if the date is valid and false otherwise
	 * Date is valid if it is >= the current date (I think we shouldn't allow the return of the products on 
	 * the same day but the interface is currently allowing this)
	 * @return
	 */
	public boolean fillAndValidateDate();


	/**
	 * This method allows the user to say the price of the product and then will validate this price.
	 * We haven't decided what a valid price of the product is. I'd say >= R$ 0.00
	 * if priceValid == true: generate valid test
	 * if priceValid == false: generate invalid test
	 * @param priceValid 
	 * @return true if the price is valid, false otherwise
	 */
	public boolean fillAndValidadePrice(boolean priceValid);
	
	/**
	 * This method allows the user to fill the observation and then will validate it. 
	 * An observation is valid if it has < then X characters. 
	 * @return
	 */
	public boolean fillAndValidadeObs();

	/**
	 * This method allows the user to hit "Fechar Kit" bt. Return true if the fields are validated, false otherwise.
	 * @return 
	 */
	public boolean clickCloseKit();

	/**
	 * This method will close the session
	 */
	public void closeSession();

	/**
	 * This method allow the user to fill the qnt of products then it will validate it.
	 * if qntValid  == true: generate valid test
	 * if qntValid  == false: generate invalid test
	 * @param qntValid 
	 * @return true if the qnt is valid, false otherwise
	 */
	public boolean fillAndValidateQnt(boolean qntValid);

	/**
	 * This method allow the user to click on "Adicionar" bt
	 * @return
	 */
	public boolean addProduct();
	
	/**
	 * Method to allow user to click on "Fechar Consignaçao" bt
	 */
	public void saveConsigAdjustment();

	/**
	 * Method to allow user to click on "Acerto de Consignaçao" on menu
	 */
	public void openConsigAdjustmentScreen();

	/**
	 * Show error when user tries to hit "Fechar Acerto" bt without choosing a consig on the list
	 */
	public void showErrorMessage();

	/**
	 * This method allows the user to choose a consig on the list related to the client
	 */
	public void chooseConsig();

	/**
	 * Allows user to inform the number of sold and returned products (campo "Vendido" e "Devolvido")
	 * soldStatus informs if valid or invalid tests should be generated
	 * Valid tests: "Vendido" is not null, , >= 0, < #"Kit", ("Vendido" + "Devolvido" < #"Kit") 
	 * @param soldStatus
	 * @return
	 */
	public boolean fillSoldProductAmounts(boolean soldStatus);

	/**
	 * Method to allow user to hit "Cancelar" bt
	 */
	public void cancelConsigAdjustment();
	
}
