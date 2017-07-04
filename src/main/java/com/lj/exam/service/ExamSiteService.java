package com.lj.exam.service;

import java.util.List;

import com.lj.exam.model.ExamSite;
import com.lj.exam.model.ExamSiteResp;

public interface ExamSiteService {

	//根据科目编号查询科目
	public ExamSiteResp<ExamSite> queryExamSiteByExamSiteCode(String examSiteCode);
	
	//查询所有科目
	public ExamSiteResp<List<ExamSite>> queryAllExamSite();
}
