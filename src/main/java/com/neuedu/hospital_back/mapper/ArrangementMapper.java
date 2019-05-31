package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Arrangement;import org.apache.ibatis.annotations.Param;import java.sql.Date;import java.util.List;

public interface ArrangementMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Arrangement record);

    int updateByPrimaryKeySelective(Arrangement record);

    int deleteBetweenBeginEnd(Arrangement arrangement);

    List<Arrangement> getArrangementByUIdAndDId(Arrangement arrangement);


}