package projeto.engenharia.software.controle.estoque.testing.adapter;

public interface ICadastroMaterial {

	void closeSession();
        
        Boolean appSaveData(Integer sku, Integer unit);

}
