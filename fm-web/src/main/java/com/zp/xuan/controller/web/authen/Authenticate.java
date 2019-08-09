package com.zp.xuan.controller.web.authen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.xuan.common.util.CommonParams;
import com.zp.xuan.controller.web.MainPage;
import com.zp.xuan.spring.scan.pojo.DbUser;
import com.zp.xuan.spring.scan.server.IUserServer;

@RequestMapping("/web/authen")
@Controller
public class Authenticate {

	private static final Logger logger = Logger.getLogger(Authenticate.class);
	
	@Autowired
	private IUserServer userServer;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		String loginName = request.getParameter("loginName");
		String passWord = request.getParameter("passWord");
		logger.info("loginName="+loginName+",passWord="+passWord);
		
		try {
			DbUser login = userServer.login(loginName);
			logger.info("login="+login);
			
			if(login == null){
				request.setAttribute(CommonParams.COMMON_PARAM_LOGIN_INFO, "填写账户信息不正确！！！");
				return "login";
			}else if("0".equals(login.getLev())) {
				if(passWord.equals(login.getPassword())) {
					request.getSession().setAttribute(CommonParams.COMMON_PARAM_CURRENT_USER, login);
					return "admin/admin";
				}else {
					request.setAttribute(CommonParams.COMMON_PARAM_LOGIN_INFO, "用户名或密码错误！！！");
					return "login";
				}
			}else {
				if(passWord.equals(login.getPassword())) {
					request.getSession().setAttribute(CommonParams.COMMON_PARAM_CURRENT_USER, login);
					return "index";
				}else {
					request.setAttribute(CommonParams.COMMON_PARAM_LOGIN_INFO, "用户名或密码错误！！！");
					return "login";
				}
				
			}
			
		} catch (Exception e) {
			logger.error("login()", e);
		}
		return "login";   
	}

	public IUserServer getUserServer() {
		return userServer;
	}

	public void setUserServer(IUserServer userServer) {
		this.userServer = userServer;
	}
}
