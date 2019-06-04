package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.Patient;
import com.neuedu.hospital_back.po.Registration;
import com.neuedu.hospital_back.po.RegistrationInfo;
import com.neuedu.hospital_back.service.RegistrationService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/registration")
public class  RegistrationController {

    @Resource
    private RegistrationService registrationService;

   @PostMapping("/insertPatient")
    public int insertPatient(@RequestBody JSONObject object) {
       return registrationService.insertPatient(object);
    }

    @PostMapping("/getPatientById")
    public Patient getPatientById(@RequestBody JSONObject object) {
        return registrationService.getPatientById(object);
    }

    @PostMapping("/insertRegistration")
    public int insertRegistration(@RequestBody Registration registration){
       return registrationService.insertRegistration(registration);
    }

    @PostMapping("/getRegistrationInfoByuId")
    public List<RegistrationInfo> getRegistrationInfo(@RequestBody JSONObject object){
       return registrationService.getRegistrationInfo(object);
    }

    @PostMapping("/getRegistrationInfoByuIdAndDId")
    public List<RegistrationInfo> getRegistrationInfoByuIdAndDId(@RequestBody JSONObject object){
        return registrationService.getRegistrationInfoByUIdAndDId(object);
    }

    @PostMapping("/getRegistrationInfoByrId")
    public  List<RegistrationInfo> getRegistrationInfoByrId(@RequestBody JSONObject object){
       return registrationService.getRegistrationInfoByrId(object);
    }

    @PostMapping("/updateRStatus")
    public boolean updateRStatus(@RequestBody JSONObject object){
       return registrationService.updateRStatus(object);
    }

}
