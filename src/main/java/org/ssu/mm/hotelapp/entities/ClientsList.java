package org.ssu.mm.hotelapp.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientsList {
	@XmlElement(name = "client")
	private List<Client> clients;
//конструктор по умолчанию для сериализации
	public ClientsList() {
	}
// создаем конструктор, принимающий список клиентов
	public ClientsList(List<Client> clients) {
		this.clients = clients;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public void add(Client client) {
		clients.add(client);
	}

	public void remove(Client client) {
		clients.remove(client);
	}

	public void remove(int index) {
		clients.remove(index);
	}

	public Client get(int index) {
		return clients.get(index);
	}

	public int size() {
		return clients.size();
	}
}
