package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExaminationApplication;
import org.apache.ibatis.annotations.Param;

public interface ExaminationApplicationMapper {

    int insert(ExaminationApplication examinationApplication);

    ExaminationApplication selectById(int eAId);

    int delete(int eAId);

    int updateStatus(@Param("eAId") int eAId, @Param("eAStatus") String eAStatus);
}
