package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExamnationItem;
import com.neuedu.hospital_back.po.ExamnationTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamnationTemplateMapper {
    int deleteByPrimaryKey(Integer eTId);

    int insert(ExamnationTemplate record);

    List<ExamnationTemplate> selectByCondition(ExamnationTemplate examnationTemplate);

    List<ExamnationTemplate> selectExamnationItemBydId(@Param("eTName") String eTName, @Param("recordType")String recordType, @Param("dId")String dId);

    List<ExamnationTemplate> selectExamnationItemByuId(@Param("eTName") String eTName,@Param("recordType")String recordType,@Param("uId")int uId);

    int updateByPrimaryKeySelective(ExamnationTemplate record);
}