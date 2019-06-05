package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExaminationApplication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationApplicationMapper {

    int insert(ExaminationApplication examinationApplication);

    ExaminationApplication selectById(int eAId);

    List<ExaminationApplication> selectByrId(int rId);

    int delete(int eAId);

    int updateStatus(@Param("eAId") int eAId, @Param("eAStatus") String eAStatus);
}
