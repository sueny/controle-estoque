package projeto.engenharia.software.controle.estoque.test.client.stateMachine;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import projeto.engenharia.software.controle.estoque.base.entity.Client;
import projeto.engenharia.software.controle.estoque.test.adapter.IAdapterClient;

public class ClientContext extends java.lang.Object implements java.lang.Cloneable {

	public ClientState state;
	public boolean valid;
	public Integer qtddRegistro = 0;
	public Client client;
	private IAdapterClient adapter;

	public ClientContext() {
		super();
		this.state = ClientState.idle;
		this.client = new Client();
	}

	public ClientContext clone() {
		try {
			return (ClientContext)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block//
			e.printStackTrace();
		}
		return null;
	}

	public void handleEvent(Object... objects) {

		if (objects.length <= 0) {
			return;
		}
		
		String eventName = (String) objects[0];

		switch (state) {

		case idle:
			if (eventName.compareTo("startRegisterEv") == 0) {
				boolean success = adapter.startRegister();
				if(success) {
					state = ClientState.registered;
				}
			}

			if (eventName.compareTo("startUpdateEv") == 0) {
				boolean success = adapter.startUpdate();
				if(success) {
					state = ClientState.updating;
				}
			}

			if (eventName.compareTo("startDeleteEv") == 0) {
				boolean success = adapter.startDelete();
				if(success) {
					state = ClientState.deleting;
				}
			}

			break;

		case registering:

			if (eventName.compareTo("submitEv") == 0) {
				valid = (Boolean) objects[1];

				/*Gera objeto v�lido*/
				Client client = generateEntity();

				/*Se teste de objeto inv�lido*/
				if(!valid) {
					//campo nome � obrigat�rio, atribuindo vazio dar� erro no registro, objetivo do teste inv�lido
					client.setName("");
				} 

				boolean success = adapter.submitRegisterAndUpdate(client);

				if(success){
					state = ClientState.registered;
				} else {
					state = ClientState.notRegistered;
				}
			}

			break;

		case updating:

			if (eventName.compareTo("submitEv") == 0) {
				valid = (Boolean) objects[1];

				/*Gera objeto v�lido*/
				Client client = generateEntity();

				/*Se teste de objeto inv�lido*/
				if(!valid) {
					//campo nome � obrigat�rio, atribuindo vazio dar� erro no registro, objetivo do teste inv�lido
					client.setName("");
				} 

				boolean success = adapter.submitRegisterAndUpdate(client);

				if(success){
					state = ClientState.updated;
				} else {
					state = ClientState.notUpdated;
				}
			}

			break;

		case deleting:
			
			if (eventName.compareTo("submitEv") == 0) {
				valid = (Boolean) objects[1];
				
				boolean success = adapter.submitDelete(valid);
				
				if(success){
					state = ClientState.deleted;
				} else {
					state = ClientState.notDeleted;
				}
				
			}

			break;

		default:
			break;
		}

	}
        
        public void close() {
            adapter.closeSession();
        }

	private Client generateEntity() {
		EnhancedRandom enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build();
		Client client = enhancedRandom.nextObject(Client.class);
		return client;

	}


}
