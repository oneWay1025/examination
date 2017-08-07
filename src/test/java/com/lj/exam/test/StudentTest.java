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

import ch.qos.logback.core.net.SyslogOutputStream;

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
	//插入学生信息
	public void testInsert(){
		StudentDO student = new StudentDO();
		student.setCardID("353");
		student.setContact("bbb");
		student.setExamineeName("li");
		student.setExamineeNum("12346");
		int res = studentMapper.insert(student);
		if(res==1){
		    System.out.println("成功");
		}else{
			System.out.println("shibai");
		}
	}
	@Test
	public void testServiceInsert(){
		System.out.println("Service测试");
		Student stu = new Student();
		stu.setCardID("23456");
		stu.setContact("abc");
		stu.setExamineeName("张三");
		stu.setExamineeNum("778899");
		StudentResp res  =studentService.insertStudent(stu);
		System.out.println("编号:"+res.getMsg()+","+res.getCode());
	}
	@Test
	public void testService(){
		System.out.println("testService....");
		StudentReq studentReq = new StudentReq();
		StudentResp<List<Student>> res = studentService.queryAllStudent(studentReq);
		System.out.println("编号:" + res.getTotalNum() + "," + res.getTotalPage());
	}
}
