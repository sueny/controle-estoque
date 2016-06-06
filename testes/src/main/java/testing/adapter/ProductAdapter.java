package product;

public interface ProductAdapter {
	/**
	 * This method will close the section
	 */
	void closeSection(); 

	/** When the user hits "compor" button, this method tries to save the product but it will only
	 * save the prod if it is a valid product. 
	 * If the product cab be saved: return true, otherwise, false.
	 * A product is valid if:
	 * Product's sku is valid
	 * Component is not null and valid
	 * quantity of Component (Material) > 0 
	 */
	boolean trySaveProduct();
	
	
	/** This method will try to delete the product and must return a message of success or failure */
	boolean tryDeleteProduct();
	
	/**
	 * The product can be deleted if it is a registered product
	 * @return
	 */
	void clickDelete(); 
	
	
	
	/** This method will cancel the event that will try to delete the Product*/
	void cancelDeletion();

	/**
	 * This method is used to choose the product in the list of registered products
	 */
	void clickToChooseProduct();

	/**
	 * When you finish to inform whatever you want to update you press "Alterar". Here is the method to do it
	 */
	void clickUpdate();
	
}
