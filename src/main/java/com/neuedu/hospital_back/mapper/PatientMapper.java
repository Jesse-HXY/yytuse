package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Patient;

public interface PatientMapper {

    int insert(Patient patient);

    Patient getById(String  pId);
}
