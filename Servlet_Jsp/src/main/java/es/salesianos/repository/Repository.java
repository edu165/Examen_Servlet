package es.salesianos.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Repository {
	
	
	public void closestatement(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
public   void closeresultset(ResultSet resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}




}
	
