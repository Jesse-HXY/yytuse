package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Arrangementregulation;

import java.util.List;

public interface ArrangementregulationMapper {
    void deleteByPrimaryKey(String arId);

    void insert(Arrangementregulation record);

    List<Arrangementregulation> selectByDId(String dId);
}