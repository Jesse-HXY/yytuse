package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.PatientMapper;
import com.neuedu.hospital_back.po.Patient;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;

@Service
public class RegistrationService {

    @Resource
    private PatientMapper patientMapper;

    public int insertPatient(JSONObject object) {
        Patient patient = new Patient();
        patient.setpId(object.getString("pId"));
        patient.setpName(object.getString("pName"));
        patient.setpBirth(Date.valueOf(object.getString("pBirth")));
        patient.setpSex(object.getBoolean("pSex"));
        patient.setpAddress(object.getString("pAddress"));
        return patientMapper.insert(patient);
    }

    public Patient getPatientById(JSONObject object) {
        return patientMapper.getById(object.getString("pId"));
    }
}
