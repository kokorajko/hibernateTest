package info.gwozdz.gui.actions;

import java.util.Random;

import info.gwozdz.gui.Component;
import info.gwozdz.jpa.Main;
import info.gwozdz.jpa.domain.Client;
import info.gwozdz.jpa.domain.ClientLoginData;

public class CreateAccountPerformance {

	private Main main;
	private Component component;
	private Client client;
	private ClientLoginData clientLoginData;

	private String loginString;
	private String passwordString;
	private long accountNumberLong;

	public void createAccount(String firstNameText, String lastNameText,
			String addressText, String zipCodeText, String personalNumberString) {
		init();
		Random r = new Random();
		int accountNumber = r.nextInt(999999 - 100000 + 1) + 100000;
		main.startConnection();

		client.setFirstName(firstNameText);
		client.setLastName(lastNameText);
		client.setAddress(addressText);
		client.setZipCodeAddress(zipCodeText);
		long pN = Long.parseLong(personalNumberString);
		client.setPersonalNumber(pN);
		
		client.setClientLoginData(clientLoginData);

		String lString = firstNameText.substring(0, 1)
				+ lastNameText.substring(0, 1)
				+ personalNumberString.substring(0, 2)
				+ personalNumberString.substring(
						personalNumberString.length() - 3,
						personalNumberString.length());
		clientLoginData.setLogin(lString);
		setLoginString(lString);

		clientLoginData.setPassword("123");
		setPasswordString("123");

		clientLoginData.setAccountNumber(accountNumber);
		setAccountNumberLong(accountNumber);
		
		clientLoginData.setAccountBalance(1000.0);

		main.entityManager.getTransaction().begin();
		main.entityManager.persist(client);
		main.entityManager.persist(clientLoginData);
		main.entityManager.getTransaction().commit();

		main.closeConnection();
	}

	public String getLoginString() {
		return loginString;
	}

	private void setLoginString(String loginString) {
		this.loginString = loginString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	private void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	public long getAccountNumberLong() {
		return accountNumberLong;
	}

	private void setAccountNumberLong(long accountNumberLong) {
		this.accountNumberLong = accountNumberLong;
	}

	private void init() {
		main = new Main();
		component = new Component();
		client = new Client();
		clientLoginData = new ClientLoginData();
	}
}
