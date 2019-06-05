package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.ExaminationApplicationMapper;
import com.neuedu.hospital_back.po.ExaminationApplication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExaminationApplicationService {

    @Resource
    private ExaminationApplicationMapper examinationApplicationMapper;

    public ExaminationApplication insertAndGet(ExaminationApplication examinationApplication){
        examinationApplicationMapper.insert(examinationApplication);
        return examinationApplicationMapper.selectById(examinationApplication.geteAId());
    }
}
