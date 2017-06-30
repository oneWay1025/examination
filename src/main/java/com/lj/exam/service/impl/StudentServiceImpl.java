package com.lj.exam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lj.exam.dal.daointerface.StudentDAO;
import com.lj.exam.dal.dataobject.StudentDO;
import com.lj.exam.model.Student;
import com.lj.exam.model.StudentReq;
import com.lj.exam.model.StudentResp;
import com.lj.exam.service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentMapper;
	
	public StudentResp<Student> queryStudentByExamineeNum(String examineeNum) {
		if(examineeNum == null)
			new StudentResp("9999","查询考生表，考生编号为空");
		StudentDO studentDO = studentMapper.queryByExamineeNum(examineeNum);
		
		Student student = po2Vo(studentDO);
		StudentResp<Student> res = new StudentResp<Student>();
		res.setBody(student);
		res.setCode("0000");
		res.setMsg("查询成功");
		return res;
	}

	public StudentResp<List<Student>> queryAllStudent(StudentReq studentReq) {
		
		int pageSize = studentReq.getPageSize();
		int totalNum = studentMapper.queryStudentTotal();
		Map map=new HashMap();
		map.put("startNum", (studentReq.getPage()-1)*pageSize);
		map.put("endNum", pageSize);
		List<StudentDO> studentDOList = studentMapper.queryStudent(map);
		
		StudentResp<List<Student>> res = new StudentResp<List<Student>>();
		List<Student> studentList = new ArrayList<Student>();
		for(StudentDO studentDO: studentDOList){
			Student student = new Student();
			student = po2Vo(studentDO);
			studentList.add(student);
		}
		int totalPage = (totalNum-1)/pageSize  + 1;
		res.setTotalNum(totalNum);
		res.setTotalPage(totalPage);
		res.setBody(studentList);
		res.setCode("0000");
		res.setMsg("查询成功");
		return res;
	}

	private Student  po2Vo(StudentDO studentDO){
		if(studentDO == null)
			return null;
		Student student = new Student();
		student.setId(studentDO.getId());
		student.setExamineeName(studentDO.getExamineeName());
		student.setCardID(studentDO.getCardID());
		student.setExamineeNum(studentDO.getExamineeNum());
		student.setCreatTime(studentDO.getCreatTime());
		student.setContact(studentDO.getContact());
		student.setWhiteList(studentDO.getWhiteList());
		return student;
	}
}
