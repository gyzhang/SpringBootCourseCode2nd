package com.example.order.mapper;

import com.example.order.entity.Product;
import org.springframework.stereotype.Repository;

/**
* @author Kevin Zhang
* @description 针对表【product(商品)】的数据库操作Mapper
* @createDate 2023-02-24 08:45:27
* @Entity com.example.order.entity.Product
*/
@Repository
public interface ProductMapper {

    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

}
