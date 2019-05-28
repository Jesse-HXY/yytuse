package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.RegistrationLevel;


import java.util.List;

public interface RegistrationLevelMapper {
    void deleteByPrimaryKey(Integer rLId);

    void insert(RegistrationLevel record);

    List<RegistrationLevel> getRegistrationLevel(RegistrationLevel registrationlevel);

    List<RegistrationLevel> getAllRegistrationLevel();

    void updateByPrimaryKeySelective(RegistrationLevel record);


}