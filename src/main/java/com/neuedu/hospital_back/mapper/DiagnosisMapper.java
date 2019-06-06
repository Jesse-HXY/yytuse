package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Diagnosis;

import java.util.List;

public interface DiagnosisMapper {
    int deleteByPrimaryKey(Integer diaId);

    int insert(Diagnosis record);

    int getUnnameCount();

    int update(Diagnosis diagnosis);

    List<Diagnosis> selectByCondition(Diagnosis d);

    Diagnosis getById(Integer diaId);
}