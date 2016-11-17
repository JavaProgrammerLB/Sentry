package com.yitianyigexiangfa.config;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import com.yitianyigexiangfa.model.Programme;
import com.yitianyigexiangfa.model.User;
import com.yitianyigexiangfa.service.impl.SentryService;

public class WebConfig {
	private SentryService service;

	public WebConfig(SentryService service) {
		this.service = service;
		staticFileLocation("/public");
		setupRoutes();
	}
	
	private void setupRoutes(){
		get("/",(req, res) -> {
			res.redirect("/refresh");
			return null;
		});
		
		get("/refresh",(req, res) -> {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Programme> pros = new ArrayList<Programme>();
			Programme pro = service.getLjsw();
			// chenck new or old
			int vol = pro.getVol();
			List<Programme> prolist = service.getProgrammeByPrimaryKey(vol);
			if(prolist != null && prolist.size() == 0){
				// insert into database
				service.addProgramme(pro);
				// send email
				User user = new User();
				user.setEmail("to@gmail.com");
				user.setName("username");
				service.sendEmail(user, pro);
			}
			pros.add(pro);
			map.put("contents", pros);
			return new ModelAndView(map, "index.ftl");
		}, new FreeMarkerEngine());
		
		get("/createuser",(req,res) -> {
			
			return null;
		});
	}
}
