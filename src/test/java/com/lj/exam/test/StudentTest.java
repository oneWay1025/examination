package com.lj.exam.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.exam.dal.daointerface.StudentDAO;
import com.lj.exam.dal.dataobject.StudentDO;
import com.lj.exam.model.Student;
import com.lj.exam.model.StudentReq;
import com.lj.exam.model.StudentResp;
import com.lj.exam.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/*.xml")
public class StudentTest {
	
	@Autowired
	private StudentDAO studentMapper;
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void test(){
		System.out.println("test....");
		Map map =new HashMap();
		map.put("startNum", 1);
		map.put("endNum", 5);
		List<StudentDO> res = studentMapper.queryStudent(map);
		System.out.println("编号:" + res.get(0).getCardID());
	}
	
	@Test
	public void testQuery(){
		String examineeNum = "eqqwewq1";
		StudentDO student = studentMapper.queryByExamineeNum(examineeNum);
		System.out.println("student="+student);
	}
	
	@Test
	public void testService(){
		System.out.println("testService....");
		StudentReq studentReq = new StudentReq();
		StudentResp<List<Student>> res = studentService.queryAllStudent(studentReq);
		System.out.println("编号:" + res.getTotalNum() + "," + res.getTotalPage());
	}
}
