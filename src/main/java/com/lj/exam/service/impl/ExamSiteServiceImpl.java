package com.lj.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lj.exam.dal.daointerface.ExamSiteDAO;
import com.lj.exam.dal.dataobject.ExamSiteDO;
import com.lj.exam.model.ExamSite;
import com.lj.exam.model.ExamSiteResp;
import com.lj.exam.service.ExamSiteService;

public class ExamSiteServiceImpl implements ExamSiteService{
	
	@Autowired
	private ExamSiteDAO examSiteMapper;

	public ExamSiteResp<ExamSite> queryExamSiteByExamSiteCode(String examSiteCode) {
		if(examSiteCode == null)
			new ExamSiteResp("9999","查询考场表，考场编号为空");
		ExamSiteDO examSiteDO = examSiteMapper.queryByExamSiteCode(examSiteCode);
		ExamSiteResp<ExamSite> res = new ExamSiteResp<ExamSite>();
		ExamSite examSite = new ExamSite();
		examSite = po2Vo(examSiteDO);
		res.setBody(examSite);
		res.setCode("0000");
		res.setMsg("查询成功");
		return res;
	}

	public ExamSiteResp<List<ExamSite>> queryAllExamSite() {
		List<ExamSiteDO> examSiteDOList = examSiteMapper.queryExamSite();
		ExamSiteResp<List<ExamSite>> res = new ExamSiteResp<List<ExamSite>>();
		List<ExamSite> examSiteList = new ArrayList<ExamSite>();
		for(ExamSiteDO examSiteDO: examSiteDOList){
			ExamSite examSite = new ExamSite();
			examSite = po2Vo(examSiteDO);
			examSiteList.add(examSite);
		}
		res.setBody(examSiteList);
		res.setCode("0000");
		res.setMsg("查询成功");
		return res;
	}
	
	private ExamSite  po2Vo(ExamSiteDO examSiteDO){
		if(examSiteDO == null)
			return null;
		ExamSite examSite = new ExamSite();
		examSite.setId(examSiteDO.getId());
		examSite.setProvince(examSiteDO.getProvince());
		examSite.setCity(examSiteDO.getCity());
		examSite.setDistrict(examSiteDO.getDistrict());
		examSite.setExamSiteName(examSiteDO.getExamSiteName());
		examSite.setExamSiteCode(examSiteDO.getExamSiteCode());
		examSite.setExamSiteSeat(examSiteDO.getExamSiteSeat());
		examSite.setInvigilatorName(examSiteDO.getInvigilatorName());
		examSite.setInvigilatorTel(examSiteDO.getInvigilatorTel());
		examSite.setExamAddress(examSiteDO.getExamAddress());
		examSite.setCompanyName(examSiteDO.getCompanyName());
		return examSite;
	}

}
