package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DiseaseMapper;
import com.neuedu.hospital_back.po.Disease;
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

    public List<Disease> getDiseases(Disease disease) {
        List<Disease> diseases = diseaseMapper.getDiseases(disease);
        return diseases;
    }

    public int insert(Disease record) {
        return diseaseMapper.insert(record);
    }
}


