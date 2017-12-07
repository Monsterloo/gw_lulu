package com.junlon.common.base.page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PageBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// 指定的或是页面参数
	private int pageIndex; // 当前页
	private int pageSize; // 每页显示多少条

	// 查询数据库
	private int total; // 总记录数
	private List<Object> recordList; // 本页的数据列表

	// 计算
	private int pageCount; // 总页数
	
	private Map<String, Object> countResultMap; // 当前分页条件下的统计结果
	
	/**
	 * 
	 * @param pageIndex 当前页
	 * @param pageSize  每页显示的记录数
	 * @param total  总记录数
	 * @param recordList  本页的数据列表
	 * @param countResultMap  统计结果(如果有isCount的条件)
	 */
	public PageBean(int pageIndex, int pageSize, int total, List<Object> recordList, Map<String, Object> countResultMap) {

		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.total = total;
		this.recordList = recordList;
		this.countResultMap = countResultMap;

		// 计算总页码
		pageCount = (total + pageSize - 1) / pageSize;
	}

	public PageBean() {
		super();
	}



	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Object> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<Object> recordList) {
		this.recordList = recordList;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Map<String, Object> getCountResultMap() {
		return countResultMap;
	}

	public void setCountResultMap(Map<String, Object> countResultMap) {
		this.countResultMap = countResultMap;
	}
	
	
}
