package com.zp.xuan.spring.scan.server;

import com.zp.xuan.spring.scan.pojo.DbIobill;

public interface IIobillServer {
	DbIobill addIobill(DbIobill dbIobill)throws Exception;
	DbIobill updateIobill(DbIobill dbIobill)throws Exception;
}
