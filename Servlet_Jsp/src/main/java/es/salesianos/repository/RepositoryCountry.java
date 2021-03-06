package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.model.Country;

public class RepositoryCountry extends Repository {
	Connection connection = null;
	Statement statement = null;

	public void createTableCountry() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = manager.open(jdbcUrl);
			statement = connection.createStatement();
			statement.execute("create table IF NOT EXISTS Paises(pais varchar(25) PRIMARY KEY,idioma varchar(25));");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);

			manager.close(connection);
		}
	}

	public Country search(Country countryFormulario) {
		Country countryInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Paises WHERE Pais = ?");
			prepareStatement.setString(1, countryFormulario.getCountry());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				countryInDatabase = new Country();
				countryInDatabase.setCountry(resultSet.getString(1));
				countryInDatabase.setLanguage(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(prepareStatement);

		}
		manager.close(conn);
		return countryInDatabase;
	}

	public void insertCountry(Country countryFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Paises (pais, idioma)" + "VALUES (?, ?)");
			preparedStatement.setString(1, countryFormulario.getCountry());
			preparedStatement.setString(2, countryFormulario.getLanguage());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			closeStatement(preparedStatement);
		}
		manager.close(conn);
	}

	public void update(Country countryForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE paises SET idioma=?  where pais=?");
			preparedStatement.setString(1, countryForm.getLanguage());
			preparedStatement.setString(2, countryForm.getCountry());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			closeStatement(preparedStatement);
		}

		manager.close(conn);
	}

	public List<Country> searchAllcountry() {
		List<Country> listcountry = new ArrayList<Country>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Paises");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Country countryInDatabase = new Country();
				countryInDatabase.setCountry(resultSet.getString(1));
				countryInDatabase.setLanguage(resultSet.getString(2));
				listcountry.add(countryInDatabase);
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

	public void deleteCountry(String country) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = conn.prepareStatement("DELETE from Paises where idioma=? ");
			preparedStatement.setString(1, country);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(preparedStatement);
			manager.close(conn);

		}
	}

}
