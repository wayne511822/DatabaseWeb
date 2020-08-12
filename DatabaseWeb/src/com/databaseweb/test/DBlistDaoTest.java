package com.databaseweb.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.databaseweb.dao.DBlistDao;
import com.databaseweb.dao.PageBean;
import com.databaseweb.domain.DBName;
import com.databaseweb.domain.Describe;
import com.databaseweb.domain.User;

public class DBlistDaoTest {
	DBlistDao dao = new DBlistDao();
	
	@Test
	public void getTableNameListTest() {
		
		List<DBName> list = dao.getTableNameList("mywebdb");
		
		for(DBName name : list) {
			System.out.println(name.getDataName());
		}
	}
	
	
	@Test
	public void getDescribeListTest() {
		List<Describe> list = dao.getDescribeList("mywebdb", "user");
		
		for(Describe des : list) {
			System.out.println(des);
		}
	}
	
	@Test
	public void showTableDataTest() {
		List<List> list = dao.showTableData("mywebdb", "account");
		
		for (List data : list) {
			System.out.println(data);
		}
	}
	
}
