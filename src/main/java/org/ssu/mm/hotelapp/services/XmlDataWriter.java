package org.ssu.mm.hotelapp.services;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class XmlDataWriter implements DataWriter {
	private static XmlDataWriter instance;


	private XmlDataWriter() {
	}


	public static XmlDataWriter getInstance() {
		if (instance == null)
			instance = new XmlDataWriter();
		return instance;
	}

	@Override
	public <T> void save(T object, String fileName) throws IOException {
		try {
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(object, new File(fileName));
		} catch (JAXBException e) {
			throw new IOException(String.format("Cannot save '%s' to file: %s", object.toString(), fileName), e);
		}
	}
}
