package com.junlon.common.base.page;

import java.io.Serializable;

public class PageParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer pageIndex; // 当前页数
	private Integer pageSize; // 每页记录数
	
	public PageParam(Integer pageIndex, Integer pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	/** 当前页数 */
	public Integer getPageIndex() {
		return pageIndex == null ? 0 : pageIndex;
	}

	/** 当前页数 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/** 每页记录数 */
	public Integer getPageSize() {
		return pageSize == null ? 10 : pageSize;
	}

	/** 每页记录数 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


}
