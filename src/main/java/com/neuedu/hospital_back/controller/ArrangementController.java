package com.neuedu.hospital_back.controller;



import com.neuedu.hospital_back.service.ArrangementService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/arrangement")
public class ArrangementController {

    @Resource
    private ArrangementService arrangementService;

    @PostMapping("/insertArrangement")
    public boolean updateArrangement(@RequestBody JSONObject object){return arrangementService.updateByPrimaryKeySelective(object);}

}
