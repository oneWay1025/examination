package com.lj.exam.service;

import java.util.List;

import com.lj.exam.model.ExamRecord;
import com.lj.exam.model.ExamRecordReq;
import com.lj.exam.model.ExamRecordResp;

public interface ExamRecordService {

	//根据学生编号查询考试成绩
	public ExamRecordResp<List<ExamRecord>> 
			queryExamRecordByExamineeNum(ExamRecordReq<ExamRecord> examRecordReq);
	
	//查询所有考生成绩
	public ExamRecordResp<List<ExamRecord>> 
		queryAllExamRecord(ExamRecordReq examRecordReq);
	
	//插入考试成绩
	public ExamRecordResp<ExamRecord> insertExamRecord(ExamRecord examRecord);
	
}
