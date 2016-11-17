package com.yitianyigexiangfa.email.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

import com.yitianyigexiangfa.email.EmailServer;
import com.yitianyigexiangfa.model.Programme;
import com.yitianyigexiangfa.model.User;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Repository
public class EmailServerSmtpImpl implements EmailServer {
	final String username = "bei.liu@fondalighting.com";
	final String password = "liubei@20150415";

	@Override
	public void sendEmail(User user, Programme pro) {
		// 检查数据是否为空
		if(user == null || pro == null) return;
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File("src/main/resources/email/settings.properties")));
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
			Configuration cfg = new Configuration();
			Template template = cfg.getTemplate("src/main/resources/email/template/emailTemplate.ftl");
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
