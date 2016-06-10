package modelo;

public interface ProductModelAdapter {

	/**
	 * This method will close the section
	 */
	void appCloseSection();

	/** This method will try to save the product model and return success or failure.
	 * The product model can be saved if it is a valid product model. 
	 * A product model is valid if the attributes informed by the user are not null
	 * eg: name, subcategory,... .
	 * 
	 * if valid == true: generate valid data
	 * if valid == false: generate invalid data (ex: name = null)
	 * @param 
	 */
	Boolean appSaveProductModel(boolean valid);

	/**
	 * This method will check if the product model is valid.
	 *  (check more on the interface or ask Jesus)
	 * @return 
	 */
	//Boolean appValidadeProductModel();

}
