package org.ssu.mm.hotelapp.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
public class Client implements Serializable {
	private String id;
	private String middleName;
	private String firstName;
	private String lastName;
	private Passport passport;
	private String comment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Client client = (Client) o;

		if (!id.equals(client.id)) return false;
		if (!middleName.equals(client.middleName)) return false;
		if (!firstName.equals(client.firstName)) return false;
		if (!lastName.equals(client.lastName)) return false;
		return passport.equals(client.passport);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + middleName.hashCode();
		result = 31 * result + firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Client:").append("\n")
				.append("First name: ").append(firstName).append("\n")
				.append("Middle name: ").append(middleName).append("\n")
				.append("Last name: ").append(lastName).append("\n")
				.append("Passport: ").append(passport.getSeries()).append("\n");

		return sb.toString();
	}
}