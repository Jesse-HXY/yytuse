package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Disease;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiseaseMapper {
    int deleteByPrimaryKey(Integer disId);

    int updateByPrimaryKeySelective(Disease record);

    int insert(Disease record);

    int getDiseaseCount(String disType);

    List<String> getDiseaseType();

    List<Disease> getDiseases(Disease disease);

    List<Disease> getDiseaseByType(String disType);

    Disease getById(Integer disId);

    List<Disease> getDiseaseByPage(@Param("disType")String disType,@Param("begin")int begin, @Param("pageSize")int pageSize);

}