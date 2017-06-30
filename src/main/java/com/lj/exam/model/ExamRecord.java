package com.lj.exam.model;

import java.util.Date;

public class ExamRecord {
	
	private int id;
	
	private Date creatTime;

	private String examineRoomCode;

	private String courseCode;

	private String courseSubCode;

	private String examineeNum;

	private String examineeName;

	private String score;

	private String video;

	private String file;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getExamineRoomCode() {
		return examineRoomCode;
	}

	public void setExamineRoomCode(String examineRoomCode) {
		this.examineRoomCode = examineRoomCode;
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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
