package com.neuedu.hospital_back.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.neuedu.hospital_back.mapper.DoctorArrangementRegulationMapper;
import com.neuedu.hospital_back.po.DoctorArrangementRegulation;

@Service
public class DoctorArrangementRegulationService {

    @Resource
    private DoctorArrangementRegulationMapper doctorArrangementRegulationMapper;


    public int deleteByPrimaryKey(Integer do_Ar_Id) {
        return doctorArrangementRegulationMapper.deleteByPrimaryKey(do_Ar_Id);
    }


    public int insert(DoctorArrangementRegulation record) {
        return doctorArrangementRegulationMapper.insert(record);
    }


    public int updateByPrimaryKeySelective(DoctorArrangementRegulation record) {
        return doctorArrangementRegulationMapper.updateByPrimaryKeySelective(record);
    }

}

