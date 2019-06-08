package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExaminationTemplateUser;
import com.neuedu.hospital_back.po.ExamnationTemplate;

import java.util.List;

public interface ExaminationTemplateUserMapper {

    int insert(ExaminationTemplateUser record);

    int deleteByETId(Integer eTId);
}