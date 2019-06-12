package com.neuedu.hospital_back.mapper;

import org.apache.ibatis.annotations.Param;

public interface WorkloadsCountMapper {

    double getFeesByPostDId(@Param("postDId") String postDId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime, @Param("feeType") String feeType);

    double getFeesBydId(@Param("dId") String dId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime, @Param("feeType") String feeType);

    double getFeesByuId(@Param("uId") Integer uId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime, @Param("feeType") String feeType);

    double getFeesBycIdOnFeeType(@Param("cId") Integer cId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime, @Param("feeType") String feeType);

    double getFeesBycIdOnPayType(@Param("cId") Integer cId, @Param("beginTime") Long beginTime, @Param("endTime") Long endTime, @Param("payType") String payType);

}
