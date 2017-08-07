package com.lj.exam.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lj.exam.model.ExamRecordBatch;
import com.lj.exam.model.ExamRecordBatchResp;
import com.lj.exam.model.ExamRecordResp;
import com.lj.exam.service.ExamRecordBatchService;


@Controller
@RequestMapping("/ExamRecordInfoRest")
public class ExamRecordBatchInfoRest {
	
private final static Logger logger = LoggerFactory.getLogger(ExamRecordInfoRest.class);
	
	@Autowired
	private ExamRecordBatchService examRecordBatchService;
	
	
	 @RequestMapping(value = "/insertExamRecordBatch", method = {RequestMethod.POST}) 
	 @ResponseBody
	 public String insertExamRecordBatch(@RequestBody ExamRecordBatch param){
    	logger.info("插入考试成绩  请求：{}" + JSONObject.toJSONString(param));
    	
    	ExamRecordBatch examRecordBatch = new ExamRecordBatch();
    	examRecordBatch.setExamSiteCode(param.getExamSiteCode());
    	examRecordBatch.setCourseCode(param.getCourseCode());
    	examRecordBatch.setCourseSubCode(param.getCourseSubCode());
    	examRecordBatch.setExamineeName(param.getExamineeName());
    	examRecordBatch.setVideo(param.getVideo());
        examRecordBatch.setExamTime(param.getExamTime());
    	examRecordBatch.setBatchNo(param.getBatchNo());
		
    	ExamRecordBatchResp<ExamRecordBatch> res = examRecordBatchService.insertExamRecordBatch(examRecordBatch);
    	if(res.getMsg().equals("插入成功")){
    	    return "ok";
    	}else{
    		return "no";
    	}
	    	
	    }
	    

}
