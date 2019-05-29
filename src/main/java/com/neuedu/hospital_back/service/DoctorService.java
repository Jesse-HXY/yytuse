package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.po.Doctor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.neuedu.hospital_back.mapper.DoctorMapper;

import java.util.List;

@Service
public class DoctorService {

    @Resource
    private DoctorMapper doctorMapper;

    public List<Doctor> getDoctors(Doctor doctor) {
        return doctorMapper.getDoctors(doctor);
    }

    public boolean updateDoctor(Doctor doctor) {
        doctorMapper.updateDoctor(doctor);
        return true;
    }

    public boolean deleteDoctor(int uId) {
        doctorMapper.deleteDoctor(uId);
        return true;
    }

    public boolean insertDoctor(Doctor doctor) {
        doctorMapper.insertDoctor(doctor);
        return true;
    }
}


