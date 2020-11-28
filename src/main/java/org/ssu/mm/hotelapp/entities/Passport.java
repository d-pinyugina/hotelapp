package org.ssu.mm.hotelapp.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

// Сериализация (Serialization) — это процесс, который переводит объект в последовательность байтов,
// по которой затем его можно полностью восстановить.
@XmlRootElement
public class Passport implements Serializable {
	private String id;
	private int series;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Passport passport = (Passport) o;
		return series == passport.series;
	}

	@Override
	public int hashCode() {
		return Objects.hash(series);
	}
}
