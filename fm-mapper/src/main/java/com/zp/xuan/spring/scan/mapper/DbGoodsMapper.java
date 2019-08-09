package com.zp.xuan.spring.scan.mapper;

import com.zp.xuan.spring.scan.pojo.DbGoods;
import com.zp.xuan.spring.scan.pojo.DbGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbGoodsMapper {
    int countByExample(DbGoodsExample example);

    int deleteByExample(DbGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DbGoods record);

    int insertSelective(DbGoods record);

    List<DbGoods> selectByExample(DbGoodsExample example);

    DbGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DbGoods record, @Param("example") DbGoodsExample example);

    int updateByExample(@Param("record") DbGoods record, @Param("example") DbGoodsExample example);

    int updateByPrimaryKeySelective(DbGoods record);

    int updateByPrimaryKey(DbGoods record);
}