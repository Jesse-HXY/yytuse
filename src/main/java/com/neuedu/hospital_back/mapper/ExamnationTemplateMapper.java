package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExamnationTemplate;

import java.util.List;

public interface ExamnationTemplateMapper {
    int deleteByPrimaryKey(Integer eTId);

    int insert(ExamnationTemplate record);

    List<ExamnationTemplate> selectByCondition(ExamnationTemplate examnationTemplate);

    int updateByPrimaryKeySelective(ExamnationTemplate record);
}