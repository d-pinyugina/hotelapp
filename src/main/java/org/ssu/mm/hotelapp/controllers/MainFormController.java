package org.ssu.mm.hotelapp.controllers;

import javafx.event.ActionEvent;
import org.ssu.mm.hotelapp.entities.*;
import org.ssu.mm.hotelapp.services.XmlDataReader;
import org.ssu.mm.hotelapp.services.XmlDataWriter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// класс, который обрабатывает действия на главном окне
public class MainFormController {
	public void clickBigButton(ActionEvent event) throws IOException {
		XmlDataWriter dataWriter = XmlDataWriter.getInstance();

		Client client = new Client();
		client.setId(UUID.randomUUID().toString());
		client.setFirstName("Grigoriy");
		client.setMiddleName("Ivanov");
		client.setLastName("Ivanovich");
		Passport passport = new Passport();
		passport.setSeries(12345678);
		client.setPassport(passport);
		client.setComment("First client");


		Room room1 = new Room();
		room1.setRoomId(UUID.randomUUID().toString());
		room1.setCapacity(2);
		room1.setRoomNumber(100);
		room1.setRoomPrice(BigDecimal.valueOf(500,5));
		room1.setConveniences(Conveniences.COMFORT);

		HotelAccommodation hotelAccommodation = new HotelAccommodation();
		hotelAccommodation.setId(UUID.randomUUID().toString());
		hotelAccommodation.setClient(client);
		hotelAccommodation.setRoom(room1);

		dataWriter.save(hotelAccommodation, "hotelAccommodations.xml");

		Client client2 = new Client();
		client2.setId(UUID.randomUUID().toString());
		client2.setFirstName("Ivan");
		client2.setMiddleName("Petrovich");
		client2.setLastName("Petrov");
		passport = new Passport();
		passport.setSeries(2222222);
		client2.setPassport(passport);
		client2.setComment("Second client");

		List<Client> clients = new ArrayList<>();
		clients.add(client);
		clients.add(client2);

		//сохранение списка клиентов в xml файле
		dataWriter.save(new ClientsList(clients), "clients.xml");
	}

	// метод, который загружает клинтов
	public void loadClient(ActionEvent event) throws IOException {
		XmlDataReader xmlDataReader = XmlDataReader.getInstance();
//		ClientsList client = xmlDataReader.load(ClientsList.class, "clients.xml");

//		client.getClients().forEach(System.out::println);


		HotelAccommodation hotelAccommodation = xmlDataReader.load(HotelAccommodation.class, "hotelAccommodations.xml");
		System.out.println(hotelAccommodation);
	}
}
