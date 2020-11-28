package org.ssu.mm.hotelapp.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;

/**
 * проживание в отеле
 **/
@XmlRootElement
public class HotelAccommodation {
	private String id;
	private Client client;
	private Room room;
	private Date checkIn;
	private Date checkOut;
	private String description;


	public HotelAccommodation() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		HotelAccommodation that = (HotelAccommodation) o;

		if (!Objects.equals(id, that.id)) return false;
		if (!Objects.equals(client, that.client)) return false;
		if (!Objects.equals(room, that.room)) return false;
		if (!Objects.equals(checkIn, that.checkIn)) return false;
		return Objects.equals(checkOut, that.checkOut);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (client != null ? client.hashCode() : 0);
		result = 31 * result + (room != null ? room.hashCode() : 0);
		result = 31 * result + (checkIn != null ? checkIn.hashCode() : 0);
		result = 31 * result + (checkOut != null ? checkOut.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "HotelAccommodation{" +
				"id='" + id + '\'' +
				", client=" + client +
				", room=" + room +
				", checkIn=" + checkIn +
				", checkOut=" + checkOut +
				", description='" + description + '\'' +
				'}';
	}
}
