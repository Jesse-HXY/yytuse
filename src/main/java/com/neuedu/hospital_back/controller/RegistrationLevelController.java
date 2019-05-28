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
            return  registrationlevelService.selectAll();
        }

        @RequestMapping("/deleteRegistrationLevel")
        public String deleteRegistrationLevel(@RequestBody JSONObject rLId) {
            Boolean result = registrationlevelService.deleteByPrimaryKey(rLId.getInt("rLId"));
            if (result) {
                return "{\"result\":true}";
            } else {
                return "{\"result\":false}";
            }

        }

        @RequestMapping("/insertRegistrationLevel")
        public String insertRegistrationLevel(@RequestBody RegistrationLevel registrationlevel) {

            Boolean result = registrationlevelService.insert(registrationlevel);
            if (result) {
                return "{\"result\":true}";
            } else {
                return "{\"result\":false}";
            }
        }

        @RequestMapping("/updateRegistrationLevel")
        public String updateRegistrationLevel(@RequestBody RegistrationLevel registrationlevel){
            Boolean result = registrationlevelService.updateByPrimaryKeySelective(registrationlevel);
            if (result) {
                return "{\"result\":true}";
            } else {
                return "{\"result\":false}";
            }
        }
    
}
