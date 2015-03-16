package info.gwozdz.gui.actions;

import javax.persistence.TypedQuery;

import info.gwozdz.jpa.Main;
import info.gwozdz.jpa.domain.ClientLoginData;

public class SendCashPerformance {

	private Main main;
	private ClientLoginData clientLoginDataSender;
	private double accountBalance;

	public void sendCash(long accountNumber, double amount, long senderId) {
		init();

		main.startConnection();

		main.entityManager.getTransaction().begin();
		clientLoginDataSender = main.entityManager.find(ClientLoginData.class,
				senderId);
		clientLoginDataSender.setAccountBalance(clientLoginDataSender
				.getAccountBalance() - amount);
		setAccountBalance(clientLoginDataSender.getAccountBalance());

		TypedQuery<ClientLoginData> query = main.entityManager.createQuery(
				"select e from ClientLoginData e where e.accountNumber = '"
						+ accountNumber + "'", ClientLoginData.class);

		for (ClientLoginData clientLoginData : query.getResultList()) {
			clientLoginData.setAccountBalance(clientLoginData
					.getAccountBalance() + amount);
		}

		main.entityManager.getTransaction().commit();

		main.closeConnection();
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	private void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	private void init() {
		main = new Main();
		clientLoginDataSender = new ClientLoginData();
	}
}
