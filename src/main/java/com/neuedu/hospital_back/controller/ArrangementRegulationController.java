package com.neuedu.hospital_back.controller;


import com.neuedu.hospital_back.service.ArrangementRegulationService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/arrangementRegulation")
public class ArrangementRegulationController {

    @Resource
    private ArrangementRegulationService arrangementRegulationService;

    @RequestMapping("/insertArrangementRegulation")
    public boolean insertArrangementRegulation(JSONObject object){
        return arrangementRegulationService.insert(object);
    }
}
