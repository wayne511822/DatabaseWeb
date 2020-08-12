package com.databaseweb.dao;

import java.util.List;

/**
 * 用來封裝分頁訊息
 * @author wayne
 *
 * @param <T>
 */
public class PageBean<T> {

	private int pc; //頁碼page code
	//private int tp; //總頁數total page(通過計算來,不直接給值)
	private int tr; //總計路數total record
	private int ps; //每頁紀錄數page size
	private List<T> beanList; //當前頁紀錄
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getTp() {
		int tp = tr / ps;
		return tr % ps ==0 ? tp : tp + 1; //不能整除的還要多一頁
	}
//	public void setTp(int tp) {
//		this.tp = tp;
//	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
}
