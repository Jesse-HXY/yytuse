package com.neuedu.hospital_back.controller;


import com.neuedu.hospital_back.po.ArrangementList;
import com.neuedu.hospital_back.po.ArrangementRegulation;
import com.neuedu.hospital_back.service.ArrangementRegulationService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/arrangementRegulation")
public class ArrangementRegulationController {

    @Resource
    private ArrangementRegulationService arrangementRegulationService;

    @RequestMapping("/insertArrangementRegulation")
    public boolean insertArrangementRegulation(@RequestBody JSONObject object){
        return arrangementRegulationService.insert(object);
    }
    @RequestMapping("/getArrangementList")
    public List<ArrangementList> getArrangementList(@RequestBody JSONObject object){
        return arrangementRegulationService.getArrangementList(object);

    }
}
