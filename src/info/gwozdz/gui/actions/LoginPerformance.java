package info.gwozdz.gui.actions;

import javax.persistence.TypedQuery;

import info.gwozdz.jpa.Main;
import info.gwozdz.jpa.domain.Client;
import info.gwozdz.jpa.domain.ClientLoginData;

public class LoginPerformance {

	private Main main;
	private ClientLoginData clientLoginData;

	private String login;
	private long id;
	private double accountBalance;

	public boolean login(String login, String password) {
		init();
		String localPassword = null;
		main.startConnection();

		TypedQuery<ClientLoginData> query = main.entityManager.createQuery(
				"select e from ClientLoginData e where e.login = '" + login
						+ "'", ClientLoginData.class);

		for (ClientLoginData clientLoginData : query.getResultList()) {
			localPassword = clientLoginData.getPassword();
			setLogin(clientLoginData.getLogin());
			setId(clientLoginData.getId());
			setAccountBalance(clientLoginData.getAccountBalance());
		}

		main.closeConnection();
		if (password.equals(localPassword)) {
			return true;
		} else {
			return false;
		}
	}

	public String getLogin() {
		return login;
	}

	private void setLogin(String login) {
		this.login = login;
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	private void setAccountBalance(double d) {
		this.accountBalance = d;
	}

	private void init() {
		main = new Main();
		clientLoginData = new ClientLoginData();
	}
}
