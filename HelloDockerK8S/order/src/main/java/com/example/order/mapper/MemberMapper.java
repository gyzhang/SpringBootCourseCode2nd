package com.example.order.mapper;

import com.example.order.entity.Member;
import org.springframework.stereotype.Repository;

/**
* @author Kevin Zhang
* @description 针对表【member(会员)】的数据库操作Mapper
* @createDate 2023-02-24 08:45:27
* @Entity com.example.order.entity.Member
*/
@Repository
public interface MemberMapper {

    int deleteByPrimaryKey(String id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

}
