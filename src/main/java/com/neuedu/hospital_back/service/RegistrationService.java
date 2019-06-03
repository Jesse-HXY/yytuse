package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.PatientMapper;
import com.neuedu.hospital_back.mapper.RegistrationMapper;
import com.neuedu.hospital_back.po.Patient;
import com.neuedu.hospital_back.po.Registration;
import com.neuedu.hospital_back.po.RegistrationInfo;
import net.sf.json.JSONObject;
import org.hibernate.validator.constraints.URL;
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
        long rDate=registration.getrDate()/1000;
        registration.setrDate(rDate);
        return registrationMapper.insertRegistration(registration);
    }


    public Patient getPatientById(JSONObject object) {
        return patientMapper.getById(object.getString("pId"));
    }

    public List<RegistrationInfo> getRegistrationInfo(JSONObject object){
        String rStatus=object.getString("rStatus");


        if (rStatus.equals("诊毕")){
         return registrationMapper.getAlreadyDiagnosisByuId(object.getInt("uId"),object.getString("pName"));
        }else{
            return registrationMapper.getNotDiagnosisByuId(object.getInt("uId"),object.getString("pName"));
        }

    }

    public List<RegistrationInfo> getRegistrationInfoByUIdAndDId(JSONObject object){
        String rStatus=object.getString("rStatus");
        if (rStatus.equals("诊毕")){
            return registrationMapper.getAlreadyDiagnosisByuIdAndDId(object.getInt("uId"),object.getString("pName"),object.getString("dId"));
        }else{
            return registrationMapper.getNotDiagnosisByuIdAndDId(object.getInt("uId"),object.getString("pName"),object.getString("dId"));
        }
    }
}

