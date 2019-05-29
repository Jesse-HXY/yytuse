package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.po.Doctor;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public boolean deleteByPrimaryKey(Integer uId) {
        userMapper.deleteByPrimaryKey(uId);
        return true;
    }

    public boolean insert(JSONObject jsonObject) {
        User user = new User();
        user.setuNickName(jsonObject.getString("uNickName"));
        user.setuPassword(jsonObject.getString("uPassword"));
        user.setuName(jsonObject.getString("uName"));
        user.setIsDoctor(jsonObject.getBoolean("isDoctor"));
        user.setuCategory(jsonObject.getString("uCategory"));
        userMapper.insert(user);
        int uId = user.getuId();
        if (!jsonObject.getBoolean("isDoctor")) {
            Doctor doctor = new Doctor();
            doctor.setuId(uId);
            doctor.setdVacation(jsonObject.getString("dVacation"));
            doctor.setIsDue(jsonObject.getBoolean("isDue"));
        }
        return true;
    }

    public boolean updateByPrimaryKeySelective(User record) {
        userMapper.updateByPrimaryKeySelective(record);
        return true;
    }

    public List<User> selectByCondition(User user) {
        return userMapper.getUserByCondition(user);
    }

    public List<User> selectAllUser() {
        return userMapper.getAllUser();
    }

}

