package com.yitianyigexiangfa.config;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yitianyigexiangfa.model.Content;
import com.yitianyigexiangfa.service.impl.SentryService;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

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
			List<Content> cons = new ArrayList<Content>();
			Content con = service.getLjsw();
			cons.add(con);
			map.put("contents", cons);
			return new ModelAndView(map, "index.ftl");
		}, new FreeMarkerEngine());
	}
}
