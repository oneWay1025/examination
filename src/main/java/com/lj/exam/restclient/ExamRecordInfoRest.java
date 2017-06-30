package com.lj.exam.restclient;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@Autowired
	private ExamRecordService examRecordService;

	@RequestMapping("/examRecordInfo" )  
    @ResponseBody
    public ExamRecordResp<List<ExamRecord>> queryExamRecordInfoByExamRecordCode(@RequestParam Map jsonParam) {
    	
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
    public String insertExamRecord(@RequestParam String param){
    	
    	JSONObject jo=new JSONObject(); 
    	Map<String, Object> map=(Map<String, Object> )jo.parse(param); //string转map  
    	System.out.println(map);   
    	
    	ExamRecord examRecord = new ExamRecord();
    	examRecord.setExamineRoomCode((String)map.get("examineRoomCode"));
    	examRecord.setCourseCode((String)map.get("courseCode"));
    	examRecord.setCourseSubCode((String)map.get("courseSubCode"));
    	examRecord.setExamineeNum((String)map.get("examineeNum"));
    	examRecord.setExamineeName((String)map.get("examineeName"));
    	examRecord.setScore((String)map.get("score"));
    	examRecord.setVideo((String)map.get("video"));
    	examRecord.setFile((String)map.get("file"));
		
    	ExamRecordResp<ExamRecord> res = examRecordService.insertExamRecord(examRecord);
    	
    	return "ok";  
    }
}
