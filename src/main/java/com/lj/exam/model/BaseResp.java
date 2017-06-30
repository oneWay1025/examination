package com.lj.exam.model;

public class BaseResp {

	/** 总共的页数 */
	private int totalPage;

	/** 总共有多少记录 */
	private int totalNum;

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

}
