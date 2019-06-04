package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExaminationTemplateUser;

public interface ExaminationTemplateUserMapper {
    int deleteByPrimaryKey(Integer eT_uId);

    int insert(ExaminationTemplateUser record);

    int updateByPrimaryKeySelective(ExaminationTemplateUser record);
}