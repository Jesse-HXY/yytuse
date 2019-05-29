package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Doctor;

import java.util.List;

public interface DoctorMapper {

    int updateDoctor(Doctor doctor);

    int deleteDoctor(int uId);

    int insertDoctor(Doctor doctor);

    List<Doctor> getDoctors(Doctor doctor);
}