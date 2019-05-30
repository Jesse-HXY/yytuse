package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ArrangementList;

import java.util.List;

public interface ArrangementListMapper {
    List<ArrangementList> getArrangementList(String dId);
}
