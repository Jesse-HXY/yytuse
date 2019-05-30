package com.neuedu.hospital_back;


import com.neuedu.hospital_back.po.RegistrationLevel;
import com.neuedu.hospital_back.service.RegistrationlevelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.pow;
import static junit.framework.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationLevelTest {

    @Resource
    private RegistrationlevelService registrationlevelService;

    @Test
    public void getRegistrationLevel() {
        RegistrationLevel registrationLevel = new RegistrationLevel();
        registrationLevel.setrLId(3);
        List<RegistrationLevel> registrationLevels = registrationlevelService.selectByPrimaryKey(registrationLevel);
        System.out.println(registrationLevels);
    }

    @Test
    public void getAllRegistrationLevels() {
        registrationlevelService.selectAll();
    }

    /*@Test
    public void deleteRegistrationLevel() {
        assertEquals(true, registrationlevelService.deleteByPrimaryKey(4));
    }
*/
    @Test
    public void insertRegistrationLevel() {
        RegistrationLevel registrationLevel = new RegistrationLevel();
        registrationLevel.setrLId(4);
        registrationLevel.setrLName("复查号");
        registrationLevel.setrLLimitation(40);
        registrationLevel.setrLFee(10.00);
        assertEquals(true, registrationlevelService.insert(registrationLevel));
    }

    @Test
    public void updateRegistrationLevel() {
        RegistrationLevel registrationLevel = new RegistrationLevel();
        registrationLevel.setrLId(4);
        registrationLevel.setrLName("test");
        registrationLevel.setrLLimitation(30);
        registrationLevel.setrLFee(10.00);
        assertEquals(true, registrationlevelService.updateByPrimaryKeySelective(registrationLevel));
    }

    @Test
    public void test(){
        HashMap<Integer,String> map=new HashMap<Integer, String>();
        map.put(2,"星期一上午");
        map.put(1024,"星期五下午");
      int[] list=new int[14];
        int j=1026;
        for(int i=14;i>=1||j>0;i--){
            if(j>=pow(2,i)){
                j= (int) (j-pow(2,i));
              list[i-1]=1;
            }
        }
        System.out.println(list[0]);
        System.out.println(list[9]);
        assertEquals(true,list[0]==1);
    }
}
