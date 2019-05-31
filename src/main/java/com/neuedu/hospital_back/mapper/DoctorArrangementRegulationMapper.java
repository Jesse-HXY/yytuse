package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.DoctorArrangementRegulation;

public interface DoctorArrangementRegulationMapper {

    int deleteByPrimaryKey(Integer do_Ar_Id);

    int insert(DoctorArrangementRegulation record);

    int updateByPrimaryKeySelective(DoctorArrangementRegulation record);
}