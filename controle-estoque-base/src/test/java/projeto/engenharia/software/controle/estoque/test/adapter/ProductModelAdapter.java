package projeto.engenharia.software.controle.estoque.test.adapter;

public interface ProductModelAdapter {

	/**
	 * This method will close the section
	 */
	void appCloseSection();

	/**
	 * This method will save the product model
	 */
	void appSaveProductModel();

	/**
	 * This method will check if the product model is valid.
	 * A product model is valid if the attributes informed by the user are not null
	 * eg: name, subcategory (check more on the interface or ask Jesus)
	 * @return 
	 */
	Boolean appValidadeProductModel();

}
