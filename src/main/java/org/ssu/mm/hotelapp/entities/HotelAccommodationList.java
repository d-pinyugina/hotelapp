package org.ssu.mm.hotelapp.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "hotelAccommodations")
@XmlAccessorType(XmlAccessType.FIELD)
public class HotelAccommodationList {
	@XmlElement(name = "hotelAccommodation")
	private List<HotelAccommodation> hotelAccommodations;


	public HotelAccommodationList() {
	}

	public HotelAccommodationList(List<HotelAccommodation> hotelAccommodations) {
		this.hotelAccommodations = hotelAccommodations;
	}


	public List<HotelAccommodation> getHotelAccommodations() {
		return hotelAccommodations;
	}

	public void setHotelAccommodations(List<HotelAccommodation> hotelAccommodations) {
		this.hotelAccommodations = hotelAccommodations;
	}

	public void add(HotelAccommodation hotelAccommodation) {
		hotelAccommodations.add(hotelAccommodation);
	}

	public void remove(HotelAccommodation hotelAccommodation) {
		hotelAccommodations.remove(hotelAccommodation);
	}

	public void remove(int index) {
		hotelAccommodations.remove(index);
	}

	public HotelAccommodation get(int index) {
		return hotelAccommodations.get(index);
	}

	public int size() {
		return hotelAccommodations.size();
	}
}
