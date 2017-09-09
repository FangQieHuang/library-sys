package com.library.utils;

import java.util.List;

/**
 * 
 * @ClassName Page
 * @Description 分页查询 返回utils
 * @author 黄洁芳
 * @date 2017年6月19日
 */
public class Page {
	
	//当前页信息列表
	private List<?> itemList;
	//总记录数
	private int totalCount;
	//总页数
	private int pageCount;
	//当前页
	private int pageNum;
	
	public Page(List<?> itemList, int totalCount, int pageCount, int pageNum) {
		super();
		this.itemList = itemList;
		this.totalCount = totalCount;
		this.pageCount = pageCount;
		this.pageNum = pageNum;
	}
	public List<?> getItemList() {
		return itemList;
	}
	public void setItemList(List<?> itemList) {
		this.itemList = itemList;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	
	
}
