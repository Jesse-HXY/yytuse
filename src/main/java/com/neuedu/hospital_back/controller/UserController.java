package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserController {
    
    @Resource
    private UserService userService;
@RequestMapping("/getUser")
    public List<User> selectByCondition(@RequestBody User user){
        return userService.selectByCondition(user);
    }
@PostMapping("/getAllUser")
    public List<User> selectAllUser(){
        return userService.selectAllUser();
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestBody JSONObject uId) {
        Boolean result = userService.deleteByPrimaryKey(uId.getInt("uId"));
        if (result) {
            return "{\"result\":true}";
        } else {
            return "{\"result\":false}";
        }

    }

    @RequestMapping("/insertUser")
    public String insertUser(@RequestBody User User) {

        Boolean result = userService.insert(User);
        if (result) {
            return "{\"result\":true}";
        } else {
            return "{\"result\":false}";
        }
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User User){
        Boolean result = userService.updateByPrimaryKeySelective(User);
        if (result) {
            return "{\"result\":true}";
        } else {
            return "{\"result\":false}";
        }
    }
}
