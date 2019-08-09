package com.zp.xuan.controller.web.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.xuan.controller.web.authen.Authenticate;

@RequestMapping("/web/pages")
@Controller
public class PagesController {
	private static final Logger logger = Logger.getLogger(PagesController.class);
	
	private static String[] headers = new String[] {
		"姓名","性别","年龄","类别","登录账号","电话","邮箱","账号状态"
	};

	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page,HttpServletRequest request){
		logger.info("toPage()");
		request.setAttribute("title", "用户信息");
		putData( request);
		return "pages/"+page;
	}
	
	private void putData(HttpServletRequest request) {

		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < headers.length; i++) {
			String header = headers[i];
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("title", header);
			list.add(m);
		}
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("title", "操作");
		list.add(map1);
		List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 100; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", "姓名_"+i);
			map.put("sex", "性别_"+i);
			map.put("age", "年龄_"+i);
			map.put("type", "类别_"+i);
			map.put("account", "登录账号_"+i);
			map.put("tele", "电话_"+i);
			map.put("mail", "邮箱_"+i);
			map.put("status", "账号状态_"+i);
			map.put("id", "ID_"+i);
			datas.add(map);
		}
		logger.info("list="+list);
		logger.info("datas="+datas);
		request.setAttribute("list", list);
		request.setAttribute("datas", datas);
	}
}
