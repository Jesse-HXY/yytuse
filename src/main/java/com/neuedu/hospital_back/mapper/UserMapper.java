package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int deleteByuId(Integer uId);

    int insert(User record);

    int updateUser(User record);

    List<User> getAllUser();

    List<User> getUserByCondition(User user);

    List<User> getUserByPage(@Param("begin")int begin, @Param("pageSize")int pageSize);

    int getUserCount();
}