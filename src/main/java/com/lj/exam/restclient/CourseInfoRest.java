package com.lj.exam.restclient;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lj.exam.model.Course;
import com.lj.exam.model.CourseResp;
import com.lj.exam.service.CourseService;

@Controller
@RequestMapping("/CourseInfoRest")
public class CourseInfoRest {

	private final static Logger logger = LoggerFactory.getLogger(CourseInfoRest.class);
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/courseInfo" )  
    @ResponseBody
    public CourseResp<Course> queryCourseInfoByCourseCode(@RequestParam Map jsonParam) {
		logger.info("查询科目  请求：{}" + JSONObject.toJSONString(jsonParam));
		String courseCode = (String) jsonParam.get("courseCode");
    	CourseResp<Course> res = courseService.queryCourseByCourseCode(courseCode);
        
        return res;  
    }
    
    
    @RequestMapping("/courseInfoList")  
    @ResponseBody
    public CourseResp<List<Course>> queryCourseInfoList() {
    	logger.info("查询全部科目  请求");
    	CourseResp<List<Course>> res = courseService.queryAllCourse();
        return res;  
    }  
  
}
