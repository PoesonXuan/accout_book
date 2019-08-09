package com.zp.xuan.spring.scan.mapper;

import com.zp.xuan.spring.scan.pojo.DbIobill;
import com.zp.xuan.spring.scan.pojo.DbIobillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbIobillMapper {
    int countByExample(DbIobillExample example);

    int deleteByExample(DbIobillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DbIobill record);

    int insertSelective(DbIobill record);

    List<DbIobill> selectByExample(DbIobillExample example);

    DbIobill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DbIobill record, @Param("example") DbIobillExample example);

    int updateByExample(@Param("record") DbIobill record, @Param("example") DbIobillExample example);

    int updateByPrimaryKeySelective(DbIobill record);

    int updateByPrimaryKey(DbIobill record);
}