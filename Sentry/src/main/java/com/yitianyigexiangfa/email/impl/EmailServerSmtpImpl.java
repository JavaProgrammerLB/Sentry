package com.yitianyigexiangfa.email.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Repository;

import com.yitianyigexiangfa.email.IEmailServer;
import com.yitianyigexiangfa.model.Programme;
import com.yitianyigexiangfa.model.User;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Repository
public class EmailServerSmtpImpl implements IEmailServer {
	// 邮箱用户名
	private String username = null;
	// 邮箱密码
	private String password = null; 

	@Override
	public void sendEmail(User user, Programme pro) {
		// 检查数据是否为空
		if(user == null || pro == null) return;
		// 创建获取邮箱数据的属性对象
		Properties cfgProps = new Properties();
		try {
			// 加载配置文件
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("config/cfg.properties");
			cfgProps.load(is);
			// 读取数据
			username = cfgProps.getProperty("email.server.username");
			password = cfgProps.getProperty("email.server.pass");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 创建用来构建会话的属性文件
		Properties props = new Properties();
		try {
			// 加载配置文件
			InputStream is = getClass().getClassLoader().getResourceAsStream("email/settings.properties");
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		});
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
			message.setSubject("哨兵有更新啦");
			// 创建内容体对象
			BodyPart body = new MimeBodyPart();
			// 创建Freemarker配置对象
			Configuration cfg = new Configuration();
			// 通过classLoader来定位文件位置
			cfg.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "email/template");
			// 获取文件
			Template template = cfg.getTemplate("emailTemplate.ftl");
			Map<String, String> rootMap = new HashMap<String, String>();
			rootMap.put("name", user.getName());
			rootMap.put("url", pro.getUrl());
//			rootMap.put("proname", pro.getName());
			Writer out = new StringWriter();
			template.process(rootMap, out);
			body.setContent(out.toString(), "text/html;charset=utf-8");
			// 创建内容对象
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(body);
			// 给信息对象设置值
			message.setContent(multipart, "text/html;charset=utf-8");
			// 
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		System.out.println("邮件发送成功");
	}
	

}
