package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.DiagnosisType;

import java.util.List;

public interface DiagnosisTypeMapper {

    int insert(DiagnosisType diagnosisType);

    List<DiagnosisType> getByrId(int rId);
}
