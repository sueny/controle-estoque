package testing.adapter;

public interface ProductModelAdapter {

    /**
     * This method will close the section
     */
    void appCloseSession();

    /**
     * This method will try to save the product model and return success or
     * failure. The product model can be saved if it is a valid product model. A
     * product model is valid if the attributes informed by the user are not
     * null eg: name, subcategory,... .
     *
     * if valid == true: generate valid data if valid == false: generate invalid
     * data (ex: name = null)
     *
     * @param
     */
    boolean appSaveProductModel(boolean valid);

    /**
     * This method will check if the product model is valid. (check more on the
     * interface or ask Jesus)
     *
     * @return
     */
    //Boolean appValidadeProductModel();
    /**
     * click the Delete bt to delete a product model
     */
    void clickDelete();

    /**
     * This method allows the user to hit "nao" bt on the confirmation screen
     */
    void cancelDeletion();

    /**
     * When user wants to confirm the deletion, he will hit "sim" bt on the
     * confirmation screen and this method will allow him to do so. Then it will
     * validate if the product model can be deleted. If it can be deleted, the
     * product model will be deleted and a success message will be displayed. If
     * it cannot be deleted, the product model wont be deleted and a message of
     * error will be displayed. The parameter "status" says whether valid or
     * invalid tests are generated.
     *
     * A product model can be deleted if: It was registered and its qnt > 0 in
     * the db. It is not associated to any product.
     *
     * @param status
     * @return
     */
    boolean confirmDeletion(boolean status);

    /**
     * To hit "Limpar" bt
     */
    void clickClean();

    /**
     * Method used to choose which product model will be deleted or updated.
     */
    void chooseProductModel();


    /**
     * The system will ask the user if he really wants to update that product
     * model. This method allows the user to hit "sim" bt when this question is
     * asked. Then it will try to update the product model. A product model can
     * be updated if there is a category, sub category, name and season =
     * NOTNULL. The parameter will say whether valid or invalid tests should be
     * generated. If the product model was updated: success message If the
     * product wasnt updated: failure message
     *
     * @param valid
     * @param btnClickSimOuNao
     * @param statusUpdate
     * @return
     */

    boolean confirmUpdate(boolean valid, boolean btnClickSimOuNao);

}
