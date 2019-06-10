package com.neuedu.hospital_back.controller;


import com.neuedu.hospital_back.po.ExamnationItem;
import com.neuedu.hospital_back.po.ExamnationTemplate;
import com.neuedu.hospital_back.service.ExamnationTemplateService;
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

    @Resource
    private ExamnationTemplateService examnationTemplateService;

    @RequestMapping("/importExamnationItems")
    public boolean importExamnationItems() throws Exception {
        return examnationitemService.importExamnationItems();
    }

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

    @PostMapping("/getExamnationItemByEIName")
    public List<ExamnationItem> getExamnationItemByEIName(@RequestBody JSONObject object) {
        return  examnationitemService.selectExamnationItemByEIName(object);
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

    @RequestMapping("/insertExaminationTemplate")
    public boolean insertExaminationTemplate(@RequestBody JSONObject object){
        return examnationTemplateService.insert(object);
    }

    @PostMapping("/getExaminationTemplateByCondition")
    public List<ExamnationTemplate> getExaminationTemplateByCondition(@RequestBody JSONObject object){
        return examnationTemplateService.selectByCondition(object);
    }

    @PostMapping("/checkDetail")
    public ExamnationTemplate checkDetail(@RequestBody JSONObject object){
        return examnationTemplateService.checkDetail(object);
    }

    @PostMapping("/deleteExamnationTemplateByPrimaryKey")
    public Boolean ExamnationTemplate(@RequestBody JSONObject object){
        return examnationTemplateService.deleteByPrimaryKey(object);
    }


}
