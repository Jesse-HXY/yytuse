package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DiagnosisMapper;
import com.neuedu.hospital_back.mapper.DiagnosisMedicineMapper;
import com.neuedu.hospital_back.mapper.DiagnosisTypeMapper;
import com.neuedu.hospital_back.mapper.MedicalRecordMapper;
import com.neuedu.hospital_back.po.Diagnosis;
import com.neuedu.hospital_back.po.DiagnosisMedicine;
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
    private DiagnosisMapper diagnosisMapper;

    @Resource
    private DiagnosisMedicineMapper diagnosisMedicineMapper;
    @Resource
    private MedicalRecordMapper medicalRecordMapper;

    public boolean insertMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordMapper.insertMedicalRecord(medicalRecord) == 1;
    }

    public boolean insertDiagnosisTypes(JSONObject object) {
        JSONArray jsonArray = object.getJSONArray("diagnosisTypes");
//        List<DiagnosisType> diagnosisTypes = (List<DiagnosisType>) JSONArray.toArray(jsonArray, DiagnosisType.class);
        List<DiagnosisType> diagnosisTypes = (List) JSONArray.toCollection(jsonArray, DiagnosisType.class);
        int result = 0;
        for (DiagnosisType diagnosisType : diagnosisTypes) {
            diagnosisType.setDiaTime(diagnosisType.getDiaTime() / 1000);
            result += diagnosisTypeMapper.insert(diagnosisType);
        }
        return result == diagnosisTypes.size();
    }

    public boolean deleteByPrimaryKey(JSONObject object) {
        int result = 0;

        List<Integer> diaIds=object.getJSONArray("diaIdList");
        for(Integer diaId:diaIds) {
            result += diagnosisMapper.deleteByPrimaryKey(diaId);
            diagnosisMedicineMapper.deleteByPrimaryKey(diaId);
        }
        return result==diaIds.size();
    }

    public Diagnosis insertDiagnosis(JSONObject object) {

        String diaName=object.getString("diaName");
        if(diaName.equals("")||diaName.equals(null)){
            diaName="新增"+String.valueOf(diagnosisMapper.getUnnameCount()+1);
        }
        String diaType=object.getString("diaType");
        Integer rId = object.getInt("rId");
        Long createDate=System.currentTimeMillis()/1000;
        String diaState="暂存";
        Diagnosis d=new Diagnosis(diaType,rId,diaName,createDate,diaState);
        diagnosisMapper.insert(d);
        d.setDiaId(d.getDiaId());
        return d;
    }

    public boolean insertDiagnosisMedicine(JSONObject object){
        Integer diaId=object.getInt("diaId");
        JSONArray jsonArray = object.getJSONArray("diagnosisMedicine");
//        List<DiagnosisType> diagnosisTypes = (List<DiagnosisType>) JSONArray.toArray(jsonArray, DiagnosisType.class);
        List<DiagnosisMedicine> diagnosisMedicines = (List) JSONArray.toCollection(jsonArray, DiagnosisMedicine.class);
        int result = 0;
        for(DiagnosisMedicine d:diagnosisMedicines){
            d.setDiaId(diaId);
            result+=diagnosisMedicineMapper.insert(d);
        }
        return result==diagnosisMedicines.size();
    }

    public boolean updateState(JSONObject object){
        String diaState=object.getString("diaState");
        Long useDate=System.currentTimeMillis()/1000;
        Integer result=0;
        List<Integer> diaIds=object.getJSONArray("diaIdList");
        for(Integer diaId:diaIds){
        Diagnosis d=new Diagnosis();
        d.setDiaId(diaId);
        d.setDiaState(diaState);
        if(diaState.equals("开立")){
           d.setUseDate(useDate);
        }

        result+=diagnosisMapper.update(d);
        }
        return result==diaIds.size();
    }

    public List<Diagnosis> selectByCondition(Diagnosis diagnosis){
        List<Diagnosis> list=diagnosisMapper.selectByCondition(diagnosis);
        return list;
    }

    public Diagnosis getDetail(JSONObject object){
        Integer diaId=object.getInt("diaId");
        Diagnosis d=diagnosisMapper.getById(diaId);
        d.setDiagnosisMedicines(diagnosisMedicineMapper.getBydiaId(diaId));
        return d;
    }
}


