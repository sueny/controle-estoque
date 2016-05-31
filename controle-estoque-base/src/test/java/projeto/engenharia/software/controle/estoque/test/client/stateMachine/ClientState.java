package projeto.engenharia.software.controle.estoque.test.client.stateMachine;

public enum ClientState {
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
	doDelete;
}