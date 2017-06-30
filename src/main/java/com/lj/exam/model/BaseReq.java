package com.lj.exam.model;

public class BaseReq {

	/** 目前的页数 */
	private int page = 1;

	/** 每页显示条目数 */
	private int pageSize = 10;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
