package com.lj.exam.model;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
	
	private int id;

	private String courseTitle;

	private String courseCode;

	private String courseClass;

	private String courseSubCode;

	private String examDate;

	private Date startTime;

	private Date endTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}

	public String getCourseSubCode() {
		return courseSubCode;
	}

	public void setCourseSubCode(String courseSubCode) {
		this.courseSubCode = courseSubCode;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
