package es.salesianos.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;

public class Repository {
	protected static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test2";
	static ConnectionManager manager = new ConnectionH2();
	Connection connection = null;
	Statement statement = null;

	public void closeStatement(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void closeResultSet(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
