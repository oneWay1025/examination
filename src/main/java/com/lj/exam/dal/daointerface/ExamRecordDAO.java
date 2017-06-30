package com.lj.exam.dal.daointerface;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.lj.exam.dal.dataobject.ExamRecordDO;


public interface ExamRecordDAO {

    public List<ExamRecordDO> queryExamRecord(Map map) throws DataAccessException;

    public List<ExamRecordDO> queryByExamineeNum(Map map) throws DataAccessException;
    
    public int insert(ExamRecordDO examRecord) throws DataAccessException;
    
  	public int queryExamRecordTotal();
  	
  	public int queryTotalByExamineeNum(String examineeNum);
}