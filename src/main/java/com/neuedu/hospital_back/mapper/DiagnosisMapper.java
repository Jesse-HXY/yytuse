package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Diagnosis;
import com.neuedu.hospital_back.po.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiagnosisMapper {
    int deleteByPrimaryKey(Integer diaId);

    int insert(Diagnosis record);

    int getUnnameCount();

    int update(Diagnosis diagnosis);

    List<Diagnosis> selectByCondition(Diagnosis d);

    Diagnosis getById(Integer diaId);

    List<Diagnosis> selectHistoryDiagnosis(Integer uId);

    List<Diagnosis>  getDetailByrIdAndTime(@Param("rId") Integer rId,@Param("useTime") long useTime);

    List<Medicine> getDetailByrId(Integer rId);
}