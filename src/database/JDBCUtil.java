package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url = "jdbc:mysql://localhost:3306/qlsv";
			String username = "root";
			String password = "";
			
			c = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static Connection closeConnection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
