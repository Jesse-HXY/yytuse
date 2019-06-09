package com.neuedu.hospital_back.mapper;

import org.apache.ibatis.annotations.Param;

public interface WorkloadsCountMapper {

    double getFeesByPostDId(@Param("postDId") String postDId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime, @Param("feeType") String feeType );

    double getFeesBydId(@Param("dId") String dId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime, @Param("feeType") String feeType );
}
