package com.databaseweb.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��{�@��servlet�B�̦h�ӽШD
 * @author wayne
 *
 */
public abstract class BaseServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.取得請求的方法名
		 */
		String methodName = request.getParameter("method");
		
		if(methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("沒有相應的方法,請確認方法名");
		}
			
		/*
		 * 2.利用反射調用同名方法
		 */
		Class clazz = this.getClass();
		Method method = null;
		try {
			method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("要調用的方法"+ methodName +"無法獲得");
		} 
		
		/*
		 * �եΤ�k
		 */
		try {
			method.invoke(this, request, response);  //this.��k�W(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
