package com.databaseweb.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseweb.domain.DBName;
import com.databaseweb.service.DBlistService;

/**
 * 接收請求回應結果
 * @author wayne
 *
 */
public class DBlistServlet extends BaseServlet {

	private DBlistService dblistService = new DBlistService();

	/**
	 * 轉發給頁面資料庫list
	 */
	public void getDBNameList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 透過service取得資料庫list對象
		List<DBName> dbNameList = dblistService.getDBNameList();

		// 保存集合對像致request域
		req.setAttribute("dbNameList", dbNameList);

		// 結果轉發到頁面
		req.getRequestDispatcher("/view/dblist.jsp").forward(req, resp);
	}

	/**
	 * 轉發給頁面資料表list
	 */
	public void getTableNameList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String databaseName = req.getParameter("name");

		List<DBName> tableList = dblistService.getTableNameList(databaseName);
		if (tableList == null) {
			throw new RuntimeException("發生錯誤!無法取得資料表!");
		}
		req.setAttribute("tableList", tableList);
		req.getSession().setAttribute("databaseName", databaseName);
		req.getRequestDispatcher("/view/tableList.jsp").forward(req, resp);

	}

	/**
	 * 轉發給頁面資料表全部內容
	 */
	public void showTableData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tableName = req.getParameter("tableName");
		String dbName = (String) req.getSession().getAttribute("databaseName");
		List<List> tableDataList = dblistService.showTableData(dbName, tableName);

		req.getSession().setAttribute("tableName", tableName);
		req.getSession().setAttribute("tableDataList", tableDataList);
		req.getRequestDispatcher("/view/tabledata.jsp").forward(req, resp);
	}

	/**
	 * 取得用戶發送的SQL語句,傳送給serivce 轉發執行結果致頁面
	 */
	public void sqlCommands(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得用戶輸入的內容, 並重編編碼
		String str = req.getParameter("scp");
		byte[] bytes = str.getBytes("iso-8859-1");
		str = new String(bytes, "utf-8");

		//清空error內容
		req.getSession().removeAttribute("error");
		//清空queryList內容
		req.getSession().removeAttribute("queryList");
				
		//如果輸入為空
		if (str == null || str.trim().isEmpty()) {
			req.getSession().removeAttribute("queryList");
			req.getSession().setAttribute("error", "請輸入SQL語句");
			req.getRequestDispatcher("/view/console.jsp").forward(req, resp);
		}
		
		//去前後空格轉換小寫
		String sql = str.trim().toLowerCase();
		
		String[] split = sql.split(" ");

		/*
		 * 依照執行類型分發
		 */
		switch (split[0]) {
		case "use":
			useDatabase(req, resp, split[1]);
			break;

		case "create":
		case "alter":
		case "drop":
		case "truncate":
		case "insert":
		case "update":
		case "delete":
			query(req, resp, sql, false); // false非select語句,返回的是影響幾條數據
			break;
		case "select":
			query(req, resp, sql, true); // true是select語句,返回的是查詢結果
			break;

		}
	}

	private void query(HttpServletRequest req, HttpServletResponse resp, String sql, boolean isSelect) throws ServletException, IOException {
		String dbName = (String) req.getSession().getAttribute("databaseName");

		try {
			List<List> queryList = dblistService.query(dbName, sql, isSelect);
			req.getSession().setAttribute("queryList", queryList);
			req.getRequestDispatcher("/view/console.jsp").forward(req, resp);
		} catch (Exception e) {
			req.getSession().setAttribute("error", e.getMessage());
			req.getRequestDispatcher("/view/console.jsp").forward(req, resp);
		}
	}

	private void useDatabase(HttpServletRequest req, HttpServletResponse resp, String database) throws ServletException, IOException {
		try {
			String dbName = dblistService.useDatabase(database);
			req.getSession().setAttribute("databaseName", dbName);
			req.getSession().setAttribute("error", "Database changed : 進入" + dbName);
			req.getRequestDispatcher("/view/console.jsp").forward(req, resp);
		} catch (Exception e) {
			req.getSession().setAttribute("error", e.getMessage());
			req.getRequestDispatcher("/view/console.jsp").forward(req, resp);
			
		}
	}
}
