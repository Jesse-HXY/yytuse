package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.AccountDiagnosis;
import org.apache.ibatis.annotations.Param;

public interface AccountDiagnosisMapper {
    int insert(@Param("accId")Integer accId,@Param("mId")Integer mId);
}