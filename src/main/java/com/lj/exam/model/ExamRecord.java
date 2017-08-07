package com.lj.exam.model;

import java.util.Date;

public class ExamRecord {
	
	private int id;
	
	private Date createTime;

	private String examSiteCode;

	private String courseCode;

	private String courseSubCode;

	private String examineeNum;

	private String examineeName;

	private String examSiteSeat;
	
	private String batchNo;
	
	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getExamSiteSeat() {
		return examSiteSeat;
	}

	public void setExamSiteSeat(String examSiteSeat) {
		this.examSiteSeat = examSiteSeat;
	}
	
	private Double videoScore;
	
	private Double fileScore;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	private String video;

	private String file;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date creatTime) {
		this.createTime = creatTime;
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

	public String getExamineeNum() {
		return examineeNum;
	}

	public void setExamineeNum(String examineeNum) {
		this.examineeNum = examineeNum;
	}

	public String getExamineeName() {
		return examineeName;
	}

	public void setExamineeName(String examineeName) {
		this.examineeName = examineeName;
	}

	public Double getVideoScore() {
		return videoScore;
	}

	public void setVideoScore(Double videoScore) {
		this.videoScore = videoScore;
	}

	public Double getFileScore() {
		return fileScore;
	}

	public void setFileScore(Double fileScore) {
		this.fileScore = fileScore;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
}
