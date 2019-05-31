package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.Patient;
import com.neuedu.hospital_back.po.Registration;
import com.neuedu.hospital_back.service.RegistrationService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/registration")
public class RegistrationController {

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

}
