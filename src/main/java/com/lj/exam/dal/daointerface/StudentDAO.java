package com.lj.exam.dal.daointerface;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.lj.exam.dal.dataobject.StudentDO;

public interface StudentDAO {

    public List<StudentDO> queryStudent(Map map) throws DataAccessException;
    
    public StudentDO queryByExamineeNum(String examineeNum) throws DataAccessException;
    
    public int queryStudentTotal() throws DataAccessException;

}