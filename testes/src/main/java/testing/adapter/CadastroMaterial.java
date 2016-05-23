package testing.adapter;

public interface CadastroMaterial {

	void closeSession();

	Boolean register(Integer sku, Integer unit);
	
	void deleteData(Integer sku);

}
