package com.lj.exam.dal.dataobject;

// auto generated imports
import java.util.Date;

/**
 * A data object class directly models database table <tt>student</tt>.
 *
 * This file is generated by <tt>financenet-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>iwallet</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/student.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>financenet-dalgen</tt> 
 * to generate this file.
 *
 */
public class StudentDO {
    
    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.
	 */
	private int id;

	/**
	 * This property corresponds to db column <tt>Examinee_Name</tt>.
	 */
	private String examineeName;

	/**
	 * This property corresponds to db column <tt>ExamineeID_Num</tt>.
	 */
	private String cardID;

	/**
	 * This property corresponds to db column <tt>Examinee_Num</tt>.
	 */
	private String examineeNum;

	/**
	 * This property corresponds to db column <tt>Creat_Time</tt>.
	 */
	private Date creatTime;

	/**
	 * This property corresponds to db column <tt>Contact</tt>.
	 */
	private String contact;

	/**
	 * This property corresponds to db column <tt>White_List</tt>.
	 */
	private String whiteList;

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

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(String whiteList) {
		this.whiteList = whiteList;
	}
	
}
