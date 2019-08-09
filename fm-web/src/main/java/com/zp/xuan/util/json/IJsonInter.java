package com.zp.xuan.util.json;

public interface IJsonInter {
	void setObj(Object obj);
	Object getObj();
	String fromObjToJson();
	Object fromJsonToObj();
}
