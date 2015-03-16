package info.gwozdz.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "Imie", nullable = false)
	private String firstName;
	@Column(name = "Nazwisko", nullable = false)
	private String lastName;
	@Column(name = "Adres", nullable = false)
	private String address;
	@Column(name = "kod_pocztowy", nullable = false)
	private String zipCodeAddress;
	@Column(name = "Pesel", nullable = false, precision = 5)
	private long personalNumber;
	
	@OneToOne
	@JoinColumn(name = "DaneLogowaniaId")
	private ClientLoginData ClientLoginData;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCodeAddress() {
		return zipCodeAddress;
	}

	public void setZipCodeAddress(String zipCodeAddress) {
		this.zipCodeAddress = zipCodeAddress;
	}

	public long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(long i) {
		this.personalNumber = i;
	}

	public void setClientLoginData(ClientLoginData clientLoginData) {
		ClientLoginData = clientLoginData;
	}

}
