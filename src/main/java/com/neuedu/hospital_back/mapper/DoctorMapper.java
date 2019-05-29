package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Doctor;

import java.util.List;

public interface DoctorMapper {
    void updateDoctor(Doctor doctor);

    void deleteDoctor(int uId);

    void insertDoctor(Doctor doctor);

    List<Doctor> getDoctors(Doctor doctor);
}