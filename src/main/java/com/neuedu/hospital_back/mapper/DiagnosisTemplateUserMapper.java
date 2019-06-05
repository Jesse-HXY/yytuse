package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.DiagnosisTemplateUser;

public interface DiagnosisTemplateUserMapper {
    int insert(DiagnosisTemplateUser record);

    int deleteBydatId(Integer datId);
}