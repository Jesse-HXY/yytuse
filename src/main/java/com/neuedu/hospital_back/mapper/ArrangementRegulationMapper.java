package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ArrangementRegulation;

public interface ArrangementRegulationMapper {
    int deleteByPrimaryKey(String arId);

    int insert(ArrangementRegulation record);

    int updateByPrimaryKeySelective(ArrangementRegulation record);
}