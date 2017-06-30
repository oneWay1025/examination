package com.lj.exam.restclient;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lj.exam.model.ExamRoom;
import com.lj.exam.model.ExamRoomResp;
import com.lj.exam.service.ExamRoomService;

@Controller
@RequestMapping("/ExamRoomInfoRest")
public class ExamRoomInfoRest {

	@Autowired
	private ExamRoomService examRoomService;

	@RequestMapping("/examRoomInfo" )  
    @ResponseBody
    public ExamRoomResp<ExamRoom> queryExamRoomInfoByExamRoomCode(@RequestParam Map jsonParam) {
    	
		String examineRoomCode = (String) jsonParam.get("examineRoomCode");
    	ExamRoomResp<ExamRoom> res = examRoomService.queryExamRoomByExamineRoomCode(examineRoomCode);
        
        return res;  
    }
    
    
    @RequestMapping("/examRoomInfoList")  
    @ResponseBody
    public ExamRoomResp<List<ExamRoom>> queryExamRoomInfoList() {
    	ExamRoomResp<List<ExamRoom>> res = examRoomService.queryAllExamRoom();
        return res;  
    }  
  
}