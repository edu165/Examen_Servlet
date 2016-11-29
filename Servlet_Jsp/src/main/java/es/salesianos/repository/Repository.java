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
import es.salesianos.model.Idiomas;
import es.salesianos.model.Pais;

public class Repository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test2";
	static ConnectionManager manager = new ConnectionH2();
	Connection connection = null;
		Statement statement = null;
public static  void closeresultset(ResultSet resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
private static void closestatement(Statement statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

private static void closepreparedstatement(PreparedStatement prepareStatement) {
	try {
		prepareStatement.close();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
}
public void createrableidiomas() {
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
	
		public void createtablepaises() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = manager.open(jdbcUrl);
			statement = connection.createStatement();
			
			statement.execute("create table IF NOT EXISTS Paises(pais varchar(25) PRIMARY KEY,idioma varchar(25));");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 closestatement(statement);
			manager.close(connection);
			}
	}

	public Pais search(Pais PaisFormulario) {
		Pais PaisInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Paises WHERE Pais = ?");
			prepareStatement.setString(1, PaisFormulario.getPais());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				PaisInDatabase = new Pais();
				PaisInDatabase.setPais(resultSet.getString(1));
				PaisInDatabase.setIdioma(resultSet.getString(2));
				}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			closeresultset(resultSet);
			closepreparedstatement(prepareStatement);
			
		}
		manager.close(conn);
		return PaisInDatabase;
	}



	public void insertpaises(Pais PaisFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Paises (pais, idioma)" +
					"VALUES (?, ?)");
			preparedStatement.setString(1, PaisFormulario.getPais());
			preparedStatement.setString(2, PaisFormulario.getIdioma());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			closepreparedstatement(preparedStatement);
		}
		manager.close(conn);
	}
	public void insertidiomas(Idiomas PaisrFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO idiomas (idioma)" +
					"VALUES (?)");
		preparedStatement.setString(1, PaisrFormulario.getIdioma());
		preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			closepreparedstatement(preparedStatement);
		}
		
		
		manager.close(conn);
	}

	public void update(Pais PaiFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE paises SET idioma=?  where pais=?");
			preparedStatement.setString(1, PaiFormulario.getIdioma());
			preparedStatement.setString(2, PaiFormulario.getPais());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			closepreparedstatement(preparedStatement);
		}
		
		
		manager.close(conn);
	}
	public  List searchallpaises() {
		List<Pais> listUsers= new ArrayList<Pais>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Paises");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Pais userInDatabase = new Pais();
				userInDatabase.setPais(resultSet.getString(1));
				userInDatabase.setIdioma(resultSet.getString(2));
				listUsers.add(userInDatabase);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			closeresultset(resultSet);
			closepreparedstatement(prepareStatement);
		}
		manager.close(conn);
		return listUsers;
	}

	public static List<Idiomas> searchAllIdiomas() {
		List<Idiomas> listUsers= new ArrayList<Idiomas>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Idiomas");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Idiomas PaisInDatabase = new Idiomas();
				PaisInDatabase.setIdioma(resultSet.getString(1));
				listUsers.add(PaisInDatabase);
			}
			} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			
			closeresultset(resultSet);
			closepreparedstatement(prepareStatement);
		}
		
		manager.close(conn);
		return listUsers;
	}
	
	public void deletepais(String idioma) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;

		try {
		    preparedStatement = conn.prepareStatement("DELETE from Paises where idioma=? ");
			preparedStatement.setString(1, idioma);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null && conn != null) {
				try {
					preparedStatement.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	public void deleteidiomas(String idioma) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;

		try {
		   
			 preparedStatement = conn.prepareStatement("DELETE  from Idiomas where idioma=? ");
				preparedStatement.setString(1, idioma);
			preparedStatement.executeUpdate();
			

		

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closepreparedstatement(preparedStatement);
			manager.close(conn);
			
		}


}
	
}