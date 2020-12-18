package org.ssu.mm.hotelapp.entities;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "rooms")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomList {
	@XmlElement(name = "room")
	private List<Room> rooms;


	public RoomList() {
	}

	public RoomList(List<Room> rooms) {
		this.rooms = rooms;
	}


	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void add(Room room) {
		rooms.add(room);
	}

	public void remove(Room room) {
		rooms.remove(room);
	}
}
