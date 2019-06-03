package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Registration;

import java.util.List;

public interface RegistrationMapper {

    int insertRegistration(Registration registration);

    List<Registration> getRegistration(String pId);
}
