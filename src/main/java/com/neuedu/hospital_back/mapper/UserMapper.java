package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.User;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int updateByPrimaryKeySelective(User record);

    List<User> getAllUser();

    List<User> getUserByCondition(User user);
}