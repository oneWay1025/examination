package com.lj.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lj.exam.dal.daointerface.ExamRoomDAO;
import com.lj.exam.dal.dataobject.ExamRoomDO;
import com.lj.exam.model.ExamRoom;
import com.lj.exam.model.ExamRoomResp;
import com.lj.exam.service.ExamRoomService;

public class ExamRoomServiceImpl implements ExamRoomService{
	
	@Autowired
	private ExamRoomDAO examRoomMapper;

	public ExamRoomResp<ExamRoom> queryExamRoomByExamineRoomCode(String examineRoomCode) {
		if(examineRoomCode == null)
			new ExamRoomResp("9999","查询考场表，考场编号为空");
		ExamRoomDO examRoomDO = examRoomMapper.queryByExamineRoomCode(examineRoomCode);
		ExamRoomResp<ExamRoom> res = new ExamRoomResp<ExamRoom>();
		ExamRoom examRoom = new ExamRoom();
		examRoom = po2Vo(examRoomDO);
		res.setBody(examRoom);
		res.setCode("0000");
		res.setMsg("查询成功");
		return res;
	}

	public ExamRoomResp<List<ExamRoom>> queryAllExamRoom() {
		List<ExamRoomDO> examRoomDOList = examRoomMapper.queryExamRoom();
		ExamRoomResp<List<ExamRoom>> res = new ExamRoomResp<List<ExamRoom>>();
		List<ExamRoom> examRoomList = new ArrayList<ExamRoom>();
		for(ExamRoomDO examRoomDO: examRoomDOList){
			ExamRoom examRoom = new ExamRoom();
			examRoom = po2Vo(examRoomDO);
			examRoomList.add(examRoom);
		}
		res.setBody(examRoomList);
		res.setCode("0000");
		res.setMsg("查询成功");
		return res;
	}
	
	private ExamRoom  po2Vo(ExamRoomDO examRoomDO){
		if(examRoomDO == null)
			return null;
		ExamRoom examRoom = new ExamRoom();
		examRoom.setId(examRoomDO.getId());
		examRoom.setProvince(examRoomDO.getProvince());
		examRoom.setCity(examRoomDO.getCity());
		examRoom.setDistrict(examRoomDO.getDistrict());
		examRoom.setExamineRoomName(examRoomDO.getExamineRoomName());
		examRoom.setExamineRoomCode(examRoomDO.getExamineRoomCode());
		examRoom.setInvigilatorName(examRoomDO.getInvigilatorName());
		examRoom.setInvigilatorTel(examRoomDO.getInvigilatorTel());
		return examRoom;
	}

}
