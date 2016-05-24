package testing.adapter;

public interface CadastroMaterial {

	void closeSession();

	Boolean register(Integer sku, Integer unit);
	
	Boolean deleteData(Integer sku);
	
	void confirmDeletion(boolean confirm);

}
