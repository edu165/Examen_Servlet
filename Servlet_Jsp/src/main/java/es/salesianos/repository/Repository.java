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
import es.salesianos.model.User;




public class Repository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test2";
	static ConnectionManager manager = new ConnectionH2();
	
		Connection connection = null;
		Statement statement = null;
		
	public void CreateTableIdiomas() {
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = manager.open(jdbcUrl);
			statement = connection.createStatement();
			statement.execute("create table IF NOT EXISTS Idiomas(idioma varchar(25) PRIMARY KEY);");
			statement.execute("create table IF NOT EXISTS Paises(pais varchar(25) PRIMARY KEY,idioma varchar(25));");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null && connection != null) {
				try {
					statement.close();
					connection.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			
		}
	}
	public void CreateTablePaises() {
		Connection connection = null;
		Statement statement = null;
		

		try {
			connection = manager.open(jdbcUrl);
			statement = connection.createStatement();
			
			statement.execute("create table IF NOT EXISTS Paises(pais varchar(25) PRIMARY KEY,idioma varchar(25));");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null && connection != null) {
				try {
					statement.close();
					connection.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	public User search(User userFormulario) {
		User userInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Paises WHERE Pais = ?");
			prepareStatement.setString(1, userFormulario.getPais());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				userInDatabase = new User();
				userInDatabase.setPais(resultSet.getString(1));
				userInDatabase.setIdioma(resultSet.getString(2));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			CloseResulset(resultSet);
			ClosePreparedStatement(prepareStatement);
			
		}
		manager.close(conn);
		return userInDatabase;
	}

	private static void ClosePreparedStatement(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static void CloseResulset(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void InserPaises(User userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Paises (pais, idioma)" +
					"VALUES (?, ?)");
			preparedStatement.setString(1, userFormulario.getPais());
			preparedStatement.setString(2, userFormulario.getIdioma());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ClosePreparedStatement(preparedStatement);
		}
		
		
		manager.close(conn);
	}
	public void InsertIdiomas(Idiomas userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO idiomas (idioma)" +
					"VALUES (?)");
			preparedStatement.setString(1, userFormulario.getIdioma());
			
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ClosePreparedStatement(preparedStatement);
		}
		
		
		manager.close(conn);
	}

	public void Update(User userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE paises SET idioma=?  where pais=?");
			preparedStatement.setString(1, userFormulario.getIdioma());
			preparedStatement.setString(2, userFormulario.getPais());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ClosePreparedStatement(preparedStatement);
		}
		
		
		manager.close(conn);
	}
	public static List SearchAll_Paises() {
		List<User> listUsers= new ArrayList<User>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Paises");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				User userInDatabase = new User();
				userInDatabase.setPais(resultSet.getString(1));
				userInDatabase.setIdioma(resultSet.getString(2));
				
				
				listUsers.add(userInDatabase);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			CloseResulset(resultSet);
			ClosePreparedStatement(prepareStatement);
		}
		
		
		manager.close(conn);
		return listUsers;
	}

	public static List<Idiomas> SearchAll_Idiomas() {
		List<Idiomas> listUsers= new ArrayList<Idiomas>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Idiomas");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Idiomas userInDatabase = new Idiomas();
				userInDatabase.setIdioma(resultSet.getString(1));
				listUsers.add(userInDatabase);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			CloseResulset(resultSet);
			ClosePreparedStatement(prepareStatement);
		}
		
		
		manager.close(conn);
		return listUsers;
	}
	
	
	public void DeletePais(String idioma) {
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
	public void DeleteIdiomas(String idioma) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;

		try {
		   
			 preparedStatement = conn.prepareStatement("DELETE  from Idiomas where idioma=? ");
				preparedStatement.setString(1, idioma);
			preparedStatement.executeUpdate();
			

		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null && conn != null ) {
				try {
					preparedStatement.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	}


}
	
}