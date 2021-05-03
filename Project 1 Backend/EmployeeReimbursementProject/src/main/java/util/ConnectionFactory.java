package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	static {
		
	}
	
	private static final String URL = System.getenv("POSTGRES_DB_URL");
	private static final String USERNAME = System.getenv("POSTGRESQL_DB_USERNAME");
	private static final String PASSWORD = System.getenv("POSTGRESQL_DB_PASSWORD");
	
	private static Connection conn;
	
	public static Connection getConnection() {
		
		
		try {
			//I was getting a weird exception where the postgresql driver could not be found, this fixed it
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
