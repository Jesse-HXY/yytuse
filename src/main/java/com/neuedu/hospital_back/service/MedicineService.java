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
    
    public int updateByPrimaryKeySelective(Medicine record) {
        return medicineMapper.updateByPrimaryKeySelective(record);
    }

}
