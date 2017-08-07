package com.lj.exam.service;

import java.util.List;


import com.lj.exam.model.Student;
import com.lj.exam.model.StudentReq;
import com.lj.exam.model.StudentResp;

public interface StudentService {
	
	//根据学生编号查询学生
	public StudentResp<Student> queryStudentByExamineeNum(String examineeNum);
	
	//查询所有学生
	public StudentResp<List<Student>> queryAllStudent(StudentReq studentReq);
	
	
	//添加学生信息
	public StudentResp<Student> insertStudent(Student student);
}
