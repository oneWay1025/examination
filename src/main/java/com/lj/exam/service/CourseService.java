package com.lj.exam.service;

import java.util.List;

import com.lj.exam.model.Course;
import com.lj.exam.model.CourseResp;

public interface CourseService {

	//根据科目编号查询科目
	public CourseResp<Course> queryCourseByCourseCode(String courseCode);
	
	//查询所有科目
	public CourseResp<List<Course>> queryAllCourse();
}
