package com.yitianyigexiangfa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yitianyigexiangfa.config.WebConfig;
import com.yitianyigexiangfa.service.impl.SentryService;

@Configuration
@ComponentScan({"com.yitianyigexiangfa"})
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		new WebConfig(ctx.getBean(SentryService.class));
		ctx.registerShutdownHook();
	}

}
