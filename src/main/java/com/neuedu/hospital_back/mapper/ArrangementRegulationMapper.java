package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ArrangementRegulation;

import java.util.List;

public interface ArrangementRegulationMapper {
    int deleteByPrimaryKey(String arId);

    int insert(ArrangementRegulation record);

    int updateByPrimaryKeySelective(ArrangementRegulation record);

}