package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExamnationTemplate;

public interface ExamnationTemplateMapper {
    int deleteByPrimaryKey(Integer eTId);

    int insert(ExamnationTemplate record);

    int updateByPrimaryKeySelective(ExamnationTemplate record);
}