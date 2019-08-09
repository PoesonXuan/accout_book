package com.zp.xuan.controller.mobile.authen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.xuan.common.util.CommonParams;
import com.zp.xuan.common.util.ObjectUtils;
import com.zp.xuan.spring.scan.pojo.DbUser;
import com.zp.xuan.spring.scan.server.IUserServer;
import com.zp.xuan.util.json.IJsonInter;
import com.zp.xuan.util.json.JsonUtil;
import com.zp.xuan.util.json.impl.JsonImpl;

@RequestMapping("/mobile/authen")
@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private IUserServer userServer;
	
	@ResponseBody
	@RequestMapping("/loginOut")
	public Map<String, Object> loginout(HttpServletRequest request,HttpServletResponse response) {
		logger.info("进入loginout()");
		Map<String, Object> map = JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_success, "登录已过期，请重新登录！");
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public Map<String, Object> register(HttpServletRequest request,HttpServletResponse response) {
		
		logger.info("进入register()");
		
		DbUser dbUser = ObjectUtils.translateToDbUser(request);
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			logger.info("key:"+key+",value:"+map.get(key));
		}
		if(dbUser == null ) {
			return JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "必填字段为空");
		}
		try {
			dbUser.setLev("0");
			dbUser.setStatus("1");
			DbUser addUser = this.userServer.addUser(dbUser);
			if(addUser == null ) {
				logger.info("系统已存在该用户");
				return JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "系统已存在该用户");
			}else if(addUser.getId() == null || addUser.getId() == 0) {
				logger.info("注册失败");
				return JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "注册失败");
			}else {
				logger.info("注册成功");
				List<DbUser> ls= new ArrayList<>();
				ls.add(addUser);
				return JsonUtil.getMap(ls, JsonUtil.result_success, "");
			}
		} catch (Exception e) {
			logger.error("register()", e);
			return JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "系统已存在该用户");
		}
		
	}
	@ResponseBody
	@RequestMapping("/login")
	public Map<String, Object> login(HttpServletRequest request,HttpServletResponse response) {
		logger.info("进入login()");
		String loginName = request.getParameter("loginName");
		String passWord = request.getParameter("passWord");
		logger.info("loginName="+loginName+",passWord="+passWord);
		Map<String, Object> map = null;
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			DbUser login = userServer.login(loginName);
			logger.info("login="+login);
			
			if(login == null){
				map = JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "查询用户信息为空");
//				return "login";
			}else{
				if(passWord.equals(login.getPassword())) {
					request.getSession().setAttribute(CommonParams.COMMON_PARAM_CURRENT_USER, login);
					IJsonInter json = new JsonImpl(login);
					List data = new ArrayList<>();
					data.add(login);
					map = JsonUtil.getMap(data, JsonUtil.result_success, "");
					
				}else {
					map = JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "用户名密码错误");
				}
				
			}
		} catch (Exception e) {
			logger.error("login()", e);
		}
		
		
		return map;   
	}

	public IUserServer getUserServer() {
		return userServer;
	}

	public void setUserServer(IUserServer userServer) {
		this.userServer = userServer;
	}
}
