package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("getAvailableDoctor")
    public List<User> getAvailableDoctor(@RequestBody JSONObject object) throws ParseException {
        return userService.getAvailableDoctor(object);
    }

    @PostMapping("/getUser")
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

    @PostMapping("/deleteUser")
    public boolean deleteUser(@RequestBody JSONObject object) {
        return userService.deleteByuId(object);
    }

    @PostMapping("/insertUser")
    public boolean insertUser(@RequestBody JSONObject object) {
        return userService.insert(object);
    }

    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody JSONObject object) {
        return userService.updateUser(object);
    }

    @PostMapping("/getUserCount")
    public int getUserCount(){
        return userService.getUserCount();
    }

    @PostMapping("/getUerByDepartment")
    public List<User> getUerByDepartment(@RequestBody JSONObject object){
        return userService.getUerByDepartment(object);
    }

    @PostMapping("/getUerByDIdAndRLName")
    public List<User> getUerByDIdAndRLName(@RequestBody JSONObject object){
        return userService.getUerByDIdAndRLName(object);
    }
}
