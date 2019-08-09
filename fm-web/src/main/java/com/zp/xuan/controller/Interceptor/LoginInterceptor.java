package com.zp.xuan.controller.Interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zp.xuan.common.util.CommonParams;
import com.zp.xuan.util.json.JsonUtil;

import net.sf.json.JSONObject;

public class LoginInterceptor implements HandlerInterceptor {

	// private static Logger logger =
	// LoggerFactory.getLogger(LoginInterceptor.class);
	private static final Logger logger = Logger.getLogger(LoginInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception arg3)
			throws Exception {
		logger.info("LoginInterceptor.afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
			ModelAndView modelAndView) throws Exception {
		logger.info("LoginInterceptor.postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {
		logger.info("LoginInterceptor.preHandle");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		/*try {
			Object attribute = request.getSession().getAttribute(CommonParams.COMMON_PARAM_CURRENT_USER);
			if (attribute == null) {
				logger.info("用户认证信息为空！！！");
				Map<String, Object> map = JsonUtil.getMap(new ArrayList<>(), CommonParams.COMMON_PARAM_NO_LOGIN_INFO, "用户名未登录！！！");
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
		}*/
		return true;
	}
}
