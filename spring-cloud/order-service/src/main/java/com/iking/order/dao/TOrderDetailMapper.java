package com.iking.order.dao;

import com.iking.module.oder.model.TOrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TOrderDetailMapper {
    int deleteByPrimaryKey(String fId);

    int insert(TOrderDetail record);

    int insertSelective(TOrderDetail record);

    TOrderDetail selectByPrimaryKey(String fId);

    int updateByPrimaryKeySelective(TOrderDetail record);

    int updateByPrimaryKey(TOrderDetail record);
}