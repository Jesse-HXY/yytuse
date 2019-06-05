package com.neuedu.hospital_back.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.neuedu.hospital_back.mapper.MedicineMapper;
import com.neuedu.hospital_back.po.Medicine;

import java.util.List;

@Service
public class MedicineService{

    @Resource
    private MedicineMapper medicineMapper;

    
    public int deleteByPrimaryKey(JSONObject object) {
        return medicineMapper.deleteByPrimaryKey(object.getInt("mId"));
    }

    
    public int insert(Medicine record) {
        return medicineMapper.insert(record);
    }

    public List<Medicine> selectMedicineByMName(JSONObject object){
        return medicineMapper.selectMedicineByMName(object.getString("mName"),object.getString("mType"));
    }

    public List<Medicine> selectMedicineByCondition(Medicine medicine){
        return medicineMapper.selectMedicineByCondition(medicine);
    }

    public List<Medicine> getMedicineByPage(JSONObject jsonObject){
        return medicineMapper.getMedicineByPage(jsonObject.getInt("pageNum"), jsonObject.getInt("pageSize"));
    }


    public int updateByPrimaryKeySelective(Medicine record) {
        return medicineMapper.updateByPrimaryKeySelective(record);
    }

}
