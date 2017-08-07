package com.lj.exam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.lj.exam.dal.daointerface.ExamRecordBatchDAO;
import com.lj.exam.dal.dataobject.ExamRecordBatchDO;
import com.lj.exam.dal.dataobject.ExamRecordBatchDO;
import com.lj.exam.model.ExamRecordBatch;
import com.lj.exam.model.ExamRecordBatch;
import com.lj.exam.model.ExamRecordBatchReq;
import com.lj.exam.model.ExamRecordBatchResp;
import com.lj.exam.model.ExamRecordBatchResp;
import com.lj.exam.service.ExamRecordBatchService;

public class ExamRecordBatchServiceImpl implements ExamRecordBatchService{
	
    private final static Logger logger = LoggerFactory.getLogger(ExamRecordServiceImpl.class);
	
	@Autowired
	private ExamRecordBatchDAO  examRecordBatchMapper;

	@Override
	public ExamRecordBatchResp<List<ExamRecordBatch>> queryAllExamRecordBatch(ExamRecordBatchReq examRecordBatchReq) {
		
		int pageSize = examRecordBatchReq.getPageSize();
		int totalNum = examRecordBatchMapper.queryExamRecordBatchTotal();
		Map map=new HashMap();
		map.put("startNum", (examRecordBatchReq.getPage()-1)*pageSize);
		map.put("endNum", pageSize);
		List<ExamRecordBatchDO> examRecordBatchDOList = examRecordBatchMapper.queryExamRecordBatch(map);
		
		
		ExamRecordBatchResp<List<ExamRecordBatch>> res = new ExamRecordBatchResp<List<ExamRecordBatch>>();
		List<ExamRecordBatch> examRecordList = new ArrayList<ExamRecordBatch>();
		for(ExamRecordBatchDO examRecordDO: examRecordBatchDOList){
			ExamRecordBatch examRecord = new ExamRecordBatch();
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
	

	@Override
	public ExamRecordBatchResp<ExamRecordBatch> insertExamRecordBatch(ExamRecordBatch examRecordBatch) {
		ExamRecordBatchResp<ExamRecordBatch> res = new ExamRecordBatchResp<ExamRecordBatch>();
		ExamRecordBatchDO examRecordBatchDO = new ExamRecordBatchDO();
		examRecordBatchDO.setExamSiteCode(examRecordBatchDO.getExamSiteCode());
		examRecordBatchDO.setCourseCode(examRecordBatchDO.getCourseCode());
		examRecordBatchDO.setCourseSubCode(examRecordBatchDO.getCourseSubCode());
		examRecordBatchDO.setExamineeName(examRecordBatchDO.getExamineeName());
		examRecordBatchDO.setVideo(examRecordBatchDO.getVideo());
		examRecordBatchDO.setExamTime(examRecordBatchDO.getExamTime());
		examRecordBatchDO.setBatchNo(examRecordBatchDO.getBatchNo());
		int resp = examRecordBatchMapper.insert(examRecordBatchDO);
		if(resp == 1){
			res.setBody(examRecordBatch);
			res.setCode("0000");
			res.setMsg("插入成功");
		} else{
			res.setCode("9999");
			res.setMsg("插入失败");
		}
		return res;
	}
	
	


	@Override
	public ExamRecordBatchResp<List<ExamRecordBatch>> queryExamRecordBatchByExamineeName(
			ExamRecordBatchReq<ExamRecordBatch> examRecordBatchReq) {
		if(null==examRecordBatchReq.getBody() || null == examRecordBatchReq.getBody().getExamineeName())
			new ExamRecordBatchResp("9999","查询科目表，科目编号为空");
		
		logger.info("examRecordBatchReq:" + examRecordBatchReq);
		String examineeName = examRecordBatchReq.getBody().getExamineeName();
		int pageSize = examRecordBatchReq.getPageSize();
		int totalNum = examRecordBatchMapper.queryExamRecordBatchTotal();
		Map map=new HashMap();
		map.put("startNum", (examRecordBatchReq.getPage()-1)*pageSize);
		map.put("endNum", pageSize);
		map.put("examineeName", examineeName);
		List<ExamRecordBatchDO> examRecordBatchDOList = examRecordBatchMapper.queryByExamineeName(map);
		
		ExamRecordBatchResp<List<ExamRecordBatch>> res = new ExamRecordBatchResp<List<ExamRecordBatch>>();
		List<ExamRecordBatch> examRecordBatchList = new ArrayList<ExamRecordBatch>();
		for(ExamRecordBatchDO examRecordBatchDO: examRecordBatchDOList){
			ExamRecordBatch examRecordBatch = new ExamRecordBatch();
			examRecordBatch = po2Vo(examRecordBatchDO);
			examRecordBatchList.add(examRecordBatch);
		}
		
		int totalPage = (totalNum-1)/pageSize  + 1;
		res.setTotalNum(totalNum);
		res.setTotalPage(totalPage);
		res.setBody(examRecordBatchList);
		res.setCode("0000");
		res.setMsg("查询成功");
		return res;		
	}

	private ExamRecordBatch  po2Vo(ExamRecordBatchDO examRecordBatchDO){
		if(examRecordBatchDO == null)
			return null;
		ExamRecordBatch examRecordBatch = new ExamRecordBatch();
		examRecordBatch.setId(examRecordBatchDO.getId());
		examRecordBatch.setCreateTime(examRecordBatchDO.getCreateTime());
		examRecordBatch.setExamSiteCode(examRecordBatchDO.getExamSiteCode());
		examRecordBatch.setCourseCode(examRecordBatchDO.getCourseCode());
		examRecordBatch.setCourseSubCode(examRecordBatchDO.getCourseSubCode());
		examRecordBatch.setExamTime(examRecordBatchDO.getExamTime());
		examRecordBatch.setExamineeName(examRecordBatchDO.getExamineeName());
		examRecordBatch.setVideo(examRecordBatchDO.getVideo());
		examRecordBatch.setBatchNo(examRecordBatchDO.getBatchNo());
		return examRecordBatch;
	}
}
