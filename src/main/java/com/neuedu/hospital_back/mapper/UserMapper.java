package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.User;

import java.util.List;

public interface UserMapper {
    void deleteByPrimaryKey(Integer uId);

    void insert(User record);

    void updateByPrimaryKeySelective(User record);

    List<User> getAllUser();

    List<User> getUserByCondition(User user);
}