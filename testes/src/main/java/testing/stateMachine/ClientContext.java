package testing.stateMachine;

import testing.adapter.ClientAdapter;

public class ClientContext extends java.lang.Object implements java.lang.Cloneable {

	public ClientState state;
	public boolean valid;
	public Integer qtddRegistro = 0;
	private ClientAdapter adapter;

	public ClientContext() {
		super();
		this.state = ClientState.idle;
		this.adapter = new ClientWebAdapter();
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

				boolean success = adapter.submitRegisterAndUpdate();

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

				boolean success = adapter.submitRegisterAndUpdate();

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


}
