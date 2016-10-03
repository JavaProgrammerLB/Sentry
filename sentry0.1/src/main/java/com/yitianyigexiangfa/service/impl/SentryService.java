package com.yitianyigexiangfa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yitianyigexiangfa.model.Content;
import com.yitianyigexiangfa.spider.LjswSpider;

@Service
public class SentryService {
	
	@Autowired
	private LjswSpider ljsw;
	
	public Content getLjsw(){
		return ljsw.getNewestLjsw();
	}
}
