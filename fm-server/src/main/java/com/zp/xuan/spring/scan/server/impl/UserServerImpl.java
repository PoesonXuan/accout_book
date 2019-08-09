package com.zp.xuan.spring.scan.server.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zp.xuan.spring.scan.mapper.DbUserMapper;
import com.zp.xuan.spring.scan.pojo.DbUser;
import com.zp.xuan.spring.scan.pojo.DbUserExample;
import com.zp.xuan.spring.scan.pojo.DbUserExample.Criteria;
import com.zp.xuan.spring.scan.server.IUserServer;

@Service
public class UserServerImpl implements IUserServer {

	private static final Logger logger = Logger.getLogger(UserServerImpl.class);
	@Autowired
	private DbUserMapper dbUserMapper;
	
	public DbUser login(String loginName) throws Exception {
		logger.info("login(),loginName = "+loginName);
		DbUserExample userExample = new DbUserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andLoginnameEqualTo(loginName);
		criteria.andStatusEqualTo("1");
		List<DbUser> dbUsers = dbUserMapper.selectByExample(userExample );
		logger.info("login(),dbUsers = "+dbUsers);
		if(dbUsers != null && dbUsers.size() >0) {
			logger.info("login(),dbUsers.size = "+dbUsers.size());
			return dbUsers.get(0);
		}
		logger.info("login(),��ȡ�û���Ϣʧ��");
		return null;
	}
	
	public DbUser addUser(DbUser dbUser) throws Exception {
		logger.info("addUser()");
		DbUser login = this.login(dbUser.getLoginname());
		if(login == null) {
			dbUserMapper.insert(dbUser);
			DbUser login2 = login(dbUser.getLoginname());
			if(login2 != null) {
				dbUser.setId(login2.getId());
			}
		}
		return dbUser;
	}

	public DbUser updateUser(DbUser dbUser) throws Exception {
		logger.info("updateUser()");
		DbUser record = login(dbUser.getLoginname());
		dbUser.setId(record.getId());
		dbUserMapper.updateByPrimaryKey(dbUser);
		return dbUser;
	}
	
	public DbUser deleteUser(DbUser dbUser) throws Exception {
		logger.info("deleteUser()");
		dbUser.setStatus("99");
		DbUser record = updateUser(dbUser);
		return record;
	}

	public List<DbUser> findUserByLoginName(String loginName,int pageNum ,int pageSize) throws Exception {
		DbUserExample userExample = new DbUserExample();
		Criteria criteria = userExample.createCriteria();
//		criteria.andLoginnameLike("%" + loginName + "%");
		if(loginName != null && !"".equals(loginName)) {
			criteria.andNicknameLike("%" + loginName+ "%");
		}
		criteria.andStatusEqualTo("1");
		
		
		//�����ҳ��ѯ��ʹ��PageHelper��ҳ����  
	    //�ڲ�ѯ֮ǰ���뵱ǰҳ��Ȼ����ټ�¼  
	    PageHelper.startPage(pageNum,pageSize);  
	    //startPage������������ѯ���Ƿ�ҳ��ѯ  
	    List<DbUser> dbUsers = dbUserMapper.selectByExample(userExample );
	    //ʹ��PageInfo��װ��ѯ�����ֻ��Ҫ��pageInfo����ҳ��Ϳ���  
		return dbUsers;
	}
	
	
	public DbUserMapper getDbUserMapper() {
		return dbUserMapper;
	}
	
	public void setDbUserMapper(DbUserMapper dbUserMapper) {
		this.dbUserMapper = dbUserMapper;
	}

	public DbUser getDbUserById(long id) throws Exception {
		return dbUserMapper.selectByPrimaryKey(id);
	}
}
