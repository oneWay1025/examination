package com.lj.exam.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.exam.dal.daointerface.ExamRoomDAO;
import com.lj.exam.dal.dataobject.ExamRoomDO;
import com.lj.exam.model.ExamRoom;
import com.lj.exam.model.ExamRoomResp;
import com.lj.exam.service.ExamRoomService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/*.xml")
public class ExamRoomTest {
	
	@Autowired
	private ExamRoomDAO examRoomMapper;
	
	@Autowired
	private ExamRoomService examRoomService;
	
	@Test
	public void test(){
		System.out.println("test....");
//		ExamRoomDO examRoom = new ExamRoomDO();
//		examRoom.setExamineRoomName("张三");
		List<ExamRoomDO> res = examRoomMapper.queryExamRoom();
		System.out.println("编号:" + res.get(0).getCity());
	}
	
	@Test
	public void testQuery(){
		String examineRoomCode = "313";
		ExamRoomDO examRoomList = examRoomMapper.queryByExamineRoomCode(examineRoomCode);
		System.out.println("examRoomList="+examRoomList);
	}
	
	@Test
	public void testService(){
		System.out.println("testService....");
		ExamRoomResp<List<ExamRoom>> res = examRoomService.queryAllExamRoom();
		System.out.println("编号:" + res.getBody().get(0).getDistrict());
	}
}
