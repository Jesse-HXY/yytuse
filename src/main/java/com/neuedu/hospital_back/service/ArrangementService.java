package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.ArrangementRegulationMapper;
import com.neuedu.hospital_back.mapper.DoctorArrangementRegulationMapper;
import com.neuedu.hospital_back.po.DoctorArrangementRegulation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.neuedu.hospital_back.mapper.ArrangementMapper;
import com.neuedu.hospital_back.po.Arrangement;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArrangementService {

    @Resource
    private ArrangementMapper arrangementMapper;

    @Resource
    private ArrangementRegulationMapper arrangementRegulationMapper;

    @Resource
    private DoctorArrangementRegulationMapper doctorArrangementRegulationMapper;


    public int deleteByPrimaryKey(Integer aId) {
        return arrangementMapper.deleteByPrimaryKey(aId);
    }


    public boolean insert(JSONObject object) {
        JSONArray array = object.getJSONArray("plan");
        String dId=object.getString("dId");
        Date begin=Date.valueOf(object.getString("beginDate"));
        Date end=Date.valueOf(object.getString("endDate"));

        int result=0;
        for (int i=0;i<array.size();i++){
            Arrangement a=new Arrangement();
            JSONObject object1=array.getJSONObject(i);
            a.setuId(object1.getInt("uId"));
            a.setaBegin(begin);
            a.setaEnd(end);
            a.setPlan(object1.getInt("plan"));
            a.setdId(dId);
            result= arrangementMapper.insert(a);
        }
        return result==1;
    }


    public int updateByPrimaryKeySelective(Arrangement record) {
        return arrangementMapper.updateByPrimaryKeySelective(record);
    }

}

