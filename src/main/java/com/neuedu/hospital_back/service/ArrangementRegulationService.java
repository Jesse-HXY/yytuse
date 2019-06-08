package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.ArrangementListMapper;
import com.neuedu.hospital_back.mapper.DoctorArrangementRegulationMapper;
import com.neuedu.hospital_back.po.ArrangementList;
import com.neuedu.hospital_back.po.DoctorArrangementRegulation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.neuedu.hospital_back.po.ArrangementRegulation;
import com.neuedu.hospital_back.mapper.ArrangementRegulationMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrangementRegulationService {

    @Resource
    private ArrangementRegulationMapper arrangementregulationMapper;
    @Resource
    private DoctorArrangementRegulationMapper doctorArrangementRegulationMapper;
    @Resource
    private ArrangementListMapper arrangementListMapper;


    public int deleteByPrimaryKey(String arId) {
        return arrangementregulationMapper.deleteByPrimaryKey(arId);
    }


    public boolean insert(JSONObject object) {
        ArrangementRegulation arrangementRegulation = new ArrangementRegulation();
        arrangementRegulation.setArName(object.getString("aRName"));
        arrangementRegulation.setdId(object.getString("dId"));
        arrangementRegulation.setrLName(object.getString("rLName"));
        int result = arrangementregulationMapper.insert(arrangementRegulation);
        //得到自动添加的主键
        int arId = arrangementRegulation.getArId();
        //得到userId,arPlan列表
        JSONArray array = object.getJSONArray("resultList");
        DoctorArrangementRegulation doctorArrangementRegulation = new DoctorArrangementRegulation();
        for (int i = 0; i < array.size(); i++) {
            JSONObject object1 = array.getJSONObject(i);
            doctorArrangementRegulation.setuId(object1.getInt("uId"));
            doctorArrangementRegulation.setArPlan(object1.getInt("aRPlan"));
            doctorArrangementRegulation.setArId(arId);
            result = doctorArrangementRegulationMapper.insert(doctorArrangementRegulation);
        }

        return result == 1;
    }

    public List<ArrangementList> getArrangementList(JSONObject object) {
        List<ArrangementList> arrangementLists = arrangementListMapper.getArrangementList(object.getString("dId"));
        for (ArrangementList arrangementList : arrangementLists) {
            arrangementList.setArPlanList(getPlanList(arrangementList.getArPlan()));
        }
        return arrangementLists;
    }


    private int[] getPlanList(int n) {
        int[] arPlanList = new int[14];
        int i = 13;
        while (n != 0) {
            if ((n & 1) == 1) {
                arPlanList[i] = 1;
            }
            i--;
            //将n右移一位
            n = n >> 1;
        }
        return arPlanList;
    }

    public int updateByPrimaryKeySelective(ArrangementRegulation record) {
        return arrangementregulationMapper.updateByPrimaryKeySelective(record);
    }

}





