package com.lj.exam.restclient;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lj.exam.model.Student;
import com.lj.exam.model.StudentReq;
import com.lj.exam.model.StudentResp;
import com.lj.exam.service.StudentService;

@Controller
@RequestMapping("/StudentInfoRest")
public class StudentInfoRest {

	private final static Logger logger = LoggerFactory.getLogger(StudentInfoRest.class);
	
	@Autowired
	private StudentService studentService;

	@RequestMapping("/studentInfo")  
    @ResponseBody
    public StudentResp<Student> queryStudentByExamineeNum(@RequestParam Map jsonParam) {
    	
		logger.info("查询学生信息  请求：{}" + JSONObject.toJSONString(jsonParam));
		
		String examineeNum = (String) jsonParam.get("examineeNum");
		StudentResp<Student> res = studentService.queryStudentByExamineeNum(examineeNum);
        
        return res;  
    }
    
    
    @RequestMapping("/studentInfoList")  
    @ResponseBody
    public StudentResp<List<Student>> queryStudentInfoList(@RequestParam Map jsonParam) {
		
    	logger.info("查询全部学生信息  请求：{}" + JSONObject.toJSONString(jsonParam));
    	
		String page = "1";
		if(null!=jsonParam.get("page")){
			page = (String) jsonParam.get("page");
		}
		
		String pageSize = "10";
		if(null!=jsonParam.get("pageSize")){
			pageSize = (String) jsonParam.get("pageSize");
		}
		
		StudentReq studentReq = new StudentReq();
		studentReq.setPage(Integer.valueOf(page));
		studentReq.setPageSize(Integer.valueOf(pageSize));
		
    	StudentResp<List<Student>> res = studentService.queryAllStudent(studentReq);
        return res;  
    }  
    @RequestMapping(value="/insertStudentInfo" , method={RequestMethod.POST})
    @ResponseBody
    public String insertStudentInfo(@RequestBody Student param){
    	logger.info("插入学生信息  请求{}"+JSONObject.toJSONString(param));
    	Student stu = new Student();
    	stu.setCardID(param.getCardID());
    	stu.setContact(param.getContact());
    	stu.setExamineeName(param.getExamineeName());
    	stu.setExamineeNum(param.getExamineeNum());
    	StudentResp<Student> res = studentService.insertStudent(stu);
    	if(res.getMsg().equals("添加成功")){
    	    return "ok";
    	}else{
    		return "no";
    	}
    	
    }
  
}
