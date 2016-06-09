package consignment;

public interface ConsigAdapter {

	/**
	 * This method will allow the user to hit the Consignacao bt in the menu
	 */
	public void clickConsig();

	/**
	 * This method will allow the user to choose the client in the list of clients 
	 */
	public void clickClient();

	/**
	 * This method will allow the user to choose the product in the list
	 */
	public void clickProduct();

	/**
	 * This method will allow the user to hit "Nova Consignacao" bt 
	 */
	public void clickNewConsig();
	
	/**
	 * This method will allow the user to fill the date and then will validate the date the user has chosen
	 * @return true if the date is valid and false otherwise
	 * Date is valid if it is >= the current date (I think we shouldn't allow the return of the products on 
	 * the same day but the interface is currently allowing this)
	 */
	public boolean fillAndValidateDate();

	/**
	 * This method allows the user to say the price of the product and then will validate this price.
	 * We haven't decided what a valid price of the product is. I'd say >= R$ 0.00
	 * @return true if the price is valid, false otherwise
	 */
	public boolean fillAndValidadePrice();
	
	/**
	 * This method allows the user to fill the observation and then will validate it. 
	 * An observation is valid if it has < then X characters. 
	 * @return
	 */
	public boolean fillAndValidadeObs();

	/**
	 * This method allows the user to hit "Fechar Kit" bt. 
	 * @return true if the fields are validated, false otherwise.
	 */
	public boolean clickCloseKit();

	/**
	 * This method will close the section
	 */
	public void closeSection();

	/**
	 * This method allow the user to fill the qnt of products then it will validate it.
	 * @return true if the qnt is valid, false otherwise
	 */
	public boolean fillAndValidateQnt();

	public boolean clickAddBt();
	
}
