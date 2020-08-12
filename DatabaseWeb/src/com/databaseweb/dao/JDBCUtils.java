package com.databaseweb.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * v1.0
 * @author wayne
 *
 */
public class JDBCUtils {
	private static Properties prop  = null;
	
	static {
		
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		prop = new Properties(); 
		try {
			prop.load(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		try {
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}

}
