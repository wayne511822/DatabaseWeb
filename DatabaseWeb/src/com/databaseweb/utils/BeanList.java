package com.databaseweb.utils;

import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BeanList<T> {

	/*
	 *
	 */
	public List<T> toBeanList(ResultSet rs, Class<T> clazz, Object...params) throws Exception {
		
		while (rs.next()) {
			for (int i = 0 ; i < params.length ; i++) {
				Object obj = rs.getObject(i+1);
				
			}
		}
		
		
		return null;
	}
	
	
	private T toBean(Class<T> clazz, Object...params) throws Exception {
		T instance = clazz.getDeclaredConstructor().newInstance();
		int length = params.length;
	
		return null;
	}
}
