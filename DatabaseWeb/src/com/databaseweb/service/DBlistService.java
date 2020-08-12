package com.databaseweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.databaseweb.dao.DBlistDao;
import com.databaseweb.dao.PageBean;
import com.databaseweb.domain.DBName;
import com.databaseweb.domain.User;

/**
 * 
 * @author wayne
 *
 */
public class DBlistService {
	DBlistDao dao = new DBlistDao();

	public List<DBName> getDBNameList() {
		return dao.getDBNameList();
	}

	public List<DBName> getTableNameList(String database) {
		if (database != null) {
			return dao.getTableNameList(database);
		}
		return null;
	}

	public List<List> showTableData(String database, String tableName) {
		return dao.showTableData(database, tableName);
	}

	public String useDatabase(String database) throws Exception {
		return dao.useDatabase(database);
	}

	public List<List> query(String dbName, String sql, Boolean isSelect) throws Exception {

		if (isSelect) {
			return dao.query(dbName, sql); // select語句,返回查詢結果
		} else {
			return dao.upDate(dbName, sql); // false非select語句,返回的是處裡幾條數據
		}
	}

}
