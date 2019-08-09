package com.zp.xuan.util.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {
	public static String result_success = "0";
	public static String result_error = "99";

	public static String getJson(String data,String result,String msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("{"
				+ "result:"+result+","
						+ "data:"+data+","
								+ "msg:"+msg
				+ "}");
		return sb.toString();
	}
	
	public static Map<String, Object> getMap(List data,String result,String msg) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("result", result);
		map.put("data", data);
		map.put("msg", msg);
		return map;
	}
}
