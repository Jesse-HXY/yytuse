package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.DiagnosisMedicine;
import com.neuedu.hospital_back.po.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiagnosisMedicineMapper {
    int deleteByPrimaryKey(Integer diaId);

    int insert(DiagnosisMedicine record);

    List<Medicine> getBydiaId(Integer diaId);

    int deleteByPrimaryKeyAndMId(@Param("diaId") Integer diaId, @Param("mId") Integer mId);

    int updateByKey(DiagnosisMedicine d);

    int updateBymIdAndDiaId(DiagnosisMedicine d);

    List<Medicine> getPopularMedicine();
}