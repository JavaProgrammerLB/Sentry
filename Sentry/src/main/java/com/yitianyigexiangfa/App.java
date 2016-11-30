package com.yitianyigexiangfa;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.yitianyigexiangfa.config.WebConfig;
import com.yitianyigexiangfa.service.impl.SentryService;

@Configuration
@ComponentScan({"com.yitianyigexiangfa"})
@EnableScheduling
public class App implements SchedulingConfigurer{

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		new WebConfig(ctx.getBean(SentryService.class));
		ctx.registerShutdownHook();
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// 
		taskRegistrar.setTaskScheduler(taskScheduler());
	}
	
	@Bean
	public TaskScheduler taskScheduler(){
		//
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		
		taskScheduler.setDaemon(true);
		
		return taskScheduler;
	}
	
	@Bean
	public ScheduledBean scheduledBean(){
		return new ScheduledBean();
	}
}

class ScheduledBean{
	@Scheduled(fixedRate=1000)
	void hell(){
		System.out.println("hello,liubei" + new Date());
	}
}
