package com.databaseweb.domain;

import java.util.List;
/**
 * 用來存儲名稱
 * @author wayne
 *
 */
public class DBName {

	private String dataName;

	public DBName() {
		super();
	}

	public DBName(String dataName) {
		super();
		this.dataName = dataName;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	@Override
	public String toString() {
		return "DBName [dataName=" + dataName + "]";
	}
	
}
