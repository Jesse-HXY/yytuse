package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.po.Doctor;import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.neuedu.hospital_back.mapper.DoctorMapper;

@Service
public class DoctorService {

    @Resource
    private DoctorMapper doctorMapper;

    public int deleteByPrimaryKey(Integer uId) {
        return doctorMapper.deleteByPrimaryKey(uId);
    }

    public int insertSelective(Doctor record) {
        return doctorMapper.insertSelective(record);
    }

    public int updateByPrimaryKeySelective(Doctor record) {
        return doctorMapper.updateByPrimaryKeySelective(record);
    }
}

