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
        registrationlevelMapper.deleteByPrimaryKey(rLId.getInt("rLId"));
        return true;
    }

    public boolean insert(RegistrationLevel record) {
        registrationlevelMapper.insert(record);

        return true;
    }

    public List<RegistrationLevel> selectByPrimaryKey(RegistrationLevel registrationLevel) {
        return registrationlevelMapper.getRegistrationLevel(registrationLevel);
    }

    public List<RegistrationLevel> selectAll() {
        return registrationlevelMapper.getAllRegistrationLevel();
    }


    public boolean updateByPrimaryKeySelective(RegistrationLevel record) {
        registrationlevelMapper.updateByPrimaryKeySelective(record);
        return true;
    }


}
