package com.neuedu.hospital_back.controller;


import com.neuedu.hospital_back.po.ExamnationItem;
import com.neuedu.hospital_back.service.ExamnationitemService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/examnationItem")
public class ExamnationItemController {
    @Resource
    private ExamnationitemService examnationitemService;


    @RequestMapping("/getExamnationItems")
    public List<ExamnationItem> getExamnationItems(@RequestBody ExamnationItem examnationItem) {
        return examnationitemService.selectExamnationItem(examnationItem);
    }

    @RequestMapping("/getAllExamnationItem")
    public List<ExamnationItem> getAllExamnationItem() {
        return  examnationitemService.selectAllExamnationItem();
    }

    @PostMapping("/getExamnationItemByPage")
    public List<ExamnationItem> getExamnationItemByPage(@RequestBody JSONObject object) {
        return  examnationitemService.selectExamnationItemByPage(object);
    }

    @RequestMapping("/deleteExamnationItem")
    public boolean deleteExamnationItem(@RequestBody JSONObject eIId) {
        return examnationitemService.deleteByPrimaryKey(eIId);
    }

    @RequestMapping("/insertExamnationItem")
    public boolean insertExamnationItem(@RequestBody ExamnationItem examnationItem) {
        return examnationitemService.insert(examnationItem);
    }

    @RequestMapping("/updateExamnationItem")
    public boolean updateExamnationItem(@RequestBody ExamnationItem examnationItem){
        return examnationitemService.updateByPrimaryKeySelective(examnationItem);
    }

    @RequestMapping("/getPageCount")
    public int getPageCount(){
        return examnationitemService.getPageCount();
    }
    


}
