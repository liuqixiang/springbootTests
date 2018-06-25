package com.biandan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.biandan.entity.User;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAll();
}