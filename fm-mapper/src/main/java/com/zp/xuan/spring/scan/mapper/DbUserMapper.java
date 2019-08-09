package com.zp.xuan.spring.scan.mapper;

import com.zp.xuan.spring.scan.pojo.DbUser;
import com.zp.xuan.spring.scan.pojo.DbUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbUserMapper {
    int countByExample(DbUserExample example);

    int deleteByExample(DbUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DbUser record);

    int insertSelective(DbUser record);

    List<DbUser> selectByExample(DbUserExample example);

    DbUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DbUser record, @Param("example") DbUserExample example);

    int updateByExample(@Param("record") DbUser record, @Param("example") DbUserExample example);

    int updateByPrimaryKeySelective(DbUser record);

    int updateByPrimaryKey(DbUser record);
}