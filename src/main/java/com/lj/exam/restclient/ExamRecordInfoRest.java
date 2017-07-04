package com.lj.exam.restclient;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lj.exam.model.ExamRecord;
import com.lj.exam.model.ExamRecordReq;
import com.lj.exam.model.ExamRecordResp;
import com.lj.exam.service.ExamRecordService;

@Controller
@RequestMapping("/ExamRecordInfoRest")
public class ExamRecordInfoRest {

	private final static Logger logger = LoggerFactory.getLogger(ExamRecordInfoRest.class);
	
	@Autowired
	private ExamRecordService examRecordService;

	@RequestMapping("/examRecordInfo" )  
    @ResponseBody
    public ExamRecordResp<List<ExamRecord>> queryExamRecordInfoByExamRecordCode(@RequestParam Map jsonParam) {
		logger.info("查询考试成绩  请求：{}" + JSONObject.toJSONString(jsonParam));
		ExamRecord examRecord = new ExamRecord();
		String examineeNum = (String) jsonParam.get("examineeNum");
		examRecord.setExamineeNum(examineeNum);
		
		String page = "1";
		if(null!=jsonParam.get("page")){
			page = (String) jsonParam.get("page");
		}
		
		String pageSize = "10";
		if(null!=jsonParam.get("pageSize")){
			pageSize = (String) jsonParam.get("pageSize");
		}
		
		ExamRecordReq examRecordReq = new ExamRecordReq();
		examRecordReq.setPage(Integer.valueOf(page));
		examRecordReq.setPageSize(Integer.valueOf(pageSize));
		examRecordReq.setBody(examRecord);
		
		
    	ExamRecordResp<List<ExamRecord>> res = examRecordService.queryExamRecordByExamineeNum(examRecordReq);
        
        return res;  
    }
    
    
    @RequestMapping("/examRecordInfoList")  
    @ResponseBody
    public ExamRecordResp<List<ExamRecord>> queryExamRecordInfoList(@RequestParam Map jsonParam) {
    	logger.info("查询全部考试成绩  请求：{}" + JSONObject.toJSONString(jsonParam));
		String page = "1";
		if(null!=jsonParam.get("page")){
			page = (String) jsonParam.get("page");
		}
		
		String pageSize = "10";
		if(null!=jsonParam.get("pageSize")){
			pageSize = (String) jsonParam.get("pageSize");
		}
		
		ExamRecordReq examRecordReq = new ExamRecordReq();
		examRecordReq.setPage(Integer.valueOf(page));
		examRecordReq.setPageSize(Integer.valueOf(pageSize));
		
    	ExamRecordResp<List<ExamRecord>> res = examRecordService.queryAllExamRecord(examRecordReq);
        return res;  
    }  
  
    
    @RequestMapping(value = "/insertExamRecord", method = {RequestMethod.POST}) 
    @ResponseBody
    public String insertExamRecord(@RequestBody ExamRecord param){
    	logger.info("插入考试成绩  请求：{}" + JSONObject.toJSONString(param));
    	
    	ExamRecord examRecord = new ExamRecord();
    	examRecord.setExamSiteCode(param.getExamSiteCode());
    	examRecord.setCourseCode(param.getCourseCode());
    	examRecord.setCourseSubCode(param.getCourseSubCode());
    	examRecord.setExamineeNum(param.getExamineeNum());
    	examRecord.setExamineeName(param.getExamineeName());
    	examRecord.setScore(param.getScore());
    	examRecord.setVideo(param.getVideo());
    	examRecord.setFile(param.getFile());
		
    	ExamRecordResp<ExamRecord> res = examRecordService.insertExamRecord(examRecord);
    	
    	return "ok";  
    }
    
}
