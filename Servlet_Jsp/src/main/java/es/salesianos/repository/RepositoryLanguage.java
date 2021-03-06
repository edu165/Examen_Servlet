package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Language;

public class RepositoryLanguage extends Repository {

	static ConnectionManager manager = new ConnectionH2();

	public void createTableLanguage() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = manager.open(jdbcUrl);
			statement = connection.createStatement();
			statement.execute("create table IF NOT EXISTS Idiomas(idioma varchar(25) PRIMARY KEY);");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
			manager.close(connection);

		}
	}

	public void insertLaguages(Language countryform) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO idiomas (idioma)" + "VALUES (?)");
			preparedStatement.setString(1, countryform.getLanguage());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			closeStatement(preparedStatement);
		}

		manager.close(conn);
	}

	public List<Language> searchallLanguages() {
		List<Language> listcountry = new ArrayList<Language>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Idiomas");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Language CountryInDatabase = new Language();
				CountryInDatabase.setLanguage(resultSet.getString(1));
				listcountry.add(CountryInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			closeResultSet(resultSet);
			closeStatement(prepareStatement);
		}

		manager.close(conn);
		return listcountry;
	}

	public void deleteLanguage(String language) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = conn.prepareStatement("DELETE  from Idiomas where idioma=? ");
			preparedStatement.setString(1, language);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(preparedStatement);
			manager.close(conn);

		}

	}

}