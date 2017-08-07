package com.lj.exam.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.lj.exam.dal.daointerface.ExamRecordBatchDAO;
import com.lj.exam.dal.dataobject.ExamRecordBatchDO;
import com.lj.exam.model.ExamRecordBatch;
import com.lj.exam.model.ExamRecordBatchReq;
import com.lj.exam.model.ExamRecordBatchResp;
import com.lj.exam.service.ExamRecordBatchService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/*.xml")
public class ExamRecordBatchTest {
	@Autowired
	private ExamRecordBatchDAO examRecordBatchMapper;
	
	@Autowired
	private ExamRecordBatchService examRecordBatchService;
	@Test
	public void testInsert(){
		ExamRecordBatchDO examRecordBatchDO  = new ExamRecordBatchDO();
		examRecordBatchDO.setExamSiteCode("2da321");
		examRecordBatchDO.setExamineeName("131dad1q");
		examRecordBatchDO.setVideo("dqeqwds1we");
		examRecordBatchDO.setExamTime("20171111");
		examRecordBatchDO.setCourseCode("qeq1da");
		examRecordBatchDO.setCourseSubCode("12dewq");
		int res = examRecordBatchMapper.insert(examRecordBatchDO);
		System.out.println("ExamRecordBatchDO="+res);
	}
	
	@Test
	public void testQueryAllExamRecordBatch(){
		System.out.println("testService....");
		ExamRecordBatchReq examRecordBatchReq = new ExamRecordBatchReq();
		examRecordBatchReq.setPageSize(3);
		ExamRecordBatchResp<List<ExamRecordBatch>> res = examRecordBatchService.queryAllExamRecordBatch(examRecordBatchReq);
		System.out.println("编号:" + res.getTotalNum() + "," + res.getTotalPage());
	}
	
	@Test
	public void testQueryExamRecordBatchByExamineeName(){
		System.out.println("testService....");
		ExamRecordBatchReq<ExamRecordBatch> examRecordBatchReq = new ExamRecordBatchReq<ExamRecordBatch>();
		examRecordBatchReq.setPageSize(1);
		ExamRecordBatch examRecord =new ExamRecordBatch();
		examRecord.setExamineeName("131dad1q");
		examRecordBatchReq.setBody(examRecord);
		
		ExamRecordBatchResp<List<ExamRecordBatch>> res = examRecordBatchService.queryExamRecordBatchByExamineeName(examRecordBatchReq);
		System.out.println("编号:" + res.getTotalNum() + "," + res.getTotalPage());
	}
	

}
