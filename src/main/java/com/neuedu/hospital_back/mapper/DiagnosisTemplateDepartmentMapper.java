package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.DiagnosisTemplateDepartment;

public interface DiagnosisTemplateDepartmentMapper {
    int insert(DiagnosisTemplateDepartment record);

    int deleteBydatId(Integer datId);

    String getDId(Integer datId);
}