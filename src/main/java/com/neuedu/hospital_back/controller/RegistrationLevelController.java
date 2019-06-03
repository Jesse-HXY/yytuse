package com.neuedu.hospital_back.controller;


import com.neuedu.hospital_back.po.RegistrationLevel;
import com.neuedu.hospital_back.service.RegistrationlevelService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/registrationLevel")
public class RegistrationLevelController {

    @Resource
    private RegistrationlevelService registrationlevelService;

    @RequestMapping("/getRegistrationLevel")

    public List<RegistrationLevel> getRegistrationLevels(@RequestBody RegistrationLevel registrationlevel) {
        return registrationlevelService.selectByPrimaryKey(registrationlevel);
    }

    @PostMapping("/getAllRegistrationLevel")
    public List<RegistrationLevel> getAllRegistrationLevels() {
        return registrationlevelService.selectAll();
    }

    @RequestMapping("/deleteRegistrationLevel")
    public boolean deleteRegistrationLevel(@RequestBody JSONObject rLId) {
        return registrationlevelService.deleteByPrimaryKey(rLId);
    }

    @RequestMapping("/insertRegistrationLevel")
    public boolean insertRegistrationLevel(@RequestBody RegistrationLevel registrationlevel) {
        return registrationlevelService.insert(registrationlevel);
    }

    @RequestMapping("/updateRegistrationLevel")
    public boolean updateRegistrationLevel(@RequestBody RegistrationLevel registrationlevel) {
        return registrationlevelService.updateByPrimaryKeySelective(registrationlevel);
    }

}
