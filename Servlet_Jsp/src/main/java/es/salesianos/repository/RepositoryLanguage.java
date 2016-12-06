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
import es.salesianos.model.Country;

public class RepositoryLanguage {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test2";
	static ConnectionManager manager = new ConnectionH2();
	Connection connection = null;
		Statement statement = null;
public  void closeresultset(ResultSet resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
private  void closestatement(Statement statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}


public void createrablelanguage() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = manager.open(jdbcUrl);
			statement = connection.createStatement();
			statement.execute("create table IF NOT EXISTS Idiomas(idioma varchar(25) PRIMARY KEY);");
			statement.execute("create table IF NOT EXISTS Paises(pais varchar(25) PRIMARY KEY,idioma varchar(25));");
			} catch (Exception e) {
			e.printStackTrace();
		} finally  {
			 closestatement(statement);
			manager.close(connection);
			
		}
		}
	
	public void insertlanguage(Language countryform) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO idiomas (idioma)" +
					"VALUES (?)");
		preparedStatement.setString(1, countryform.getLanguage());
		preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			closestatement(preparedStatement);
		}
		
		
		manager.close(conn);
	}

public  List<Language> searchalllanguages() {
		List<Language> listcountry= new ArrayList<Language>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Idiomas");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Language CountryInDatabase = new Language();
				CountryInDatabase.setLanguage(resultSet.getString(1));
				listcountry.add(CountryInDatabase);
			}
			} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			
			closeresultset(resultSet);
			closestatement(prepareStatement);
		}
		
		manager.close(conn);
		return listcountry;
	}
	
	
	public void deletelanguage(String language) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;

		try {
		   
			 preparedStatement = conn.prepareStatement("DELETE  from Idiomas where idioma=? ");
				preparedStatement.setString(1, language);
			preparedStatement.executeUpdate();
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closestatement(preparedStatement);
			manager.close(conn);
			
		}


}
	
}