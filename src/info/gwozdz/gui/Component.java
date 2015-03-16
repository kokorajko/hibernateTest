package info.gwozdz.gui;

import info.gwozdz.gui.actions.CreateAccountPerformance;
import info.gwozdz.gui.actions.LoginPerformance;
import info.gwozdz.gui.actions.RemoveAccountPerformance;
import info.gwozdz.gui.actions.SearchPerformance;
import info.gwozdz.gui.actions.SendCashPerformance;
import info.gwozdz.jpa.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;

import java.awt.CardLayout;

import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Component extends JFrame {

	private JPanel cardLayoutPanel;

	private Main main;
	private CreateAccountPerformance createAccountPerformance;
	private LoginPerformance loginPerformance;
	private RemoveAccountPerformance removeAccountPerformance;
	private SendCashPerformance sendCashPerformance;
	private SearchPerformance searchPerformance;

	private CardLayout cardLayout;

	public JTextField firstNameTextField;
	public JTextField lastNameTextField;
	public JTextField addressTextField;
	public JTextField zipCodeTextField;
	public JTextField personalNumberTextField;
	private JTextField loginTextField;
	private JPasswordField passwordTextField;
	private JTextField numberAccountToTextField;
	private JTextField amountTextField;
	private JTextField firstNameSearchTextField;
	private JTextField lastNameSearchTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Component frame = new Component();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Component() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		cardLayoutPanel = new JPanel();
		cardLayoutPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cardLayoutPanel);
		cardLayoutPanel.setLayout(new CardLayout(0, 0));
		cardLayout = (CardLayout) cardLayoutPanel.getLayout();

		JPanel mainMenuPanel = new JPanel();
		cardLayoutPanel.add(mainMenuPanel, "mainMenuCard");
		mainMenuPanel.setLayout(null);

		JPanel informationPanel = new JPanel();
		informationPanel.setBounds(10, 217, 414, 94);
		mainMenuPanel.add(informationPanel);
		informationPanel.setBorder(new TitledBorder(null, "Informacja",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		informationPanel.setLayout(null);

		JLabel informationLabel = new JLabel("<html>" + "Witaj w naszym banku!"
				+ "<br>" + "Je¿eli jesteœ nowym klientem - zarejestruj siê!"
				+ "<br>" + "Chcesz dostaæ siê do swojego konta? Zaloguj siê."
				+ "</html>");
		informationLabel.setBounds(10, 11, 394, 72);
		informationPanel.add(informationLabel);

		JPanel registrationPanel = new JPanel();
		registrationPanel.setBounds(10, 11, 239, 185);
		mainMenuPanel.add(registrationPanel);
		registrationPanel.setBorder(new TitledBorder(null, "Rejestracja",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		registrationPanel.setLayout(null);

		JLabel firstNameLabel = new JLabel("Imiê: ");
		firstNameLabel.setBounds(10, 23, 74, 14);
		registrationPanel.add(firstNameLabel);

		JLabel lastNameLabel = new JLabel("Nazwisko: ");
		lastNameLabel.setBounds(10, 48, 74, 14);
		registrationPanel.add(lastNameLabel);

		JLabel addressLabel = new JLabel("Adres: ");
		addressLabel.setBounds(10, 73, 74, 14);
		registrationPanel.add(addressLabel);

		JLabel zipCodeLabel = new JLabel("Kod pocztowy: ");
		zipCodeLabel.setBounds(10, 98, 74, 14);
		registrationPanel.add(zipCodeLabel);

		JLabel personalNumberLabel = new JLabel("Pesel: ");
		personalNumberLabel.setBounds(10, 123, 74, 14);
		registrationPanel.add(personalNumberLabel);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(94, 20, 135, 20);
		registrationPanel.add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(94, 45, 135, 20);
		registrationPanel.add(lastNameTextField);
		lastNameTextField.setColumns(10);

		addressTextField = new JTextField();
		addressTextField.setBounds(94, 70, 135, 20);
		registrationPanel.add(addressTextField);
		addressTextField.setColumns(10);

		zipCodeTextField = new JTextField();
		zipCodeTextField.setBounds(94, 95, 135, 20);
		registrationPanel.add(zipCodeTextField);
		zipCodeTextField.setColumns(10);

		personalNumberTextField = new JTextField();
		personalNumberTextField.setBounds(94, 120, 135, 20);
		registrationPanel.add(personalNumberTextField);
		personalNumberTextField.setColumns(10);

		JButton createAccountButton = new JButton("Utw\u00F3rz");
		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// try{
				createAccountPerformance.createAccount(
						firstNameTextField.getText(),
						lastNameTextField.getText(),
						addressTextField.getText(), zipCodeTextField.getText(),
						personalNumberTextField.getText());
				informationLabel.setText("<html>" + "Login: "
						+ createAccountPerformance.getLoginString() + "<br>"
						+ "Has³o: "
						+ createAccountPerformance.getPasswordString() + "<br>"
						+ "Numer konta: "
						+ createAccountPerformance.getAccountNumberLong()
						+ "</html>");
				// }catch(Exception ex){
				// informationLabel.setText("xzczxc");
				// }
			}
		});
		createAccountButton.setBounds(140, 151, 89, 23);
		registrationPanel.add(createAccountButton);

		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(269, 11, 165, 112);
		mainMenuPanel.add(loginPanel);
		loginPanel.setBorder(new TitledBorder(null, "Logowanie",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		loginPanel.setLayout(null);

		JLabel loginLabel = new JLabel("Login:");
		loginLabel.setBounds(10, 29, 46, 14);
		loginPanel.add(loginLabel);

		JLabel passwordLabel = new JLabel("Has³o:");
		passwordLabel.setBounds(10, 54, 46, 14);
		loginPanel.add(passwordLabel);

		loginTextField = new JTextField();
		loginTextField.setBounds(66, 26, 86, 20);
		loginPanel.add(loginTextField);
		loginTextField.setColumns(10);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(66, 51, 86, 20);
		loginPanel.add(passwordTextField);
		passwordTextField.setColumns(10);

		JPanel customerPanel = new JPanel();
		cardLayoutPanel.add(customerPanel, "customerCard");
		customerPanel.setLayout(null);

		JPanel welcomePanel = new JPanel();
		welcomePanel.setBorder(new TitledBorder(null, null,
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		welcomePanel.setBounds(10, 11, 178, 38);
		customerPanel.add(welcomePanel);
		welcomePanel.setLayout(null);

		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setBounds(10, 11, 158, 14);
		welcomePanel.add(welcomeLabel);

		JPanel balancePanel = new JPanel();
		balancePanel.setBorder(new TitledBorder(null, "Stan konta:",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		balancePanel.setBounds(220, 11, 204, 38);
		customerPanel.add(balancePanel);
		balancePanel.setLayout(null);

		JLabel balanceLabel = new JLabel();
		balanceLabel.setBounds(10, 11, 189, 14);
		balancePanel.add(balanceLabel);

		JButton loginButton = new JButton("Zaloguj");
		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (loginPerformance.login(loginTextField.getText(),
						passwordTextField.getText())) {
					cardLayout.show(cardLayoutPanel, "customerCard");
					informationLabel.setText("Poprawnie zalogowano!");
					welcomeLabel.setText("Witaj " + loginPerformance.getLogin());
				} else {
					informationLabel.setText("Dane logowania b³êdne!");
				}
				balanceLabel.setText(loginPerformance.getAccountBalance()+"");
			}
		});
		loginButton.setBounds(66, 78, 89, 23);
		loginPanel.add(loginButton);

		JButton mainMenuSearchButton = new JButton("Wyszukiwarka");
		mainMenuSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(cardLayoutPanel, "adminCard");
			}
		});
		mainMenuSearchButton.setBounds(279, 134, 145, 23);
		mainMenuPanel.add(mainMenuSearchButton);

		JPanel removeAccountPanel = new JPanel();
		removeAccountPanel.setBorder(new TitledBorder(null, "Usuñ konto",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		removeAccountPanel.setBounds(220, 245, 204, 56);
		customerPanel.add(removeAccountPanel);
		removeAccountPanel.setLayout(null);

		JButton ramoveAccountButton = new JButton("Usuñ");
		ramoveAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAccountPerformance.removeAccount(loginPerformance.getId());
			}
		});
		ramoveAccountButton.setBounds(10, 22, 89, 23);
		removeAccountPanel.add(ramoveAccountButton);

		JButton logoutButton = new JButton("Wyloguj");
		logoutButton.setBounds(105, 22, 89, 23);
		removeAccountPanel.add(logoutButton);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(cardLayoutPanel, "mainMenuCard");
			}
		});

		JPanel transferPanel = new JPanel();
		transferPanel.setBorder(new TitledBorder(null, "Zrób przelew:",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		transferPanel.setBounds(10, 60, 414, 108);
		customerPanel.add(transferPanel);
		transferPanel.setLayout(null);

		JLabel numberAccountToLabel = new JLabel("Nr. konta (adresat)");
		numberAccountToLabel.setBounds(10, 23, 93, 14);
		transferPanel.add(numberAccountToLabel);

		numberAccountToTextField = new JTextField();
		numberAccountToTextField.setBounds(123, 20, 281, 20);
		transferPanel.add(numberAccountToTextField);
		numberAccountToTextField.setColumns(10);

		JLabel amountLabel = new JLabel("Kwota");
		amountLabel.setBounds(10, 48, 46, 14);
		transferPanel.add(amountLabel);

		amountTextField = new JTextField();
		amountTextField.setBounds(123, 45, 140, 20);
		transferPanel.add(amountTextField);
		amountTextField.setColumns(10);

		JButton sendButton = new JButton("Wy\u015Blij");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sendCashPerformance.sendCash(
						Long.parseLong(numberAccountToTextField.getText()),
						Double.parseDouble(amountTextField.getText()),
						loginPerformance.getId());
				balanceLabel.setText(sendCashPerformance.getAccountBalance()+"");
			}			
		});
		sendButton.setBounds(315, 74, 89, 23);
		transferPanel.add(sendButton);

		JPanel adminPanel = new JPanel();
		cardLayoutPanel.add(adminPanel, "adminCard");
		adminPanel.setLayout(null);

		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new TitledBorder(null, "Szukaj:",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPanel.setBounds(10, 11, 226, 126);
		adminPanel.add(searchPanel);
		searchPanel.setLayout(null);

		JLabel firstNameSearchLabel = new JLabel("Imiê");
		firstNameSearchLabel.setBounds(10, 21, 46, 14);
		searchPanel.add(firstNameSearchLabel);

		JLabel lastNameSearchLabel = new JLabel("Nazwisko");
		lastNameSearchLabel.setBounds(10, 46, 46, 14);
		searchPanel.add(lastNameSearchLabel);

		JLabel lblwypenijMaksymalnie = new JLabel(
				"*Wype\u0142nij maksymalnie 1 pole");
		lblwypenijMaksymalnie.setBounds(10, 108, 206, 14);
		searchPanel.add(lblwypenijMaksymalnie);

		firstNameSearchTextField = new JTextField();
		firstNameSearchTextField.setBounds(67, 18, 149, 20);
		searchPanel.add(firstNameSearchTextField);
		firstNameSearchTextField.setColumns(10);

		lastNameSearchTextField = new JTextField();
		lastNameSearchTextField.setBounds(68, 43, 148, 20);
		searchPanel.add(lastNameSearchTextField);
		lastNameSearchTextField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 148, 226, 153);
		adminPanel.add(textArea);

		JButton searchButton = new JButton("Szukaj");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!firstNameSearchTextField.getText().equals("")
						&& lastNameSearchTextField.getText().equals("")) {
					searchPerformance
							.searchByFirstName(firstNameSearchTextField
									.getText());
				} else if (firstNameSearchTextField.getText().equals("")
						&& !lastNameSearchTextField.getText().equals("")) {
					searchPerformance.searchByLastName(lastNameSearchTextField
							.getText());
				}
				for (int i = 0; i < searchPerformance.getFirstNameList().size(); i++) {
					textArea.append(searchPerformance.getFirstNameList().get(i)
							+ " " + searchPerformance.getLastNameList().get(i)
							+ " "
							+ searchPerformance.getAccountNumberList().get(i)
							+ "\n");
				}
			}
		});
		searchButton.setBounds(127, 74, 89, 23);
		searchPanel.add(searchButton);

		init();
	}

	private void init() {
		main = new Main();
		createAccountPerformance = new CreateAccountPerformance();
		loginPerformance = new LoginPerformance();
		removeAccountPerformance = new RemoveAccountPerformance();
		sendCashPerformance = new SendCashPerformance();
		searchPerformance = new SearchPerformance();
	}
}
