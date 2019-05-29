package com.neuedu.hospital_back.mapper;


import com.neuedu.hospital_back.po.Disease;

import java.util.List;

public interface DiseaseMapper {

    int insert(Disease record);

    List<String> getDiseaseType();

    List<Disease> getDiseases(Disease disease);
}