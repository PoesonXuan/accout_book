package com.zp.xuan.controller.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/web")
@Controller
public class MainPage {
	private static final Logger logger = Logger.getLogger(MainPage.class);
	@RequestMapping("/main")
	public String indexPage() {
		logger.info("indexPage()");
		return "index";
		
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		logger.info("loginPage()");
		return "login";
		
	}
}
