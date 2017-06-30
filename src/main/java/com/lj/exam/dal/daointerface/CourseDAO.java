package com.lj.exam.dal.daointerface;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.lj.exam.dal.dataobject.CourseDO;

public interface CourseDAO {

    public List<CourseDO> queryCourse() throws DataAccessException;
    
    public CourseDO queryByCourseCode(String courseCode) throws DataAccessException;

}