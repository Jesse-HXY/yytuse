package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Arrangement;
import org.apache.ibatis.annotations.Param;


import java.sql.Date;
import java.util.List;

public interface ArrangementMapper {
    void deleteByPrimaryKey(Integer aId);

    void insert(Arrangement record);

    void updateByPrimaryKeySelective(Arrangement record);

    List<Arrangement> selectByBeginAndEnd(@Param("aBegin") Date aBegin,@Param("aEnd")Date aEnd);
}