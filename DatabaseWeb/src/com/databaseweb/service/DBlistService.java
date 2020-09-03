package com.databaseweb.service;

import java.util.List;

import com.databaseweb.dao.DBlistDao;
import com.databaseweb.domain.DBName;

/**
 * 業務層service, 依執行條件調用DAO中的方法
 * @author wayne
 *
 */
public class DBlistService {
	DBlistDao dao = new DBlistDao();

	/**
	 * 取得所有資料庫列表
	 */
	public List<DBName> getDBNameList() {
		return dao.getDBNameList();
	}

	/**
	 * 取得傳入的資料庫名稱所有的資料表列表
	 */
	public List<DBName> getTableNameList(String database) {
		if (database != null) {
			return dao.getTableNameList(database);
		}
		return null;
	}

	/**
	 * 資料表列表內容select * from tableName
	 */
	public List<List> showTableData(String database, String tableName) {
		return dao.showTableData(database, tableName);
	}

	/**
	 * 執行使用者所輸入的USE Database_name語句
	 */
	public String useDatabase(String database) throws Exception {
		return dao.useDatabase(database);
	}

	/**
	 * 執行使用者所輸入的SQL增刪改查語句
	 */
	public List<List> query(String dbName, String sql, Boolean isSelect) throws Exception {

		if (isSelect) {
			return dao.query(dbName, sql); // select語句,返回查詢結果
		} else {
			return dao.upDate(dbName, sql); // false非select語句,返回的是影響幾條數據
		}
	}

}
