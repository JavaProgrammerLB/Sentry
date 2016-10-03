package com.yitianyigexiangfa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yitianyigexiangfa.model.Content;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerTest {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		try {
			String path = new File("").getAbsolutePath();
			config.setDirectoryForTemplateLoading(new File(path));
			Template template = config.getTemplate("src/main/resources/freemarker/index.ftl", "UTF-8");
			// 创建数据模型
			Map map = new HashMap();
			List<Content> cons = new ArrayList<Content>();
			Content con = new Content();
			con.setTitle("Vol.148商人这个物种");
			con.setUrl("http://www.baidu.com");
			cons.add(con);
			Content con2 = new Content();
			con2.setTitle("Vol.148商人这个物种");
			con2.setUrl("http://www.baidu.com");
			cons.add(con2);
			Content con3 = new Content();
			con3.setTitle("Vol.148商人这个物种");
			con3.setUrl("http://www.baidu.com");
			cons.add(con3);
			Content con4 = new Content();
			con4.setTitle("Vol.148商人这个物种");
			con4.setUrl("http://www.baidu.com");
			cons.add(con4);
			map.put("contents", cons);
			File file = new File(path + "//src//main//resources//freemarker//liubei.html");
			if(!file.exists()){  
                //System.out.println("file exist");  
                file.createNewFile();  
            }  
            Writer out = new BufferedWriter(new FileWriter(file));  
            template.process(map, out);  
            System.out.println("done");
            out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	}

}
