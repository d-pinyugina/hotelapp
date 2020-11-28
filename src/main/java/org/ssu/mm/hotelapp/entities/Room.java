package org.ssu.mm.hotelapp.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Room implements Serializable {
	private String roomId;
	private BigDecimal roomPrice;
	private int roomNumber;
	private int capacity;
	private Conveniences conveniences;

	public BigDecimal getRoomPrice() {
		return roomPrice;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public void setRoomPrice(BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Conveniences getConveniences() {
		return conveniences;
	}

	public void setConveniences(Conveniences conveniences) {
		this.conveniences = conveniences;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Room room = (Room) o;

		if (roomNumber != room.roomNumber) return false;
		if (capacity != room.capacity) return false;
		if (!roomId.equals(room.roomId)) return false;
		if (!roomPrice.equals(room.roomPrice)) return false;
		return conveniences == room.conveniences;
	}

	@Override
	public int hashCode() {
		int result = roomId.hashCode();
		result = 31 * result + roomPrice.hashCode();
		result = 31 * result + roomNumber;
		result = 31 * result + capacity;
		result = 31 * result + conveniences.hashCode();
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Room:").append("\n")
				.append("Capacity: ").append(capacity).append("\n")
				.append("RoomNumber: ").append(roomNumber).append("\n")
				.append("Conveniences: ").append(conveniences).append("\n");

		return sb.toString();
	}
}
