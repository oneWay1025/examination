package com.lj.exam.restclient;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lj.exam.model.Student;
import com.lj.exam.model.StudentReq;
import com.lj.exam.model.StudentResp;
import com.lj.exam.service.StudentService;

@Controller
@RequestMapping("/StudentInfoRest")
public class StudentInfoRest {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/studentInfo")  
    @ResponseBody
    public StudentResp<Student> queryStudentByExamineeNum(@RequestParam Map jsonParam) {
    	
		String examineeNum = (String) jsonParam.get("examineeNum");
		StudentResp<Student> res = studentService.queryStudentByExamineeNum(examineeNum);
        
        return res;  
    }
    
    
    @RequestMapping("/studentInfoList")  
    @ResponseBody
    public StudentResp<List<Student>> queryStudentInfoList(@RequestParam Map jsonParam) {
		
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
  
}
