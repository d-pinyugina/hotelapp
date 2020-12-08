package org.ssu.mm.hotelapp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseService<T> implements Service<T> {
	protected final String connectionUrl = "jdbc:sqlite:test.db";
	protected Connection connection;

}
