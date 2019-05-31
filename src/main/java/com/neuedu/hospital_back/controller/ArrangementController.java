package com.neuedu.hospital_back.controller;


import com.neuedu.hospital_back.po.DoctorArrangementRegulation;
import com.neuedu.hospital_back.service.ArrangementService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/arrangement")
public class ArrangementController {

    @Resource
    private ArrangementService arrangementService;

    @PostMapping("/insertArrangement")
    public boolean insertArrangement(@RequestBody JSONObject object){
        return  arrangementService.insert(object);
    }
}
