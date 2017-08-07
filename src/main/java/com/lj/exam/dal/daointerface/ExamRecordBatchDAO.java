package com.lj.exam.dal.daointerface;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.lj.exam.dal.dataobject.ExamRecordBatchDO;
import com.lj.exam.dal.dataobject.ExamRecordDO;

public interface ExamRecordBatchDAO {
	
	
	//全局查询
	public List<ExamRecordBatchDO> queryExamRecordBatch(Map map) throws DataAccessException;
	
	//添加信息
	public int insert(ExamRecordBatchDO examRecordBatchDO) throws DataAccessException;
	
	public int queryExamRecordBatchTotal();
	
	//按姓名查询
	public List<ExamRecordBatchDO> queryByExamineeName(Map map) throws DataAccessException;

}
