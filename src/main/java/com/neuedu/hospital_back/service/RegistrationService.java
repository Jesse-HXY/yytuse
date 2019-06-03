package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.PatientMapper;
import com.neuedu.hospital_back.mapper.RegistrationMapper;
import com.neuedu.hospital_back.po.Patient;
import com.neuedu.hospital_back.po.Registration;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@Service
public class RegistrationService {

    @Resource
    private PatientMapper patientMapper;

    @Resource
    private RegistrationMapper registrationMapper;

    public int insertPatient(JSONObject object) {
        Patient patient = new Patient();
        patient.setpId(object.getString("pId"));
        patient.setpName(object.getString("pName"));
        patient.setpBirth(Date.valueOf(object.getString("pBirth")));
        patient.setpSex(object.getBoolean("pSex"));
        patient.setpAddress(object.getString("pAddress"));
        return patientMapper.insert(patient);
    }

    public int insertRegistration(Registration registration) {
        return registrationMapper.insertRegistration(registration);
    }

    public List<Registration> getRegistration(JSONObject object) {
        return registrationMapper.getRegistration(object.getString("pId"));
    }

    public Patient getPatientById(JSONObject object) {
        return patientMapper.getById(object.getString("pId"));
    }
}
