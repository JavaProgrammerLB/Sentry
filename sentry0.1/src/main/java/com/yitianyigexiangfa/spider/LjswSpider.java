package com.yitianyigexiangfa.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import com.yitianyigexiangfa.model.Content;

@Repository
public class LjswSpider {
	
	public Content getNewestLjsw(){
		System.out.println("start here");
		Map<String, Content> no2url = new HashMap<String, Content>();
		List<String> nolist = null;
		try {
			Document doc = Jsoup.connect("http://i.youku.com/u/UNTEzNTY1OTgw").get();
			// Get the video-list block
//			Elements elements = doc.getElementsByClass("video-list");
			Elements elements = doc.getElementsByClass("YK-box");
			// Verify the size of elements
			if (elements != null && elements.size() > 0){				
				// Get the only element
				Element fourth = elements.get(0);
				// Get the links in fourth
				Elements links = fourth.getElementsByClass("v-link");
				// Verify the size of these links num
				if (links != null && links.size() > 0){
					// iterator these links
					for (int i = 0; i < links.size(); i ++){
						// get a link
						Element link = links.get(i);
						// get the <a>
						Element aTage = link.select("a[title]").get(0);
						// get the title
						String title = aTage.attr("title");
						System.out.println("title:" + title);
						// get the href
						String href = aTage.attr("href");
						System.out.println("href:" + href);
						// get the position of "No."
						int pos = title.indexOf("No.");
						// get the Number
						String no = title.substring(pos);
						// 
						Content con = new Content();
						con.setTitle(title);
						con.setUrl(href);
						no2url.put(no, con);
					}
					// get all keys：numbers
					nolist = new ArrayList<String>(no2url.keySet());
					Collections.sort(nolist);
					System.out.println(nolist);
					// the news url
					System.out.println("The newest NO is: " + nolist.get(nolist.size() - 1) +  ". The newest url is:" + no2url.get(nolist.get(nolist.size() - 1)));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(nolist == null || nolist.size() == 0 || no2url == null || no2url.size() == 0) return null;
		else{
			String no = nolist.get(nolist.size() - 1);
			Content con = no2url.get(no);
			return con;
		}
	}
}
