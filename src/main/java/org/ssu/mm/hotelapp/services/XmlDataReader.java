package org.ssu.mm.hotelapp.services;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlDataReader implements DataReader {
	private static XmlDataReader instance;

//конструктор, который не позволяет создать обьект извне, только при вызове метода getInstance
	private XmlDataReader() {
	}


	public static XmlDataReader getInstance() {
		if (instance == null)
			instance = new XmlDataReader();
		return instance;
	}

	@Override
	public <T> T load(Class<T> clazz, String fileName) throws IOException {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return clazz.cast(unmarshaller.unmarshal(new File(fileName)));
		} catch (JAXBException e) {
			throw new IOException(String.format("Cannot load object '%s' from file: %s", clazz, fileName), e);
		}
	}
}
