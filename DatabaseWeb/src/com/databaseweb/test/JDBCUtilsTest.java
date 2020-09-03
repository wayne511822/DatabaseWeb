package com.databaseweb.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.databaseweb.dao.JDBCUtils;
/**
 * unit test類用於測試JDBCUtilsTest資料庫連線功能
 * @author wayne
 *
 */
public class JDBCUtilsTest {

	@Test
	public void getConnectionTest() throws SQLException {
		Connection con = JDBCUtils.getConnection();
		System.out.println(con);
		
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("show databases");
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
	}
	
}
