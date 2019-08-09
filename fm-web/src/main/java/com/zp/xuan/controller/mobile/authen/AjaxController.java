package com.zp.xuan.controller.mobile.authen;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.xuan.spring.scan.pojo.DbUser;
import com.zp.xuan.spring.scan.server.IUserServer;
import com.zp.xuan.util.json.JsonUtil;

@RequestMapping("/mobile/ajax")
@Controller
public class AjaxController {

	private static final Logger logger = Logger.getLogger(AjaxController.class);
	
	@Autowired
	private IUserServer userServer;
	
	@ResponseBody
	@RequestMapping("/{loginName}")
	public Map<String, Object> getUserCountByLoginName(@PathVariable String loginName) {
		logger.info("进人getUserCountByLoginName()");
		Map<String, Object> map;
		try {
			DbUser login = userServer.login(loginName);
			if(login != null ) {
				return JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "");
			}else {
				return JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_success, "");
			}
		} catch (Exception e) {
			logger.error("getUserCountByLoginName()", e);
			return JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "");
		}
		
	}
}
