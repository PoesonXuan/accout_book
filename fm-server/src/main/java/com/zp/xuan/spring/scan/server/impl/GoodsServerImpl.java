package com.zp.xuan.spring.scan.server.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.xuan.spring.scan.mapper.DbGoodsMapper;
import com.zp.xuan.spring.scan.pojo.DbGoods;
import com.zp.xuan.spring.scan.pojo.DbGoodsExample;
import com.zp.xuan.spring.scan.pojo.DbGoodsExample.Criteria;
import com.zp.xuan.spring.scan.server.IGoodsServer;

@Service
public class GoodsServerImpl implements IGoodsServer {

	private static final Logger logger = Logger.getLogger(UserServerImpl.class);
	
	@Autowired
	private DbGoodsMapper dbGoodsMapper;
	
	public DbGoods addGoods(DbGoods dbGoods) throws Exception {
		logger.info("addGoods()");
		List<DbGoods> dbGoods2 = getGoodsByName(dbGoods.getName());
		if(dbGoods2 != null && dbGoods2.size() >0 ) {
			return dbGoods;
		}else {
			dbGoodsMapper.insert(dbGoods);
			List<DbGoods> datas = getGoodsByName(dbGoods.getName());
			if(datas != null && datas.size() >0) {
				dbGoods.setId(datas.get(0).getId());
			}
		}
		return dbGoods;
	}

	public DbGoods updateGoods(DbGoods dbGoods) throws Exception {
		logger.info("updateGoods()");
		List<DbGoods> goodsByName = getGoodsByName(dbGoods.getName());
		if(goodsByName != null && goodsByName.size() >0) {
			dbGoods.setId(goodsByName.get(0).getId());
			dbGoodsMapper.updateByPrimaryKey(dbGoods);
		}
		
		return dbGoods;
	}

	public List<DbGoods> findGoodsByName(String name) throws Exception {
		logger.info("findGoodsByName()");
		
		DbGoodsExample example = new DbGoodsExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andNameLike("%"+name+"%");
		
		List<DbGoods> dbGoods = dbGoodsMapper.selectByExample(example);
		
		return dbGoods;
	}
	
	private List<DbGoods> getGoodsByName(String name) throws Exception {
		logger.info("getGoodsByName(),name = "+name);
		DbGoodsExample userExample = new DbGoodsExample();
		
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andNameEqualTo(name);
		
		List<DbGoods> dbGoods = dbGoodsMapper.selectByExample(userExample);
		logger.info("getGoodsByName(),dbGoods = "+dbGoods);
		if(dbGoods != null && dbGoods.size() >0) {
			logger.info("login(),dbUsers.size = "+dbGoods.size());
			return dbGoods;
		}
		logger.info("login(),获取用户信息失败");
		return null;
	}

}
