package com.lj.exam.dal.dataobject;

import java.util.Date;

public class ExamRecordBatchDO {
	
	private int id;
	
	//考场编号
	private String examSiteCode;
	
	//科目编号
	private String courseCode;
	
	//子科目编号
	private String courseSubCode;
	
	//考生姓名
	private String examineeName;
	
	//视频路径
	private String video;
	
	//创建时间
	private Date createTime;
	
	//批次号
	private String batchNo;
	
	//考试时间
	private String examTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExamSiteCode() {
		return examSiteCode;
	}

	public void setExamSiteCode(String examSiteCode) {
		this.examSiteCode = examSiteCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseSubCode() {
		return courseSubCode;
	}

	public void setCourseSubCode(String courseSubCode) {
		this.courseSubCode = courseSubCode;
	}

	public String getExamineeName() {
		return examineeName;
	}

	public void setExamineeName(String examineeName) {
		this.examineeName = examineeName;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

}
