package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicineMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Medicine record);

    int updateByPrimaryKeySelective(Medicine record);

    List<Medicine> selectMedicineByMName(@Param("mName")String mName,@Param("mType")String mType);
}