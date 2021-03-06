package com.lj.exam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lj.exam.dal.daointerface.ExamRecordDAO;
import com.lj.exam.dal.dataobject.ExamRecordDO;
import com.lj.exam.model.ExamRecord;
import com.lj.exam.model.ExamRecordReq;
import com.lj.exam.model.ExamRecordResp;
import com.lj.exam.service.ExamRecordService;

public class ExamRecordServiceImpl implements ExamRecordService{
	
	private final static Logger logger = LoggerFactory.getLogger(ExamRecordServiceImpl.class);
	
	@Autowired
	private ExamRecordDAO examRecordMapper;

	public ExamRecordResp<List<ExamRecord>> queryExamRecordByExamineeNum(ExamRecordReq<ExamRecord> examRecordReq) {
		if(null==examRecordReq.getBody() || null == examRecordReq.getBody().getExamineeNum() )
			new ExamRecordResp("9999","查询科目表，科目编号为空");
		
		logger.info("examRecordReq:" + examRecordReq);
		String examineeNum = examRecordReq.getBody().getExamineeNum();
		int pageSize = examRecordReq.getPageSize();
		int totalNum = examRecordMapper.queryTotalByExamineeNum(examineeNum);
		Map map=new HashMap();
		map.put("startNum", (examRecordReq.getPage()-1)*pageSize);
		map.put("endNum", pageSize);
		map.put("examineeNum", examineeNum);
		List<ExamRecordDO> examRecordDOList = examRecordMapper.queryByExamineeNum(map);
		
		ExamRecordResp<List<ExamRecord>> res = new ExamRecordResp<List<ExamRecord>>();
		List<ExamRecord> examRecordList = new ArrayList<ExamRecord>();
		for(ExamRecordDO examRecordDO: examRecordDOList){
			ExamRecord examRecord = new ExamRecord();
			examRecord = po2Vo(examRecordDO);
			examRecordList.add(examRecord);
		}
		
		int totalPage = (totalNum-1)/pageSize  + 1;
		res.setTotalNum(totalNum);
		res.setTotalPage(totalPage);
		res.setBody(examRecordList);
		res.setCode("0000");
		res.setMsg("查询成功");
		return res;
	}

	public ExamRecordResp<List<ExamRecord>> queryAllExamRecord(ExamRecordReq examRecordReq) {
		
		int pageSize = examRecordReq.getPageSize();
		int totalNum = examRecordMapper.queryExamRecordTotal();
		Map map=new HashMap();
		map.put("startNum", (examRecordReq.getPage()-1)*pageSize);
		map.put("endNum", pageSize);
		List<ExamRecordDO> examRecordDOList = examRecordMapper.queryExamRecord(map);
		
		
		ExamRecordResp<List<ExamRecord>> res = new ExamRecordResp<List<ExamRecord>>();
		List<ExamRecord> examRecordList = new ArrayList<ExamRecord>();
		for(ExamRecordDO examRecordDO: examRecordDOList){
			ExamRecord examRecord = new ExamRecord();
			examRecord = po2Vo(examRecordDO);
			examRecordList.add(examRecord);
		}
		
		int totalPage = (totalNum-1)/pageSize  + 1;
		res.setTotalNum(totalNum);
		res.setTotalPage(totalPage);
		res.setBody(examRecordList);
		res.setCode("0000");
		res.setMsg("查询成功");
		return res;
	}

	public ExamRecordResp<ExamRecord> insertExamRecord(ExamRecord examRecord) {
		
		ExamRecordResp<ExamRecord> res = new ExamRecordResp<ExamRecord>();
		ExamRecordDO examRecordDO = new ExamRecordDO();
		examRecordDO.setExamSiteCode(examRecord.getExamSiteCode());
		examRecordDO.setCourseCode(examRecord.getCourseCode());
		examRecordDO.setCourseSubCode(examRecord.getCourseSubCode());
		examRecordDO.setExamineeNum(examRecord.getExamineeNum());
		examRecordDO.setExamineeName(examRecord.getExamineeName());
		examRecordDO.setExamSiteSeat(examRecord.getExamSiteSeat());
		examRecordDO.setVideoScore(examRecord.getVideoScore());
		examRecordDO.setFileScore(examRecord.getFileScore());
		examRecordDO.setStatus("1");
		examRecordDO.setVideo(examRecord.getVideo());
		examRecordDO.setFile(examRecord.getFile());
		examRecordDO.setBatchNo(examRecord.getBatchNo());
		int resp = examRecordMapper.insert(examRecordDO);
		if(resp == 1){
			res.setBody(examRecord);
			res.setCode("0000");
			res.setMsg("插入成功");
		} else{
			res.setCode("9999");
			res.setMsg("插入失败");
		}
		return res;
	}
	
	public ExamRecordResp<ExamRecord> deleteByExamineeNumAndCourseCode(ExamRecord examRecord){
		ExamRecordResp<ExamRecord> res = new ExamRecordResp<ExamRecord>();
		ExamRecordDO examRecordDO = new ExamRecordDO();
		examRecordDO.setCourseCode(examRecord.getCourseCode());
		examRecordDO.setExamineeNum(examRecord.getExamineeNum());
		examRecordDO.setStatus("0");
		int resp = examRecordMapper.deleteByExamineeNumAndCourseCode(examRecordDO);
		if(resp == 1){
			res.setBody(examRecord);
			res.setCode("0000");
			res.setMsg("删除成功");
		} else{
			res.setCode("9999");
			res.setMsg("删除失败");
		}
		return res;
	}
	
	private ExamRecord  po2Vo(ExamRecordDO examRecordDO){
		if(examRecordDO == null)
			return null;
		ExamRecord examRecord = new ExamRecord();
		examRecord.setId(examRecordDO.getId());
		examRecord.setCreateTime(examRecordDO.getCreateTime());
		examRecord.setExamSiteCode(examRecordDO.getExamSiteCode());
		examRecord.setCourseCode(examRecordDO.getCourseCode());
		examRecord.setCourseSubCode(examRecordDO.getCourseSubCode());
		examRecord.setExamineeNum(examRecordDO.getExamineeNum());
		examRecord.setExamineeName(examRecordDO.getExamineeName());
		examRecord.setVideoScore(examRecordDO.getVideoScore());
		examRecord.setFileScore(examRecordDO.getFileScore());
		examRecord.setStatus(examRecordDO.getStatus());
		examRecord.setVideo(examRecordDO.getVideo());
		examRecord.setFile(examRecordDO.getFile());
		return examRecord;
	}
}
