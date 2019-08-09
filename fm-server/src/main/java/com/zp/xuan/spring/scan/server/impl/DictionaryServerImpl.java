package com.zp.xuan.spring.scan.server.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.zp.xuan.spring.scan.mapper.DbDictionaryMapper;
import com.zp.xuan.spring.scan.pojo.DbDictionary;
import com.zp.xuan.spring.scan.pojo.DbDictionaryExample;
import com.zp.xuan.spring.scan.pojo.DbDictionaryExample.Criteria;
import com.zp.xuan.spring.scan.server.IDictionaryServer;

public class DictionaryServerImpl implements IDictionaryServer {

	private static final Logger logger = Logger.getLogger(DictionaryServerImpl.class);
	
	@Autowired
	private DbDictionaryMapper dbDictionaryMapper;
	
	public List<DbDictionary> getDbDictionaryByTableAndAttribute(String table, String attribute) throws Exception {
		logger.info("getDbDictionaryByTableAndAttribute()");
	
		return getDbDictionaryByTableAndAttributeAndValue(table, attribute, "");
		
	}

	public List<DbDictionary> getDbDictionaryByTableAndAttributeAndValue(String table, String attribute, String value)
			throws Exception {
		logger.info("getDbDictionaryByTableAndAttributeAndValue()");
		
		DbDictionaryExample example = new DbDictionaryExample();
		
		Criteria createCriteria = example.createCriteria();
		if(value != null && !"".equals(value)) {
			createCriteria.andValueEqualTo(value);
		}
		createCriteria.andAttributeEqualTo(attribute.toUpperCase());
		createCriteria.andTablenameEqualTo(table.toUpperCase());
		List<DbDictionary>  datas = dbDictionaryMapper.selectByExample(example);
		
		return datas;
	}

}
