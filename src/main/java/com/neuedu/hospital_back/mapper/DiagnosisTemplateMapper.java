package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.DiagnosisTemplate;
import com.neuedu.hospital_back.po.ExamnationItem;
import com.neuedu.hospital_back.po.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiagnosisTemplateMapper {
    int deleteByPrimaryKey(Integer datId);

    int insert(DiagnosisTemplate record);

    List<DiagnosisTemplate> selectByCondition(@Param("datName") String datName, @Param("datScope")String datScope, @Param("diaType")String diaType);

    List<DiagnosisTemplate> selectDiagnosisTemplateBydId(@Param("datName") String datName, @Param("diaType")String diaType, @Param("dId")String dId);

    List<DiagnosisTemplate> selectDiagnosisTemplateByuId(@Param("datName") String datName,@Param("diaType")String diaType,@Param("uId")int uId);

    DiagnosisTemplate selectDiagnosisTemplateBydatId(Integer datId);

    List<Medicine> selectMedicineBydatId(Integer datId);
    int updateByPrimaryKeySelective(DiagnosisTemplate record);
}