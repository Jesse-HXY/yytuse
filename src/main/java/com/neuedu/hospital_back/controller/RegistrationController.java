package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.Patient;
import com.neuedu.hospital_back.service.RegistrationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Resource
    private RegistrationService registrationService;

   @PostMapping("/insertPatient")
    public int insertPatient(Patient patient) {
        return registrationService.insertPatient(patient);
    }

    @PostMapping("/getPatientById")
    public Patient getPatientById(int pId) {
        return registrationService.getPatientById(pId);
    }

}
