package com.lj.exam.service;

import java.util.List;
import com.lj.exam.model.ExamRecordBatch;
import com.lj.exam.model.ExamRecordBatchReq;
import com.lj.exam.model.ExamRecordBatchResp;




public interface ExamRecordBatchService {
	
	
	//查询信息
	public ExamRecordBatchResp<List<ExamRecordBatch>> 
		queryAllExamRecordBatch(ExamRecordBatchReq examRecordBatchReq);
		
	//插入信息
	public ExamRecordBatchResp<ExamRecordBatch> insertExamRecordBatch(ExamRecordBatch examRecordBatch);	
		
	//查询信息
		public ExamRecordBatchResp<List<ExamRecordBatch>> 
			queryExamRecordBatchByExamineeName(ExamRecordBatchReq<ExamRecordBatch> examRecordBatchReq);
    
}
