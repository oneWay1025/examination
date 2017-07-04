package com.lj.exam.restclient;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lj.exam.model.ExamSite;
import com.lj.exam.model.ExamSiteResp;
import com.lj.exam.service.ExamSiteService;

@Controller
@RequestMapping("/ExamSiteInfoRest")
public class ExamSiteInfoRest {
	
	private final static Logger logger = LoggerFactory.getLogger(ExamSiteInfoRest.class);
	
	@Autowired
	private ExamSiteService examSiteService;

	@RequestMapping("/examSiteInfo" )  
    @ResponseBody
    public ExamSiteResp<ExamSite> queryExamSiteInfoByExamSiteCode(@RequestParam Map jsonParam) {
    	
		logger.info("查询考场  请求：{}" + JSONObject.toJSONString(jsonParam));
		String examSiteCode = (String) jsonParam.get("examSiteCode");
    	ExamSiteResp<ExamSite> res = examSiteService.queryExamSiteByExamSiteCode(examSiteCode);
        
        return res;  
    }
    
    
    @RequestMapping("/examSiteInfoList")  
    @ResponseBody
    public ExamSiteResp<List<ExamSite>> queryExamSiteInfoList() {
    	logger.info("查询全部考场  请求");
    	ExamSiteResp<List<ExamSite>> res = examSiteService.queryAllExamSite();
        return res;  
    }  
  
}
