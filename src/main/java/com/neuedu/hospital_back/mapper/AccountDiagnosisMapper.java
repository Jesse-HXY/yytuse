package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.AccountDiagnosis;
import org.apache.ibatis.annotations.Param;

public interface AccountDiagnosisMapper {
    int insert(@Param("accId")Integer accId,@Param("dia_M_Id")Integer dia_M_Id);

    int getAccId(@Param("dia_M_Id")Integer dia_M_Id);

    int deleteBydia_M_Id(@Param("dia_M_Id")Integer dia_M_Id);
}