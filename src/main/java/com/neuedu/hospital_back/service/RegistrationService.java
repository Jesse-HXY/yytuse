package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.PatientMapper;
import com.neuedu.hospital_back.po.Patient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegistrationService {

    @Resource
    private PatientMapper patientMapper;

    public int insertPatient(Patient patient) {
        return patientMapper.insert(patient);
    }

    public Patient getPatientById(int pId) {
        return patientMapper.getById(pId);
    }
}
