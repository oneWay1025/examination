package com.lj.exam.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.exam.dal.daointerface.ExamRecordDAO;
import com.lj.exam.dal.dataobject.ExamRecordDO;
import com.lj.exam.model.ExamRecord;
import com.lj.exam.model.ExamRecordReq;
import com.lj.exam.model.ExamRecordResp;
import com.lj.exam.service.ExamRecordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/*.xml")
public class ExamRecordTest {
	
	@Autowired
	private ExamRecordDAO examRecordMapper;
	
	@Autowired
	private ExamRecordService examRecordService;
	
	@Test
	public void test(){
		System.out.println("test....");
		Map map =new HashMap();
		List<ExamRecordDO> res = examRecordMapper.queryExamRecord(map);
		System.out.println("编号:" + res.get(0).getCourseCode());
	}
	
	@Test
	public void testQuery(){
		String examineeNum = "12313";
		Map map=new HashMap();
		List<ExamRecordDO> examRecordList = examRecordMapper.queryByExamineeNum(map);
		System.out.println("ExamRecordDO="+examRecordList.get(1));
	}
	
	@Test
	public void testInsert(){
		ExamRecordDO examRecordDO  = new ExamRecordDO();
		examRecordDO.setExamineRoomCode("2321");
		examRecordDO.setExamineeNum("123132");
		examRecordDO.setExamineeName("131aqd1q");
		examRecordDO.setFile("qweqeq1");
		examRecordDO.setVideo("dqeqw1we");
		examRecordDO.setScore(11L);
		examRecordDO.setCourseCode("qeq1eqdada");
		examRecordDO.setCourseSubCode("12311dewq");
		int res = examRecordMapper.insert(examRecordDO);
		System.out.println("ExamRecordDO="+res);
	}
	
	@Test
	public void testQueryAllExamRecord(){
		System.out.println("testService....");
		ExamRecordReq examRecordReq = new ExamRecordReq();
		examRecordReq.setPageSize(1);
		ExamRecordResp<List<ExamRecord>> res = examRecordService.queryAllExamRecord(examRecordReq);
		System.out.println("编号:" + res.getTotalNum() + "," + res.getTotalPage());
	}
	
	@Test
	public void testQueryExamRecordByExamineeNum(){
		System.out.println("testService....");
		ExamRecordReq<ExamRecord> examRecordReq = new ExamRecordReq<ExamRecord>();
		examRecordReq.setPageSize(1);
		ExamRecord examRecord =new ExamRecord();
		examRecord.setExamineeNum("12313");
		examRecordReq.setBody(examRecord);
		
		ExamRecordResp<List<ExamRecord>> res = examRecordService.queryExamRecordByExamineeNum(examRecordReq);
		System.out.println("编号:" + res.getTotalNum() + "," + res.getTotalPage());
	}
}
