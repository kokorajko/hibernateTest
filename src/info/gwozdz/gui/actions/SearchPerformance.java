package info.gwozdz.gui.actions;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import info.gwozdz.jpa.Main;
import info.gwozdz.jpa.domain.Client;
import info.gwozdz.jpa.domain.ClientLoginData;

public class SearchPerformance {

	private Main main;
	private Client client;
	private ClientLoginData clientLoginData;
	private ArrayList<String> firstNameList = new ArrayList<String>();
	private ArrayList<String> lastNameList = new ArrayList<String>();
	private ArrayList<String> accountNumberList = new ArrayList<String>();

	public void searchByFirstName(String firstName) {
		search("firstName", firstName);
	}

	public void searchByLastName(String lastName) {
		search("lastName", lastName);
	}

	private void search(String type, String data) {
		init();
		main.startConnection();

		TypedQuery<Client> query = main.entityManager.createQuery(
				"select e from Client e where e." + type
						+ " = '" + data + "'", Client.class);
		for (Client client : query.getResultList()) {
			clientLoginData = main.entityManager.find(ClientLoginData.class, client.getId());
			String accountNumber = clientLoginData.getAccountNumber() + "";
			firstNameList.add(client.getFirstName());
			lastNameList.add(client.getLastName());
			accountNumberList.add(accountNumber);
		}
		
		setFirstNameList(firstNameList);
		setLastNameList(lastNameList);
		setAccountNumberList(accountNumberList);
		
		main.closeConnection();
	}

	public ArrayList<String> getFirstNameList() {
		return firstNameList;
	}

	private void setFirstNameList(ArrayList<String> firstNameList) {
		this.firstNameList = firstNameList;
	}

	public ArrayList<String> getLastNameList() {
		return lastNameList;
	}

	private void setLastNameList(ArrayList<String> lastNameList) {
		this.lastNameList = lastNameList;
	}

	public ArrayList<String> getAccountNumberList() {
		return accountNumberList;
	}

	private void setAccountNumberList(ArrayList<String> accountNumberNameList) {
		this.accountNumberList = accountNumberNameList;
	}

	private void init() {
		main = new Main();
		client = new Client();
		clientLoginData = new ClientLoginData();
	}
}
