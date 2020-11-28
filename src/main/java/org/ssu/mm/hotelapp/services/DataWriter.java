package org.ssu.mm.hotelapp.services;

import java.io.IOException;

public interface DataWriter {
	<T> void save(T object, String fileName) throws IOException;
}
