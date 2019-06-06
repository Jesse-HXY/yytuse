package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.DiagnosisMedicine;

import java.util.List;

public interface DiagnosisMedicineMapper {
    int deleteByPrimaryKey(Integer diaId);

    int insert(DiagnosisMedicine record);

    List<DiagnosisMedicine> getBydiaId(Integer diaId);
}