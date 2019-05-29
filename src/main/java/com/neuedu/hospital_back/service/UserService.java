package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DoctorMapper;
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

    @Resource
    private DoctorMapper doctorMapper;

    public boolean deleteByPrimaryKey(Integer uId) {
        return userMapper.deleteByPrimaryKey(uId) == 1;
    }

    public boolean insert(JSONObject jsonObject) {
        User user = new User();
        user.setuNickName(jsonObject.getString("uNickName"));
        user.setuPassword(jsonObject.getString("uPassword"));
        user.setuName(jsonObject.getString("uName"));
        user.setIsDoctor(jsonObject.getBoolean("isDoctor"));
        user.setuCategory(jsonObject.getString("uCategory"));
        int result = userMapper.insert(user);
        //得到自动添加的主键
        int uId = user.getuId();
        //是Doctor就把剩下的信息写入
        if (!jsonObject.getBoolean("isDoctor")) {
            Doctor doctor = new Doctor();
            doctor.setuId(uId);
            doctor.setdVacation(jsonObject.getString("dVacation"));
            doctor.setIsDue(jsonObject.getBoolean("isDue"));
            result = doctorMapper.insertDoctor(doctor);
        }
        return result == 1;
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

