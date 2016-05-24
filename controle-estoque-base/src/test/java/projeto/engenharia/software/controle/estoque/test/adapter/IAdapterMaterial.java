package projeto.engenharia.software.controle.estoque.test.adapter;

public interface IAdapterMaterial {

	void closeSession();
        
        Boolean appSaveData(Integer sku, Integer unit);

}
