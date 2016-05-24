package projeto.engenharia.software.controle.estoque.test.supplier.stateMachine;

public enum SupplierState {

	idle,
	
	registering,
	registered,
	notRegistered,
	
	updating,
	updated,
	notUpdated,
	
	deleting,
	deleted,
	notDeleted,
	
	savingRegister,
	savingUpdate,
	doDelete,
	
	finalize;
	
}
