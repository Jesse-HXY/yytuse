package com.neuedu.hospital_back;


import com.neuedu.hospital_back.mapper.ExamnationitemMapper;
import com.neuedu.hospital_back.po.ExamnationItem;
import com.neuedu.hospital_back.service.ExamnationitemService;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamnationItemTest {

    @Resource
    private ExamnationitemService examnationitemService;

    @Resource
    private ExamnationitemMapper examnationitemMapper;

   @Test
    public void getExamnationItems(){
       ExamnationItem examnationItem=new ExamnationItem();
       examnationItem.setdId("KFK");
       List<ExamnationItem> examnationItems=examnationitemService.selectExamnationItem( examnationItem);
       System.out.println(examnationItems);
   }


   @Test
    public void insert(){
       ExamnationItem examnationItem=new ExamnationItem();
       examnationItem.setdId("KFK");
       examnationItem.seteIName("lll");
       examnationItem.seteIFee(1000.1);
       assertEquals(true, examnationitemService.insert(examnationItem));
   }

    @Test
    public void update(){
        ExamnationItem examnationItem=new ExamnationItem();
        examnationItem.setdId("KFK");
        examnationItem.seteIName("ll");
        examnationItem.seteIFee(1000.1);
        examnationItem.seteIId(10000);
        assertEquals(true, examnationitemService.updateByPrimaryKeySelective(examnationItem));
    }

    @Test
    public void delete(){
        assertEquals(true, examnationitemService.deleteByPrimaryKey(10000));
    }
}
