package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DepartmentMapper;
import com.neuedu.hospital_back.mapper.DepartmentUserMapper;
import com.neuedu.hospital_back.mapper.DoctorMapper;
import com.neuedu.hospital_back.po.Department;
import com.neuedu.hospital_back.po.DepartmentUser;
import com.neuedu.hospital_back.po.Doctor;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class UserService {
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private DepartmentUserMapper departmentUserMapper;

    public int getUserCount() {
        return userMapper.getUserCount();
    }


    public User login(JSONObject object) {
        return userMapper.login(object.getInt("uId"), object.getString("uPassword"));
    }

    public List<User> getAvailableDoctor(JSONObject object) throws ParseException {
        int index = getDayForWeek(object.getString("currentDate"));
        return userListPutDepartment(userMapper.getAvailableDoctor(object.getString("dId"), object.getString("rLName"), index));
    }

    public int getDayForWeek(String currentDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(currentDate));
        int dayForWeek;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 0;
        } else {
            dayForWeek = 8 - c.get(Calendar.DAY_OF_WEEK);
        }
        return dayForWeek;
    }


    //通过dId和rLName获得User
    public List<User> getUerByDIdAndRLName(JSONObject object) {
        //带入userListPutDepartment函数赋值department
        return userListPutDepartment(userMapper.getUerByDIdAndRLName(object.getString("dId"), object.getString("rLName")));
    }

    public List<User> getUerByDepartment(JSONObject object) {
        //拿到user的id
        List<Integer> uIds = departmentUserMapper.selectBydId(object.getString("dId"));
        //通过id得到user的list
        List<User> users = new ArrayList<>();
        for (int uId : uIds) {
            users.add(userMapper.getUserById(uId));
        }
        //带入userListPutDepartment函数赋值department
        return userListPutDepartment(users);
    }

    public List<User> getUserByPage(JSONObject object) {
        //拿到一页的user,带入userListPutDepartment函数赋值department
        return userListPutDepartment(userMapper.getUserByPage(object.getInt("pageNum"), object.getInt("pageSize")));
    }

    //给User赋值department
    public List<User> userListPutDepartment(List<User> users) {
        //遍历每个user插入其所在的departments
        for (User user : users) {
            int uId = user.getuId();
            //找到表中user对应的department的ids
            List<String> dIds = departmentUserMapper.selectByuId(uId);
            //通过拿到的ids找到department并插入
            for (String dId : dIds) {
                Department department = departmentMapper.getDepartmentBydId(dId);
                user.getDepartments().add(department);
            }
        }
        return users;
    }

    public boolean deleteByuId(JSONObject object) {
        int uId = object.getInt("uId");
        int result = 0;
        result += departmentUserMapper.deleteByuId(uId);
        result += doctorMapper.deleteDoctor(uId);
        result += userMapper.deleteByuId(uId);
        return result == 3;
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
        //得到科室ID列表
        List<String> dIds = jsonObject.getJSONArray("dIdList");
        //插入联合表中
        DepartmentUser departmentUser = new DepartmentUser();
        for (String dId : dIds) {
            departmentUser.setdId(dId);
            departmentUser.setuId(uId);
            result = departmentUserMapper.insert(departmentUser);
        }
        //是Doctor就把剩下的信息写入
        if (jsonObject.getBoolean("isDoctor")) {
            Doctor doctor = new Doctor();
            doctor.setuId(uId);
            doctor.setdVacation(jsonObject.getString("dVacation"));
            doctor.setIsDue(jsonObject.getBoolean("isDue"));
            doctor.setrLName(jsonObject.getString("rLName"));
            result = doctorMapper.insertDoctor(doctor);
        }
        return result == 1;
    }

    public boolean updateUser(JSONObject object) {
        //得到主键
        int uId = object.getInt("uId");
        User user = new User();
        user.setuId(uId);
        user.setuNickName(object.getString("uNickName"));
        user.setuPassword(object.getString("uPassword"));
        user.setuName(object.getString("uName"));
        user.setIsDoctor(object.getBoolean("isDoctor"));
        user.setuCategory(object.getString("uCategory"));
        int result;
        userMapper.updateUser(user);
        //得到科室ID列表
        List<String> dIds = object.getJSONArray("dIdList");
        DepartmentUser departmentUser = new DepartmentUser();
        //删除记录
        result = departmentUserMapper.deleteByuId(uId);
        //插入联合表中
        for (String dId : dIds) {
            departmentUser.setdId(dId);
            departmentUser.setuId(uId);
            result = departmentUserMapper.insert(departmentUser);
        }
        //是Doctor就把剩下的信息更新
        if (object.getBoolean("isDoctor")) {
            Doctor doctor = new Doctor();
            doctor.setuId(uId);
            doctor.setdVacation(object.getString("dVacation"));
            doctor.setrLName(object.getString("rLName"));
            result = doctorMapper.updateDoctor(doctor);
        }
        return result == 1;

    }

    public List<User> selectByCondition(User user) {
        return userMapper.getUserByCondition(user);
    }

    public List<User> selectAllUser() {
        return userMapper.getAllUser();
    }

}

