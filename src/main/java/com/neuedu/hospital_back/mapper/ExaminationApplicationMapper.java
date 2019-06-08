package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExaminationApplication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationApplicationMapper {

    int insert(ExaminationApplication examinationApplication);

    ExaminationApplication selectById(int eAId);

    List<ExaminationApplication> selectByrId(int rId);

    List<ExaminationApplication> selectByrIdAndDId(@Param("rId") Integer rId, @Param("dId") String dId, @Param("eAStatus") String eAStatus);

    List<ExaminationApplication> selectByrIdAndStatus(@Param("rId") int rId, @Param("eAStatus") String eAStatus);

    int delete(int eAId);

    int updateStatus(@Param("eAId") int eAId, @Param("eAStatus") String eAStatus);

    int updateResult(@Param("eAId") int eAId, @Param("eAResult") String eAResult);

    int updateStatusAndTime(@Param("eAId") int eAId, @Param("eAStatus") String eAStatus, @Param("beginTime") long beginTime);
}
