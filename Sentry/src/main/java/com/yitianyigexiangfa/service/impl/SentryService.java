package com.yitianyigexiangfa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yitianyigexiangfa.dao.ProgrammeDao;
import com.yitianyigexiangfa.model.Programme;
import com.yitianyigexiangfa.spider.LjswSpider;

@Service
public class SentryService {
	
	@Autowired
	private LjswSpider ljsw;
	@Autowired
	private ProgrammeDao programmeDao;
	
	
	// spider here
	public Programme getLjsw(){
		return ljsw.getNewestLjsw();
	}
	
	// email here
	public void sendEmail(){
		System.out.println("发送一封邮件");
	}
	
	// timer task here
	
	// crud
	public void addProgramme(Programme pro){
		programmeDao.insertProgramme(pro);
	}
	
	public List<Programme> getProgrammeByPrimaryKey(int vol){
		return programmeDao.getProgrammeByPrimaryKey(vol);
	}
	
}
