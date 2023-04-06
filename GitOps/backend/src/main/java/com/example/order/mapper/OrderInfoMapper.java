package com.example.order.mapper;

import com.example.order.entity.OrderInfo;
import org.springframework.stereotype.Repository;

/**
* @author Kevin Zhang
* @description 针对表【order_info(订单)】的数据库操作Mapper
* @createDate 2023-02-25 00:47:46
* @Entity com.example.order.entity.OrderInfo
*/
@Repository
public interface OrderInfoMapper {

    int deleteByPrimaryKey(String id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

}
