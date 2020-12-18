package org.ssu.mm.hotelapp;

import org.ssu.mm.hotelapp.entities.*;
import org.ssu.mm.hotelapp.services.XmlDataReader;
import org.ssu.mm.hotelapp.services.XmlDataWriter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConsoleMain {
	private static final XmlDataWriter xmlDataWriter = XmlDataWriter.getInstance();
	private static final XmlDataReader xmlDataReader = XmlDataReader.getInstance();


	public static void main(String[] args) throws IOException {
		clientsProcessing();

		writeHotelAccommodations();
		readHotelAccommodations();
	}


	private static void clientsProcessing() throws IOException {
		ClientsList clientsList = createClients();
		System.out.println("Show clients list:");
		clientsList.getClients().forEach(System.out::println);
		save(clientsList, "clients.xml");
		System.out.println("Clients successfully saved into file");
		clientsList = readClients();
		System.out.println("Clients successfully loaded from file");
		System.out.println("Remove first client and show clients list:");
		clientsList.remove(0);
		clientsList.getClients().forEach(System.out::println);
		System.out.println("Get info about last client:");
		Client lastClient = clientsList.get(clientsList.size() - 1);
		System.out.println(lastClient);
	}

	private static ClientsList createClients() {
		Client client1 = createClient("Григорий", "Иванов", "Иванович", 12345678, "Первый клиент");
		Client client2 = createClient("Иван", "Петрович", "Петров", 67841264, "Второй клиент");
		Client client3 = createClient("Василий", "Васильев", "Иванович", 1454644, "Третий клиент");
		Client client4 = createClient("Елена", "Иванова", "Сергеевна", 9899778, "Четвертый клиент");
		Client client5 = createClient("Сергей", "Захаров", "Захарович", 1252588, "Пятый клиент");

		List<Client> clients = new ArrayList<>();
		clients.add(client1);
		clients.add(client2);
		clients.add(client3);
		clients.add(client4);
		clients.add(client5);

		System.out.println("Clients successfully created");

		return new ClientsList(clients);
	}

	private static void writeHotelAccommodations() throws IOException {
		Client client1 = createClient("Grigory", "Ivanov", "Ivanovich", 12345678, "First client");
		Room room1 = createRoom(2, 100, 500, Conveniences.COMFORT);
		HotelAccommodation hotelAccommodation1 = createHotelAccommodation(client1, room1);

		Client client2 = createClient("Grigory", "Ivanov", "Ivanovich", 12345678, "First client");
		Room room2 = createRoom(1, 101, 300, Conveniences.ECONOMY);
		HotelAccommodation hotelAccommodation2 = createHotelAccommodation(client2, room2);

		Client client3 = createClient("Grigory", "Ivanov", "Ivanovich", 12345678, "First client");
		Room room3 = createRoom(1, 102, 500, Conveniences.COMFORT);
		HotelAccommodation hotelAccommodation3 = createHotelAccommodation(client3, room3);

		List<HotelAccommodation> hotelAccommodations = new ArrayList<>();
		hotelAccommodations.add(hotelAccommodation1);
		hotelAccommodations.add(hotelAccommodation2);
		hotelAccommodations.add(hotelAccommodation3);

		xmlDataWriter.save(new HotelAccommodationList(hotelAccommodations), "hotelAccommodations.xml");
	}


	private static Client createClient(String firstName, String middleName, String lastName, int passportSeries,
	                                   String comment) {
		Client client = new Client();
		client.setId(UUID.randomUUID().toString());
		client.setFirstName(firstName);
		client.setMiddleName(middleName);
		client.setLastName(lastName);
		Passport passport = new Passport();
		passport.setSeries(passportSeries);
		client.setPassport(passport);
		client.setComment(comment);

		return client;
	}

	private static Room createRoom(int capacity, int roomNumber, int price, Conveniences conveniences) {
		Room room = new Room();
		room.setRoomId(UUID.randomUUID().toString());
		room.setCapacity(capacity);
		room.setRoomNumber(roomNumber);
		room.setRoomPrice(BigDecimal.valueOf(price));
		room.setConveniences(conveniences);

		return room;
	}

	private static HotelAccommodation createHotelAccommodation(Client client, Room room) {
		HotelAccommodation hotelAccommodation = new HotelAccommodation();
		hotelAccommodation.setId(UUID.randomUUID().toString());
		hotelAccommodation.setClient(client);
		hotelAccommodation.setRoom(room);

		return hotelAccommodation;
	}

	private static ClientsList readClients() throws IOException {
		return xmlDataReader.load(ClientsList.class, "clients.xml");
	}

	private static void readHotelAccommodations() throws IOException {
		HotelAccommodationList hotelAccommodations = xmlDataReader.load(HotelAccommodationList.class, "hotelAccommodations.xml");
		hotelAccommodations.getHotelAccommodations().forEach(System.out::println);
	}

	private static <T> void save(T list, String fileName) throws IOException {
		xmlDataWriter.save(list, fileName);
	}
}
