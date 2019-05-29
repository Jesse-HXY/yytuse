package com.neuedu.hospital_back;

import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    
    @Resource 
    private UserService userService;
    
    @Test
    public void getUser() {
        User user = new User();
        user.setuId(2);
        List<User> users = userService.selectByCondition(user);
        System.out.println(users);
    }

    @Test
    public void getAllUsers() {
        userService.selectAllUser();
    }

    @Test
    public void deleteUser() {
        assertEquals(true, userService.deleteByPrimaryKey(3));
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setuId(1);
        user.setuName("查号");
        user.setuNickName("40");
        user.setuPassword("llll");
        user.setIsDoctor(true);
        assertEquals(true, userService.insert(user));
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setuId(3);
        user.setuPassword("test");
        assertEquals(true, userService.updateByPrimaryKeySelective(user));
    }
    
}
