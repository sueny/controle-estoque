package projeto.engenharia.software.controle.estoque.test.adapter;

import projeto.engenharia.software.controle.estoque.base.entity.Client;

public interface IAdapterClient {

	boolean startRegister();
	
	boolean startUpdate();
	
	boolean startDelete();
	
	boolean submitRegisterAndUpdate(Client client);
	
	boolean submitDelete(boolean delete);
	
}
