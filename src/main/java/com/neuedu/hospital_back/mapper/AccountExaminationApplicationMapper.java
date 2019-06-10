package com.neuedu.hospital_back.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountExaminationApplicationMapper {

    int insert(@Param("accId")int accId, @Param("eAId")int eAId);

    Integer getAccId(Integer eAId);

    int deleteByeAId(Integer integer);
}
