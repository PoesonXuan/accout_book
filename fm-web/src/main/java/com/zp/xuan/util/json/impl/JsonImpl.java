package com.zp.xuan.util.json.impl;

import com.zp.xuan.spring.scan.pojo.DbUser;
import com.zp.xuan.util.json.IJsonInter;

import net.sf.json.JSONObject;

public class JsonImpl implements IJsonInter {
	private Object object;

	public JsonImpl( ) {
		 
	}
	
	public JsonImpl(Object dbUser) {
		super();
		this.object = dbUser;
	}

	@Override
	public void setObj(Object obj) {
		this.object = obj;
	}

	@Override
	public Object getObj() {
		return this.object;
	}

	@Override
	public String fromObjToJson() {
		JSONObject json = JSONObject.fromObject(this.object);
		return json.toString();
	}

	@Override
	public Object fromJsonToObj() {
		return null;
	}

	
}
