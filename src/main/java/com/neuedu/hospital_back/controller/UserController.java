package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.Department;
import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getUser")
    public List<User> selectByCondition(@RequestBody User user) {
        return userService.selectByCondition(user);
    }

    @PostMapping("/getAllUser")
    public List<User> selectAllUser() {
        return userService.selectAllUser();
    }

    @PostMapping("/getUserByPage")
    public List<User> getUserByPage(@RequestBody JSONObject object) {
        return userService.getUserByPage(object);
    }

    @RequestMapping("/deleteUser")
    public boolean deleteUser(@RequestBody JSONObject object) {
        return userService.deleteByuId(object);
    }

    @PostMapping("/insertUser")
    public boolean insertUser(@RequestBody JSONObject object) {
        return userService.insert(object);
    }

    @RequestMapping("/updateUser")
    public boolean updateUser(@RequestBody JSONObject object) {
        return userService.updateUser(object);
    }

    @RequestMapping("/getUserCount")
    public int getUserCount(){
        return userService.getUserCount();
    }
}
