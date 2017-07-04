package com.lj.exam.dal.daointerface;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.lj.exam.dal.dataobject.ExamSiteDO;

public interface ExamSiteDAO {

    public List<ExamSiteDO> queryExamSite() throws DataAccessException;
    
    public ExamSiteDO queryByExamSiteCode(String examSiteCode) throws DataAccessException;

}