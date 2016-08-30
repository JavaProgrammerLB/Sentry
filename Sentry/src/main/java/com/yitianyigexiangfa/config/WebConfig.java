package com.yitianyigexiangfa.config;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class WebConfig {
	
	public WebConfig() {
		staticFileLocation("/");
		setupRoutes();
	}
	
	private void setupRoutes(){
		get("/", (req,res) -> {
			return new ModelAndView(null, "mastertemplate.ftl");
		}, new FreeMarkerEngine());
	}
}
