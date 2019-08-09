package com.zp.xuan.spring.scan.mapper;

import com.zp.xuan.spring.scan.pojo.DbDictionary;
import com.zp.xuan.spring.scan.pojo.DbDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbDictionaryMapper {
    int countByExample(DbDictionaryExample example);

    int deleteByExample(DbDictionaryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DbDictionary record);

    int insertSelective(DbDictionary record);

    List<DbDictionary> selectByExample(DbDictionaryExample example);

    DbDictionary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DbDictionary record, @Param("example") DbDictionaryExample example);

    int updateByExample(@Param("record") DbDictionary record, @Param("example") DbDictionaryExample example);

    int updateByPrimaryKeySelective(DbDictionary record);

    int updateByPrimaryKey(DbDictionary record);
}