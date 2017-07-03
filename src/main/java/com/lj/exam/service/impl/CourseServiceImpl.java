package com.lj.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.lj.exam.dal.daointerface.CourseDAO;
import com.lj.exam.dal.dataobject.CourseDO;
import com.lj.exam.model.Course;
import com.lj.exam.model.CourseResp;
import com.lj.exam.service.CourseService;

public class CourseServiceImpl implements CourseService{

	private final static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Autowired
	private CourseDAO courseMapper;
	
	public CourseResp<Course> queryCourseByCourseCode(String courseCode) {
		if(courseCode == null)
			new CourseResp("9999","查询科目表，科目编号为空");
		logger.info("courseCode:" + courseCode);
		CourseResp<Course> res = new CourseResp<Course>();
		try {
			CourseDO courseDO = courseMapper.queryByCourseCode(courseCode);
			Course course = po2Vo(courseDO);
			res = new CourseResp<Course>();

			res.setBody(course);
			res.setCode("0000");
			res.setMsg("查询成功");
		} catch (DataAccessException e) {
			e.printStackTrace();
			res.setCode("9999");
			res.setMsg("系统错误");
		}
		return res;
	}
	
	public CourseResp<List<Course>> queryAllCourse() {
		CourseResp<List<Course>> res = new CourseResp<List<Course>>();
		List<Course> courseList = new ArrayList<Course>();
		
		try {
			List<CourseDO> courseDOList = courseMapper.queryCourse();
			for(CourseDO courseDO: courseDOList){
				Course course = new Course();
				course = po2Vo(courseDO);
				courseList.add(course);
			}
			res.setBody(courseList);
			res.setCode("0000");
			res.setMsg("查询成功");
		} catch (DataAccessException e) {
			e.printStackTrace();
			res.setCode("9999");
			res.setMsg("系统错误");
		}
		return res;
	}
	
	private Course  po2Vo(CourseDO courseDO){
		if(courseDO == null)
			return null;
		Course course = new Course();
		course.setId(courseDO.getId());
		course.setCourseTitle(courseDO.getCourseTitle());
		course.setCourseCode(courseDO.getCourseCode());
		course.setCourseClass(courseDO.getCourseClass());
		course.setCourseSubCode(courseDO.getCourseSubCode());
		course.setExamDate(courseDO.getExamDate());
		course.setStartTime(courseDO.getStartTime());
		course.setEndTime(courseDO.getEndTime());
		return course;
	}
}
