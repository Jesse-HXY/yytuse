package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExamnationItem;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface ExamnationitemMapper {
    int deleteByPrimaryKey(Integer eIId);

    int insert(ExamnationItem record);

    int updateByPrimaryKeySelective(ExamnationItem record);

    int getExamnationItemCount();

    List<ExamnationItem> selectExamnationItemByeIName(@Param("eIName") String eIName,@Param("recordType")String recordType);

    List<ExamnationItem> selectExamnationItem(ExamnationItem examnationItem);

    List<ExamnationItem> selectAllExamnationItem();

    List<ExamnationItem> selectExamnationItemByPage(@Param("begin") int begin, @Param("pageSize") int pageSize);
}