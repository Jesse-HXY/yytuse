package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.ExaminationApplication;

public interface ExaminationApplicationMapper {

    int insert(ExaminationApplication examinationApplication);

    ExaminationApplication selectById(int eAId);
}
