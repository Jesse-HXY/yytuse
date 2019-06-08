package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.PatientMapper;
import com.neuedu.hospital_back.mapper.RegistrationMapper;
import com.neuedu.hospital_back.po.Patient;
import com.neuedu.hospital_back.po.Registration;
import com.neuedu.hospital_back.po.RegistrationInfo;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
        registration.setrDate(registration.getrDate() / 1000);
        return registrationMapper.insertRegistration(registration);
    }


    public Patient getPatientById(JSONObject object) {
        return patientMapper.getById(object.getString("pId"));
    }

    public List<RegistrationInfo> getRegistrationInfo(JSONObject object) {
        String rStatus = object.getString("rStatus");
        if (rStatus.equals("诊毕")) {
            return registrationMapper.getAlreadyDiagnosisByuId(object.getInt("uId"), object.getString("pName"));
        } else {
            return registrationMapper.getNotDiagnosisByuId(object.getInt("uId"), object.getString("pName"));
        }

    }

    public List<RegistrationInfo> getRegistrationInfoByUIdAndDId(JSONObject object) {
        String rStatus = object.getString("rStatus");
        if (rStatus.equals("诊毕")) {
            return registrationMapper.getAlreadyDiagnosisByuIdAndDId(object.getInt("uId"), object.getString("pName"), object.getString("dId"));
        } else {
            return registrationMapper.getNotDiagnosisByuIdAndDId(object.getInt("uId"), object.getString("pName"), object.getString("dId"));
        }
    }

    public List<RegistrationInfo> getRegistrationInfoByrId(JSONObject object) {
        List<RegistrationInfo> registrationInfos = registrationMapper.getRegistrationInfoByrId(object.getInt("rId"));
        for (RegistrationInfo registrationInfo : registrationInfos) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String rTime = sdf.format(new Date(registrationInfo.getrDate()));
            registrationInfo.setrTime(rTime);
            String MorningOrEvening = MorningOrEvening(registrationInfo.getrDate());
            registrationInfo.setMorningOrEvening(MorningOrEvening);
            if (registrationInfo.getrStatus().equals("未看诊")) {
                registrationInfo.setOkToWithdraw(true);
            } else {
                registrationInfo.setOkToWithdraw(false);
            }
        }
        return registrationInfos;
    }

    public List<RegistrationInfo> getRegistrationInfoByrIdOrPName(JSONObject object) {
        return registrationMapper.getRegistrationInfoByrIdOrPName(object.getInt("rId"), object.getString("pName"));
    }

    public String MorningOrEvening(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String time = sdf.format(new Date(date));
        int a = Integer.parseInt(time);
        if (a >= 12) {
            return "下午";
        } else {
            return "上午";
        }
    }

    public boolean updateRStatus(JSONObject object) {
        return registrationMapper.updateRegistration(object.getInt("rId"), object.getString("rStatus")) == 1;
    }
}

