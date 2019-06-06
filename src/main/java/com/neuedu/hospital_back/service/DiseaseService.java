package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DiseaseMapper;
import com.neuedu.hospital_back.po.Disease;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiseaseService {

    @Resource
    private DiseaseMapper diseaseMapper;

    public List<String> getDiseaseType() {
        return diseaseMapper.getDiseaseType();

    }

    public List<Disease> getDiseaseByType(String disType) {
        return diseaseMapper.getDiseaseByType(disType);
    }

    public List<Disease> getDiseaseByPage(JSONObject object) {
        return diseaseMapper.getDiseaseByPage(object.getString("disType"), object.getInt("pageNum"), object.getInt("pageSize"));
    }

    public List<Disease> getDiseases(Disease disease) {
        return diseaseMapper.getDiseases(disease);
    }

    public boolean insert(Disease record) {
        return diseaseMapper.insert(record) == 1;

    }

    public boolean updateDisease(Disease disease) {
        return diseaseMapper.updateByPrimaryKeySelective(disease) == 1;

    }

    public boolean deleteDisease(JSONObject disId) {
        return diseaseMapper.deleteByPrimaryKey(disId.getInt("disId")) == 1;

    }

    public int getDiseaseCount() {
        return diseaseMapper.getDiseaseCount();
    }
}


