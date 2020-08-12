package com.databaseweb.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.databaseweb.domain.DBName;
import com.databaseweb.domain.Describe;

/**
 * 連接數據庫
 * @author wayne
 *
 */
public class DBlistDao {
	
	public List<DBName> getDBNameList() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<DBName> list = new ArrayList<>();
		try {
			con = JDBCUtils.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SHOW DATABASES");
			
			while(rs.next()) {
				String name = rs.getString(1);
				DBName dbName = new DBName();
				dbName.setDataName(name);
				list.add(dbName);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				closeAll(con, stmt, rs);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return list;
	}
	
	/*
	 * 傳入資料庫名稱,返回table list
	 */
	public List<DBName> getTableNameList(String database) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<DBName> list = new ArrayList<>();
		try {
			con = JDBCUtils.getConnection( );
			con.setCatalog(database);
			stmt = con.createStatement();
			//stmt.execute("USE " + database);
			rs = stmt.executeQuery("SHOW TABLES");
			
			while(rs.next()) {
				String name = rs.getString(1);
				DBName dbName = new DBName();
				dbName.setDataName(name);
				list.add(dbName);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				closeAll(con, stmt, rs);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return list;
	}
	
	public List<Describe> getDescribeList(String database, String table) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Describe> list = new ArrayList<>();
		try {
			con = JDBCUtils.getConnection( );
			con.setCatalog(database);
			stmt = con.createStatement();
			//stmt.execute("USE " + database);
			rs = stmt.executeQuery("DESCRIBE " + table);
			
			while(rs.next()) {
				Describe describe = new Describe();
				describe.setField(rs.getString("Field"));
				describe.setType(rs.getString("Type"));
				describe.setNullable(rs.getString("Null"));
				describe.setKey(rs.getString("Key"));
				describe.setDefaultValue(rs.getString("Default"));
				describe.setExtra(rs.getString("Extra"));
				list.add(describe);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				closeAll(con, stmt, rs);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		return list;
	}

	public List<List> showTableData(String database, String table) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<List> list = new ArrayList<>();

		try {
			con = JDBCUtils.getConnection( );
			con.setCatalog(database); //設定使用哪個資料庫
			stmt = con.createStatement();
			//stmt.execute("USE " + database);
			rs = stmt.executeQuery("select * from " + table);
			
			//用來存儲table field名稱
			List fieldList = new ArrayList();
			
			//ResultSetMetaData取得Table的欄位名稱
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				fieldList.add(rsmd.getColumnName(i));
			}
			list.add(fieldList);
			
			while (rs.next()) {
				List data = new ArrayList();
				for (int i = 1; i <= fieldList.size(); i++) {
					data.add(rs.getObject(i));
				}
				list.add(data);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				closeAll(con, stmt, rs);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
	
	
	public List<List> query(String dbName, String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<List> list = new ArrayList<>();
		
		try {
			con = JDBCUtils.getConnection( );
			con.setCatalog(dbName); //設定使用哪個資料庫
			stmt = con.createStatement();
			//stmt.execute("USE " + database);
			rs = stmt.executeQuery(sql);
			
			//用來存儲table field名稱
			List fieldList = new ArrayList();
			
			//ResultSetMetaData取得Table的欄位名稱
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				fieldList.add(rsmd.getColumnName(i));
			}
			list.add(fieldList);
			
			while (rs.next()) {
				List data = new ArrayList();
				for (int i = 1; i <= fieldList.size(); i++) {
					data.add(rs.getObject(i));
				}
				list.add(data);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				closeAll(con, stmt, rs);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
	

	public List<List> upDate(String dbName, String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<List> list = new ArrayList<>();
		
		try {
			con = JDBCUtils.getConnection( );
			con.setCatalog(dbName); 
			stmt = con.createStatement();
			int row = stmt.executeUpdate(sql);
			String s = "Query OK, " + row + " rows affected";
			
			List rowlist = new ArrayList();
			rowlist.add(s);
			list.add(rowlist);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				closeAll(con, stmt, rs);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}

	
	/*
	 * 返回資料庫名稱
	 */
	public String useDatabase(String database) throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String string = null;
		try {
			con = JDBCUtils.getConnection( );
			con.setCatalog(database);
			stmt = con.createStatement();
			stmt.execute("USE " + database);
			string = con.getCatalog();
			
		} catch (SQLException e) {
			throw new RuntimeException("無該資料庫[" + database + "]");
		} finally {
			try {
				closeAll(con, stmt, rs);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return string;
	}
	
	
	private void closeAll(Connection con, Statement stmt, ResultSet rs) throws SQLException{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (con != null) con.close();
	
	}


}
