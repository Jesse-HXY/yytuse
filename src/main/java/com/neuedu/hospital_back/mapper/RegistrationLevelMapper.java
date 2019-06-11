package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.RegistrationLevel;


import java.util.List;

public interface RegistrationLevelMapper {
    int deleteByPrimaryKey(Integer rLId);

    int insert(RegistrationLevel record);

    List<RegistrationLevel> getRegistrationLevel(RegistrationLevel registrationlevel);

    List<RegistrationLevel> getAllRegistrationLevel();

    int updateByPrimaryKeySelective(RegistrationLevel record);

    int getLimitationByName(String rLName);
}