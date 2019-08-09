package com.zp.xuan.controller.Interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zp.xuan.common.util.CommonParams;
import com.zp.xuan.spring.scan.pojo.DbUser;
import com.zp.xuan.spring.scan.server.IUserServer;
import com.zp.xuan.util.json.JsonUtil;

import net.sf.json.JSONObject;

public class PermissionInterceptor implements HandlerInterceptor {

	private static final Logger logger = Logger.getLogger(PermissionInterceptor.class);
	
	@Autowired
	private IUserServer userServer;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		logger.info("PermissionInterceptor.afterCompletion()");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		logger.info("PermissionInterceptor.postHandle()");
//		logger.info(JSONObject.fromObject(arg3.getModelMap()).toString());
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		logger.info("preHandle()");
		String url = request.getRequestURI();
		DbUser dbUser = (com.zp.xuan.spring.scan.pojo.DbUser) request.getSession().getAttribute(CommonParams.COMMON_PARAM_CURRENT_USER);
		logger.info("请求的url："+url);
		return authorityCheck(url,dbUser,request,response);
	}

	private boolean authorityCheck(String url, DbUser dbUser,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		
		String userIdStr = request.getParameter("userId");
		
		
		PrintWriter out = null;
		DbUser dbUser1 = null;
		try {
			if(userIdStr != null && !"".equals(userIdStr)) {
				dbUser1 = userServer.getDbUserById(Long.parseLong(userIdStr));
			}
			if(dbUser1 == null ) {
				Map<String, Object> map = JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "该用户认证信息为空！！！");
				JSONObject.fromObject(map);
				out = response.getWriter();
				out.append(JSONObject.fromObject(map).toString());
				return false;
			}
			if(url.indexOf("mobile/admin") != -1 && !"99".equals(dbUser1.getLev()) ) {
				Map<String, Object> map = JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "该用户不具备此操作权限！！！");
				JSONObject.fromObject(map);
				out = response.getWriter();
				out.append(JSONObject.fromObject(map).toString());
				return false;
				
			}
		} catch (Exception e) {
			try {
				logger.error("preHandle()",e);
				response.sendError(500);
			} catch (IOException e1) {
				logger.error("preHandle()",e1);
			}
			return false;
		}finally {
			if(out != null) {
				out.close();
			}
		}
		return true;
	}
}
