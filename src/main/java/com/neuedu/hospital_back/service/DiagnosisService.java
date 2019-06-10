package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.*;
import com.neuedu.hospital_back.po.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.xmlbeans.impl.jam.JSourcePosition;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
    private DiseaseMapper diseaseMapper;

    @Resource
    private MedicalRecordMapper medicalRecordMapper;


    public boolean insertMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordMapper.insertMedicalRecord(medicalRecord) == 1;
    }

    public List<DiagnosisType> getDiagnosisTypeByrId(JSONObject object) {
        List<DiagnosisType> diagnosisTypes = diagnosisTypeMapper.getByrId(object.getInt("rId"));
        for (DiagnosisType diagnosisType : diagnosisTypes) {
            diagnosisType.setDisease(diseaseMapper.getById(diagnosisType.getDisId()));
        }
        return diagnosisTypes;
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
        List<Integer> diaIds = object.getJSONArray("diaIdList");
        for (Integer diaId : diaIds) {
            result += diagnosisMapper.deleteByPrimaryKey(diaId);
            diagnosisMedicineMapper.deleteByPrimaryKey(diaId);
        }
        return result == diaIds.size();
    }

    public Diagnosis insertDiagnosis(JSONObject object) {

        String diaName = object.getString("diaName");
        if (diaName.equals("")) {
            diaName = "新增" + String.valueOf(diagnosisMapper.getUnnameCount() + 1);
        }
        String diaType = object.getString("diaType");
        Integer rId = object.getInt("rId");
        Long createDate = System.currentTimeMillis() / 1000;
        String diaState = "暂存";
        Integer uId=object.getInt("uId");
        Diagnosis d = new Diagnosis(diaType, rId, diaName, createDate, diaState,uId);
        diagnosisMapper.insert(d);
        d.setDiaId(d.getDiaId());
        return d;
    }

    public boolean insertDiagnosisMedicine(JSONObject object) {
        Integer diaId = object.getInt("diaId");
        String dId = object.getString("dId");
        JSONArray jsonArray = object.getJSONArray("diagnosisMedicine");
//        List<DiagnosisType> diagnosisTypes = (List<DiagnosisType>) JSONArray.toArray(jsonArray, DiagnosisType.class);
        List<DiagnosisMedicine> diagnosisMedicines = (List) JSONArray.toCollection(jsonArray, DiagnosisMedicine.class);
        int result = 0;
        System.out.println(diagnosisMedicines.toString());
        for (DiagnosisMedicine d : diagnosisMedicines) {
            d.setDiaId(diaId);
            d.setdId(dId);
            result += diagnosisMedicineMapper.insert(d);
        }
        return result == diagnosisMedicines.size();
    }

    public boolean updateState(JSONObject object) {
        String diaState = object.getString("diaState");
        Long useDate = System.currentTimeMillis() / 1000;
        int result = 0;
        List<Integer> diaIds = object.getJSONArray("diaIdList");
        for (Integer diaId : diaIds) {
            Diagnosis d = new Diagnosis();
            d.setDiaId(diaId);
            d.setDiaState(diaState);
            if (diaState.equals("开立")) {
                d.setUseDate(useDate);
            }

            result += diagnosisMapper.update(d);
        }
        return result == diaIds.size();
    }

    public boolean updateDiaFee(JSONObject object){
        Integer diaId=object.getInt("diaId");
        Diagnosis d=new Diagnosis();
        d.setDiaId(diaId);
        d.setDiaFee(object.getDouble("diaFee"));
        return diagnosisMapper.update(d)==1;
    }

    public boolean updateBydiaId(JSONObject object){
        Integer diaId=object.getInt("diaId");
       /* JSONArray jsonArray = object.getJSONArray("diagnosisMedicine");
        List<DiagnosisMedicine> list=(List) JSONArray.toCollection(jsonArray, DiagnosisMedicine.class);
    */
       int result = 0;
        DiagnosisMedicine d=new DiagnosisMedicine();
        d.setDiaId(diaId);
        d.setmId(object.getInt("mId"));
        d.setmAmount(object.getInt("mAmount"));
        result += diagnosisMedicineMapper.updateBymIdAndDiaId(d);
      /*  for (DiagnosisMedicine d : list) {

        }
        return result==list.size();*/
      return result==1;
    }

    public boolean updateMStateBydia_M_Id(JSONObject object){
        List<Integer> dia_M_Id=object.getJSONArray("dia_M_Id");
      int re=0;
       for(Integer i:dia_M_Id){
           DiagnosisMedicine d=new DiagnosisMedicine();
           d.setmState(object.getString("mState"));
           d.setDia_M_Id(i);
         re+=  diagnosisMedicineMapper.updateByKey(d);
       }

        return re==dia_M_Id.size();
    }

    public List<Diagnosis> selectByCondition(Diagnosis diagnosis) {
        return diagnosisMapper.selectByCondition(diagnosis);
    }

    public Diagnosis getDetail(JSONObject object) {
        int diaId = object.getInt("diaId");
        Diagnosis d = diagnosisMapper.getById(diaId);
        d.setMedicines(diagnosisMedicineMapper.getBydiaId(diaId));
        return d;
    }

    public List<Medicine> getDetailByrId(JSONObject object){
        Integer rId=object.getInt("rId");
       String mState=object.getString("mState");
        List<Medicine> d=diagnosisMapper.getDetailByrId(rId,mState);
        return d;

    }

    public boolean deleteMedicineFromDiagnosis(JSONObject object) {
        Integer diaId = object.getInt("diaId");
        int r = 0;
        List<Integer> mIds = object.getJSONArray("mIds");
        for (Integer mId : mIds) {
            r += diagnosisMedicineMapper.deleteByPrimaryKeyAndMId(diaId, mId);
        }
        return r==mIds.size();
   }

   public List<Diagnosis> selectHistoryDiagnosis(JSONObject object){
        Integer uId=object.getInt("uId");
        return diagnosisMapper.selectHistoryDiagnosis(uId);
   }


   public List<Medicine> getPopularMedicine(){
       return diagnosisMedicineMapper.getPopularMedicine();
   }


}


