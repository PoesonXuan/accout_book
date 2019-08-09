package com.zp.xuan.spring.scan.server;

import java.util.List;

import com.alibaba.druid.sql.dialect.db2.visitor.DB2ASTVisitor;
import com.zp.xuan.spring.scan.pojo.DbUser;

public interface IUserServer {
	DbUser getDbUserById(long id)throws Exception;
	DbUser login(String loginName)throws Exception;
	DbUser addUser(DbUser dbUser)throws Exception;
	DbUser updateUser(DbUser dbUser)throws Exception;
	DbUser deleteUser(DbUser dbUser)throws Exception;
	List<DbUser> findUserByLoginName(String loginName,int page ,int size)throws Exception;
}
