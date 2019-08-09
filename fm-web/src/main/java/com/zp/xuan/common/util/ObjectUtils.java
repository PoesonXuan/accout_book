package com.zp.xuan.common.util;

import javax.servlet.http.HttpServletRequest;

import com.zp.xuan.spring.scan.pojo.DbUser;

public class ObjectUtils {
	public static DbUser translateToDbUser(HttpServletRequest request) {

		
		DbUser dbUser = new DbUser();
		String loginname = request.getParameter("loginname");
		String ageStr = request.getParameter("age");
		Integer age = Integer.parseInt(ageStr == null || "".equals(ageStr)?"0":ageStr);
		String header = request.getParameter("header");
		String lev = request.getParameter("lev");
		String mail = request.getParameter("mail");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String tele = request.getParameter("tele");
		
		dbUser.setLoginname(loginname);
		dbUser.setAge(age);
		dbUser.setHeader(header);
		dbUser.setLev(lev);
		dbUser.setMail(mail);
		dbUser.setNickname(nickname);
		dbUser.setPassword(password);
		dbUser.setSex(sex);
		dbUser.setTele(tele);
		return requiredValidate(dbUser)?dbUser:null;
	}

	private static boolean requiredValidate(DbUser dbUser) {
		if( isBlank(dbUser.getNickname())
				||isBlank(dbUser.getLoginname())
				||isBlank(dbUser.getPassword())) {
			return false;
		}
		return true;
	}

	private static boolean isBlank(String s) {
		if(s == null || "".equals(s))
			return true;
		return false;
	}
}
