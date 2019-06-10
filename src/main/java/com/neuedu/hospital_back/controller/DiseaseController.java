package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.Disease;
import com.neuedu.hospital_back.service.DiseaseService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/disease")
public class DiseaseController {

    @Resource
    private DiseaseService diseaseService;

    @RequestMapping("/importDiseases")
    public boolean importDiseases() throws Exception {
        return diseaseService.importDiseases();
    }

    @RequestMapping("/getDiseases")
    public List<Disease> getDiseases(@RequestBody Disease disease) {
        return diseaseService.getDiseases(disease);
    }

    @RequestMapping("/getDiseaseType")
    public List<String> getDiseaseType(){
        return diseaseService.getDiseaseType();
    }

    @PostMapping("/getDiseaseByPage")
    public List<Disease> getAllDiseases(@RequestBody JSONObject object) {
        return  diseaseService.getDiseaseByPage(object);
    }

    @RequestMapping("/deleteDisease")
    public boolean deleteDisease(@RequestBody JSONObject disId) {
        return diseaseService.deleteDisease(disId);
    }

    @RequestMapping("/insertDisease")
    public boolean insertDisease(@RequestBody Disease disease) {
        return diseaseService.insert(disease);
    }

    @RequestMapping("/updateDisease")
    public boolean updateDisease(@RequestBody Disease disease){
        return diseaseService.updateDisease(disease);
    }

    @RequestMapping("/getPageCount")
    public int getPageCount(){
        return diseaseService.getDiseaseCount();
    }
}
