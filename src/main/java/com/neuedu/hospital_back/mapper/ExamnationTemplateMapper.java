package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExamnationItem;
import com.neuedu.hospital_back.po.ExamnationTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamnationTemplateMapper {
    int deleteByPrimaryKey(Integer eTId);

    int insert(ExamnationTemplate record);

    List<ExamnationTemplate> selectByCondition(@Param("eTName") String eTName,@Param("eTScope")String eTScope, @Param("recordType")String recordType);

    List<ExamnationTemplate> selectExamnationItemBydId(@Param("eTName") String eTName, @Param("recordType")String recordType, @Param("dId")String dId);

    List<ExamnationTemplate> selectExamnationItemByuId(@Param("eTName") String eTName,@Param("recordType")String recordType,@Param("uId")int uId);

    ExamnationTemplate selectExamnationTemplateByeTId(Integer eTId);

    List<ExamnationItem> selectExamnationItemByeTId(Integer eTId);

    int updateByPrimaryKeySelective(ExamnationTemplate record);
}