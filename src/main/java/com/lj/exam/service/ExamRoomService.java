package com.lj.exam.service;

import java.util.List;

import com.lj.exam.model.ExamRoom;
import com.lj.exam.model.ExamRoomResp;

public interface ExamRoomService {

	//根据科目编号查询科目
	public ExamRoomResp<ExamRoom> queryExamRoomByExamineRoomCode(String examineRoomCode);
	
	//查询所有科目
	public ExamRoomResp<List<ExamRoom>> queryAllExamRoom();
}
