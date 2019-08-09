package com.zp.xuan.controller.mobile.authen;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.xuan.spring.scan.pojo.DbGoods;
import com.zp.xuan.spring.scan.server.IGoodsServer;
import com.zp.xuan.spring.scan.server.impl.UserServerImpl;

@RequestMapping("/mobile/goods")
@Controller
public class GoodsController {

	private static final Logger logger = Logger.getLogger(GoodsController.class);
	@Autowired
	private IGoodsServer goodsServer;
	@ResponseBody
	@RequestMapping("/addGoods")
	public Map<String,Object> addGoods()  {
		logger.info("进入addGoods()");
		return null;
	}
}
