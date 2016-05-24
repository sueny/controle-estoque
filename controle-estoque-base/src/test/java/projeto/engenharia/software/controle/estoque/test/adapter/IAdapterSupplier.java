package projeto.engenharia.software.controle.estoque.test.adapter;

import projeto.engenharia.software.controle.estoque.base.entity.Supplier;

public interface IAdapterSupplier {

	boolean startRegister();
	
	boolean startUpdate();
	
	boolean startDelete();
	
	boolean submitRegisterAndUpdate(Supplier supplier);
	
	boolean submitDelete(boolean delete);
        
        void closeSession();
	
}
