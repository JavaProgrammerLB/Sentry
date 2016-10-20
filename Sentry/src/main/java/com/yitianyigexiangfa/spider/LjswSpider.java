package com.yitianyigexiangfa.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yitianyigexiangfa.dao.ProgrammeDao;
import com.yitianyigexiangfa.model.Programme;

@Repository
public class LjswSpider {
	@Autowired
	ProgrammeDao proDao;
	
	public Programme getNewestLjsw(){
		Map<String, Programme> no2pro = new HashMap<String, Programme>();
		List<String> nolist = null;
		try {
			Document doc = Jsoup.connect("http://i.youku.com/u/UNTEzNTY1OTgw").get();
//			Elements elements = doc.getElementsByClass("video-list");
			Elements elements = doc.getElementsByClass("YK-box");
			if (elements != null && elements.size() > 0){				
				Element fourth = elements.get(0);
				Elements links = fourth.getElementsByClass("v-link");
				if (links != null && links.size() > 0){
					for (int i = 0; i < links.size(); i ++){
						Element link = links.get(i);
						Element aTage = link.select("a[title]").get(0);
						String title = aTage.attr("title");
						String href = aTage.attr("href");
						String vol = title.substring(title.indexOf("No.") + 3);
						if(vol == null || "".equals(vol)) continue;
						Programme pro = new Programme();
						pro.setVol(Integer.parseInt(vol));
						pro.setTitle(title);
						pro.setUrl(href);
						pro.setSdate(new Date());
						no2pro.put(vol, pro);
					}
					nolist = new ArrayList<String>(no2pro.keySet());
					Collections.sort(nolist);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(nolist == null || nolist.size() == 0 || no2pro == null || no2pro.size() == 0) return null;
		else{
			String no = nolist.get(nolist.size() - 1);
			return no2pro.get(no);
		}
	}
}
