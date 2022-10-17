package com.harman.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import com.harman.exception.PersonException;

public class ConnectionProvider {
	private static Connection con=null;
	private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/student";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Aarti@123";
	
	public static Connection getConnection() throws  PersonException 
	{
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(Exception excep)
		{
			throw new PersonException("Sorry we coudn't establish connection b/w database");
		}
		return con;
	}	
}