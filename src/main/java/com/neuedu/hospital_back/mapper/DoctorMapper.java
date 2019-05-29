package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Doctor;

public interface DoctorMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(Doctor record);

    int updateByPrimaryKeySelective(Doctor record);


}