package testing.adapter;

public interface CadastroMaterialAdapter {

	/**
	 * This method will close the session
	 */
	void closeSession();

	/**
	 * This method will allow the user to hit "cadastrar" bt and will try to save the Material.
	 * If it is a valid material, it will be saved and a success message will be shown.
	 * If it is an invalid material, it wont be saved and an error message will be shown.
	 * The parameter status will say whether you have to generate valid or invalid tests.
	 * A material is valid when: 
	 * - name is not null
	 * - sku is valid
	 * - 
	 * @param status
	 * @return
	 */
	boolean register(boolean status);

	/**
	 * This method will try to delete the material if the user confirm he is sure he wants to delete it(hit "yes" bt). 
	 * And will return a success of failure message.
	 * The Material can be deleted if:
	 * - its qnt > 0
	 * - sku is valid 
	 * The parameter will say when to generate valid or invalid tests
	 * @param registerStatus
	 * @return
	 */
	boolean confirmDeletion(boolean registerStatus);

	/**
	 * This method allows the user to choose a material and click the delete bt to delete it
	 */
	void clickToDeleteMaterial();

	/**
	 * If the user cancel the deletion of the material he will hit "nao" bt
	 */
	void cancelDeletion();


}
