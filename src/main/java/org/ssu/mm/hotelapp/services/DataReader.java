package org.ssu.mm.hotelapp.services;

import java.io.FileNotFoundException;
import java.io.IOException;

// интерфейс для чтения обьектов
public interface DataReader {
	<T> T load(Class<T> clazz, String fileNam) throws IOException;
}
