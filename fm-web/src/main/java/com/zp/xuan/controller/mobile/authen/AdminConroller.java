package com.zp.xuan.controller.mobile.authen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.xuan.common.util.ObjectUtils;
import com.zp.xuan.spring.scan.pojo.DbUser;
import com.zp.xuan.spring.scan.server.IUserServer;
import com.zp.xuan.util.json.JsonUtil;

@RequestMapping("/mobile/admin")
@Controller
public class AdminConroller {
	private static final Logger logger = Logger.getLogger(AdminConroller.class);
	
	@Autowired
	private IUserServer userServer;
	
	@ResponseBody
	@RequestMapping("/addUser")
	public Map<String,Object> addUser(HttpServletRequest request,HttpServletResponse response){
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
	@RequestMapping("/queryUser")
	public Map<String,Object> queryUser(HttpServletRequest request){
		logger.info("进入queryUser()");
		Map<String, Object> map = new HashMap<String, Object>();
		String nickName = request.getParameter("nickName");
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		int pageNum =1;
		int pageSize=6;
		try {
			logger.info("pageNum:"+pageNumStr);
			logger.info("pageSize:"+pageSizeStr);
			if(pageNumStr != null && !"".equals(pageNumStr) ) {
				pageNum = Integer.parseInt(pageNumStr);
			}
			if(pageSizeStr != null && !"".equals(pageSizeStr) ) {
				pageSize = Integer.parseInt(pageSizeStr);
			}
			List<DbUser> dbUsers = userServer.findUserByLoginName(nickName,pageNum,pageSize);
			map = JsonUtil.getMap(dbUsers == null ? new ArrayList<>():dbUsers, JsonUtil.result_success, "");
		} catch (Exception e) {
			logger.error("queryUser()", e);
			map = JsonUtil.getMap(new ArrayList<>(), JsonUtil.result_error, "查询异常");
		}
		
		return map;
		
	}
	
	
}
