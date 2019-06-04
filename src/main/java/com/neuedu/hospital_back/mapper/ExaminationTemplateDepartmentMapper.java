package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExaminationTemplateDepartment;

import java.util.List;

public interface ExaminationTemplateDepartmentMapper {
   // int deleteByPrimaryKey(Integer eT_dId);

    int deleteByETId(Integer eTId);
    int insert(ExaminationTemplateDepartment record);

    String getDId(int eTId);

   // int updateByPrimaryKeySelective(ExaminationTemplateDepartment record);
}