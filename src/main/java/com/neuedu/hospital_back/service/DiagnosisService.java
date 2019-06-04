package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DiagnosisTypeMapper;
import com.neuedu.hospital_back.mapper.MedicalRecordMapper;
import com.neuedu.hospital_back.po.DiagnosisType;
import com.neuedu.hospital_back.po.MedicalRecord;
import net.sf.json.JSONArray;
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
        JSONArray jsonArray = object.getJSONArray("diagnosisTypes");
//        List<DiagnosisType> diagnosisTypes = (List<DiagnosisType>) JSONArray.toArray(jsonArray, DiagnosisType.class);
        List<DiagnosisType> diagnosisTypes = (List)JSONArray.toCollection(jsonArray, DiagnosisType.class);
        int result = 0;
        for (DiagnosisType diagnosisType : diagnosisTypes) {
            diagnosisType.setDiaTime(diagnosisType.getDiaTime()/1000);
            result += diagnosisTypeMapper.insert(diagnosisType);
        }
        return result == diagnosisTypes.size();
    }
}
