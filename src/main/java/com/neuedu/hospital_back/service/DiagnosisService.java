package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DiagnosisTypeMapper;
import com.neuedu.hospital_back.mapper.MedicalRecordMapper;
import com.neuedu.hospital_back.po.DiagnosisType;
import com.neuedu.hospital_back.po.MedicalRecord;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiagnosisService {

    @Resource
    private DiagnosisTypeMapper diagnosisTypeMapper;

    @Resource
    private MedicalRecordMapper medicalRecordMapper;

    public boolean insertMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordMapper.insertMedicalRecord(medicalRecord) == 1;
    }

    public boolean insertDiagnosisTypes(JSONObject object) {
        List<DiagnosisType> diagnosisTypes = object.getJSONArray("diagnosisTypes");
        int result = 0;
        for (DiagnosisType diagnosisType : diagnosisTypes) {
            result += diagnosisTypeMapper.insert(diagnosisType);
        }
        return result == diagnosisTypes.size();
    }
}
