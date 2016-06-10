package stock;

public interface StockAdapter {

	/**
	 * This method will click the "Entrada" bt
	 */
	void clickEntryBt();

	/**
	 * This method will choose which product will be used
	 */
	void clickProduct();
	
	/**
	 * Method will fill and validade the observation field
	 * This field is valid when it has less then X characters (ask Jesus to make sure) 
	 * @return
	 */
	boolean fillAndValidadeObs();

	/**
	 * Method to fill and validate price.
	 * Price is valid when it is not negative (I think we allow price = 0)
	 * status will define if you will generate a valid or invalid test
	 * @param status
	 * @return
	 */
	boolean fillAndValidadePrice(boolean status);

	/**
	 * Method to fill and validate quantity.
	 * Qnt is valid when it is not negative (I think we allow qnt = 0)
	 * status will define if you will generate a valid or invalid test
	 * @param status
	 * @return
	 */
	boolean fillAndValidadeQnt(boolean status);

	/**
	 * Method to click on "Nova Busca" bt
	 */
	void clickNewSearchBt();

	/**
	 * Method to click on "Cadastrar" bt. It will return true if not errors were found 
	 * @return
	 */
	boolean clickRegister();

	/**
	 * Method to close the section
	 */
	void closeSection();



}
