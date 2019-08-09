package com.zp.xuan.spring.scan.server;

import java.util.List;

import com.zp.xuan.spring.scan.pojo.DbDictionary;

public interface IDictionaryServer {
	List<DbDictionary> getDbDictionaryByTableAndAttribute(String table,String attribute) throws Exception;
	List<DbDictionary> getDbDictionaryByTableAndAttributeAndValue(String table,String attribute,String value) throws Exception;
}
