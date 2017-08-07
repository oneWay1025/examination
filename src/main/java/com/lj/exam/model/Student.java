package com.lj.exam.model;

import java.util.Date;

public class Student {
	
	private int id;

	private String examineeName;

	private String cardID;

	private String examineeNum;

	private Date createTime;

	private String contact;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExamineeName() {
		return examineeName;
	}

	public void setExamineeName(String examineeName) {
		this.examineeName = examineeName;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getExamineeNum() {
		return examineeNum;
	}

	public void setExamineeNum(String examineeNum) {
		this.examineeNum = examineeNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date creatTime) {
		this.createTime = creatTime;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
