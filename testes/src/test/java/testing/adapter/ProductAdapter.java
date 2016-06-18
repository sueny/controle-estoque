package testing.adapter;

public interface ProductAdapter {
	/**
	 * This method will close the section
	 */
	void closeSession(); 

	/** When the user hits "compor" button, this method tries to save the product but it will only
	 * save the product if it is a valid product. 
	 * If the product cab be saved: return true, otherwise, false.
	 * A product is valid if:
	 * -Product's sku is valid
	 * -Component is not null and valid
	 * -quantity of Component (Material) > 0 
	 * -Name of product is not null
	 * -Product Model is not null
	 * -Size is defined
	 * 
	 * The parameter statusProduct will say if valid or invalid tests should be generated
	 * @param statusProduct 
     * @return  
	 */
	boolean trySaveProduct(boolean statusProduct);
	
	/**
	 * This method will try to delete the product and must return a message of success or failure.
	 * The parameter will say if valid or invalid tests should be generated.
	 * 
	 * @param successStatus 
	 * @return
	 */
	boolean tryDeleteProduct(boolean successStatus);
	
	/**
	 * The product can be deleted if it is a registered product
	 * @return
	 */
	void clickDelete(); 

	/**
	 * This method is used to choose the product in the list of registered products
	 */
	void clickToChooseProduct();
	
	/**
	 * To hit "Limpar" bt while updating or deleting a product
	 */
	void clickCleanBt();
}
