package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.DiagnosisTemplateMedicine;

public interface DiagnosisTemplateMedicineMapper {
    int insert(DiagnosisTemplateMedicine record);

    int deleteBydatId(Integer datId);

    int updateBydatIdAndmId(DiagnosisTemplateMedicine record);
}