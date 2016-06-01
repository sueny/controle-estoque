package projeto.engenharia.software.controle.estoque.test.adapter;

public interface ProductAdapter {
	void appCloseSection(); 

	/** This method will save the registered product and its updayes and will return a success message for the user
	 * 
	 * @return
	 */
	boolean appSaveProduct();
	
	
	/** This method must check if:
	 * Product's sku is valid
	 * Component is not null and valid
	 * quantity of Component (Material) > 0
	 * and return is the product is valid or not
	 */
	boolean appValidadeProduct(); 
	
	/** This method checks if product's sku is already registered and
	 * if the quantity of product > 0 so it can be deleted from the system
	 */
	boolean appIsSkuValid();
	
	/** This method will delete the product and must return a message for the user */
	boolean appDeleteData();
	
}
