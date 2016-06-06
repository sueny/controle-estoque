package testing.adapter;

public interface ProductAdapter {
	/**
	 * This method will close the section
	 */
	void closeSession(); 

	/** When the user hits "compor" button, this method tries to save the product but it will only
	 * save the prod if it is a valid product. 
	 * If the product cab be saved: return true, otherwise, false.
	 * A product is valid if:
	 * Product's sku is valid
	 * Component is not null and valid
	 * quantity of Component (Material) > 0 
	 */
	boolean trySaveProduct();
	
	void clickDelete(); 
	
	void cancelDeletion();
	
	/** This method will delete the product and must return a message for the user */
	boolean deleteProduct();
	
}
