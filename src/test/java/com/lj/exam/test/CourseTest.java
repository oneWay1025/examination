package com.lj.exam.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.exam.dal.daointerface.CourseDAO;
import com.lj.exam.dal.dataobject.CourseDO;
import com.lj.exam.model.Course;
import com.lj.exam.model.CourseResp;
import com.lj.exam.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/*.xml")
public class CourseTest {
	
	@Autowired
	private CourseDAO courseMapper;
	
	@Autowired
	private CourseService courseService;
	
	@Test
	public void test(){
		System.out.println("test....");
//		CourseDO course = new CourseDO();
//		course.setCourseClass("张三");
		List<CourseDO> res = courseMapper.queryCourse();
		System.out.println("编号:" + res.get(0).getCourseCode());
	}
	
	@Test
	public void testQueryByCourseCode(){
		String courseCode = "2211";
		CourseDO course = courseMapper.queryByCourseCode(courseCode);
		System.out.println("code="+course.getCourseClass());
	}
	
	@Test
	public void testService(){
		System.out.println("testService....");
		CourseResp<List<Course>> res = courseService.queryAllCourse();
		System.out.println("编号:" + res.getCode());
	}
	
	@Test
	public void testQueryCourseByCourseCode(){
		System.out.println("testService....");
		String courseCode =  "1231231";
		CourseResp<Course> res = courseService.queryCourseByCourseCode(courseCode);
		System.out.println("编号:" + res.getCode());
	}
}
