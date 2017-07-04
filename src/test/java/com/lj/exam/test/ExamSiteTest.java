package com.lj.exam.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lj.exam.dal.daointerface.ExamSiteDAO;
import com.lj.exam.dal.dataobject.ExamSiteDO;
import com.lj.exam.model.ExamSite;
import com.lj.exam.model.ExamSiteResp;
import com.lj.exam.service.ExamSiteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/*.xml")
public class ExamSiteTest {
	
	@Autowired
	private ExamSiteDAO examSiteMapper;
	
	@Autowired
	private ExamSiteService examSiteService;
	
	@Test
	public void test(){
		System.out.println("test....");
//		ExamSiteDO examSite = new ExamSiteDO();
//		examSite.setExamineSiteName("张三");
		List<ExamSiteDO> res = examSiteMapper.queryExamSite();
		System.out.println("编号:" + res.get(0).getCity());
	}
	
	@Test
	public void testQuery(){
		String examSiteCode = "31231";
		ExamSiteDO examSiteList = examSiteMapper.queryByExamSiteCode(examSiteCode);
		System.out.println("examSiteList="+examSiteList);
	}
	
	@Test
	public void testService(){
		System.out.println("testService....");
		ExamSiteResp<List<ExamSite>> res = examSiteService.queryAllExamSite();
		System.out.println("编号:" + res.getBody().get(0).getDistrict());
	}
}
