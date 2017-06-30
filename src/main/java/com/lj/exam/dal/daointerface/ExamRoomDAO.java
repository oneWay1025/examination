package com.lj.exam.dal.daointerface;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.lj.exam.dal.dataobject.ExamRoomDO;

public interface ExamRoomDAO {

    public List<ExamRoomDO> queryExamRoom() throws DataAccessException;
    
    public ExamRoomDO queryByExamineRoomCode(String examineRoomCode) throws DataAccessException;

}