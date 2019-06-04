package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExamnationTemplateExamnationItem;

public interface ExamnationTemplateExamnationItemMapper {
  //  int deleteByPrimaryKey(Integer eT_EI_Id);

    int deleteByETId(Integer eTId);
    int insert(ExamnationTemplateExamnationItem record);

  //  int updateByPrimaryKeySelective(ExamnationTemplateExamnationItem record);
}