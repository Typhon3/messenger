package tests;

import java.sql.Connection;
import java.sql.DriverManager;

public class HibernateTest {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/e-commerce?useSSL=false&serverTimezone=GMT";
		String user = "default";
		String pass = "default";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection con  = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
