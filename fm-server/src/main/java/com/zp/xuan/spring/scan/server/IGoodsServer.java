package com.zp.xuan.spring.scan.server;

import java.util.List;

import com.zp.xuan.spring.scan.pojo.DbGoods;
import com.zp.xuan.spring.scan.pojo.DbUser;

public interface IGoodsServer {

	DbGoods addGoods(DbGoods dbGoods)throws Exception;
	DbGoods updateGoods(DbGoods dbGoods)throws Exception;
	List<DbGoods> findGoodsByName(String name)throws Exception;
}
