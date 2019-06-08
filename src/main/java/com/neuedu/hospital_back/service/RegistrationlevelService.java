package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.RegistrationLevelMapper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.neuedu.hospital_back.po.RegistrationLevel;

import java.util.List;

@Service
public class RegistrationlevelService {

    @Resource
    private RegistrationLevelMapper registrationlevelMapper;

    public boolean deleteByPrimaryKey(JSONObject rLId) {
        return registrationlevelMapper.deleteByPrimaryKey(rLId.getInt("rLId")) == 1;
    }

    public boolean insert(RegistrationLevel record) {
        return registrationlevelMapper.insert(record) == 1;
    }

    public List<RegistrationLevel> selectByPrimaryKey(RegistrationLevel registrationLevel) {
        return registrationlevelMapper.getRegistrationLevel(registrationLevel);
    }

    public List<RegistrationLevel> selectAll() {
        return registrationlevelMapper.getAllRegistrationLevel();
    }


    public boolean updateByPrimaryKeySelective(RegistrationLevel record) {
        return registrationlevelMapper.updateByPrimaryKeySelective(record) == 1;
    }


}
