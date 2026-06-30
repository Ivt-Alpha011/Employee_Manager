package tech.codehunt.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DB_URL="jdbc:mysql://localhost:3306";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="";
	public static Connection getConnection() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
		public static void close(AutoCloseable resource){
			try {
				if(resource!=null) 
				resource.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
	

}
}
