package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicineMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Medicine record);

    int updateByPrimaryKeySelective(Medicine record);

    int getMedicineCount();

    List<Medicine> getMedicineByPage(@Param("begin")int begin, @Param("pageSize")int pageSize);


    List<Medicine> selectMedicineByMName(@Param("mName")String mName,@Param("mType")String mType);

    List<Medicine> selectMedicineByCondition(Medicine medicine);
}