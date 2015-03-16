package info.gwozdz.gui.actions;

import javax.persistence.TypedQuery;

import info.gwozdz.gui.Component;
import info.gwozdz.jpa.Main;
import info.gwozdz.jpa.domain.Client;
import info.gwozdz.jpa.domain.ClientLoginData;

public class RemoveAccountPerformance {

	private Main main;
	private Client client;
	private ClientLoginData clientLoginData;

	public void removeAccount(long id) {
		init();
		main.startConnection();
		
		main.entityManager.getTransaction().begin();
		client = main.entityManager.find(Client.class, id);
		clientLoginData = main.entityManager.find(ClientLoginData.class, id);
		main.entityManager.remove(client);
		main.entityManager.remove(clientLoginData);
		main.entityManager.getTransaction().commit();
		
		main.closeConnection();

	}

	private void init() {
		main = new Main();
		client = new Client();
		clientLoginData = new ClientLoginData();
	}
}
