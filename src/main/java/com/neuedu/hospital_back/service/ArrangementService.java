package com.neuedu.hospital_back.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.neuedu.hospital_back.mapper.ArrangementMapper;
import com.neuedu.hospital_back.po.Arrangement;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class ArrangementService {

    @Resource
    private ArrangementMapper arrangementMapper;


    public int deleteByPrimaryKey(Integer aId) {
        return arrangementMapper.deleteByPrimaryKey(aId);
    }


    public boolean updateByPrimaryKeySelective(JSONObject object) {
        //前提：获取到的开始结束时间在当日时间之后
        JSONArray array = object.getJSONArray("plan");
        String dId = object.getString("dId");
        Date begin = Date.valueOf(object.getString("beginDate"));
        Date end = Date.valueOf(object.getString("endDate"));

        int result = 0;
        for (int i = 0; i < array.size(); i++) {
            Arrangement a = new Arrangement();
            JSONObject object1 = array.getJSONObject(i);
            a.setuId(object1.getInt("uId"));
            a.setaBegin(begin);
            a.setaEnd(end);
            System.out.println(begin);
            System.out.println(end);
            a.setPlan(object1.getInt("plan"));
            a.setdId(dId);
            //删除所有开始结束都在新时间段中间的排班
            arrangementMapper.deleteBetweenBeginEnd(a);
            //传过来的list已经按照时间排好
            List<Arrangement> list = arrangementMapper.getArrangementByUIdAndDId(a);
            //获取list大小，若为1则只与一条排班有关,若为二，则处于两条排班之间，若为零，说明可直接覆盖
            //均需要将新的排班加入旧排班
            arrangementMapper.insert(a);
            if (list.size() == 1) {
                //开始时间在覆盖前开始之前，结束时间在覆盖前开始时间之后，在结束时间之前
                if (begin.compareTo(list.get(0).getaBegin()) <= 0 && end.compareTo(list.get(0).getaBegin()) > 0 && end.compareTo(list.get(0).getaEnd()) < 0) {

                    Arrangement arrangement2 = new Arrangement(list.get(0).getaId(), a.getuId(), list.get(0).getPlan(), getDate(end, 1), list.get(0).getaEnd(), dId);//旧排班更新
                    result = arrangementMapper.updateByPrimaryKeySelective(arrangement2);

                } else if (begin.compareTo(list.get(0).getaBegin()) > 0 && begin.compareTo(list.get(0).getaEnd()) < 0 && end.compareTo(list.get(0).getaEnd()) >= 0) {
                    //开始日期在覆盖前开始日期之后，在结束日期之前,结束日期在覆盖前结束日期之后
                    Arrangement arrangement2 = new Arrangement(list.get(0).getaId(), a.getuId(), list.get(0).getPlan(), list.get(0).getaBegin(), getDate(begin, -1), dId);
                    result = arrangementMapper.updateByPrimaryKeySelective(arrangement2);

                } else if (begin.compareTo(list.get(0).getaBegin()) < 0 && end.compareTo(list.get(0).getaEnd()) > 0) {
                    //开始日期在覆盖前开始日期之后结束日期在覆盖前结束日期之前
                    Arrangement arrangement2 = new Arrangement(list.get(0).getaId(), a.getuId(), list.get(0).getPlan(), list.get(0).getaBegin(), getDate(begin, -1), dId);//旧排班更新
                    Arrangement arrangement3 = new Arrangement(a.getuId(), list.get(0).getPlan(), getDate(end, 1), list.get(0).getaEnd(), dId);
                    result = arrangementMapper.updateByPrimaryKeySelective(arrangement2);
                    result = arrangementMapper.insert(arrangement3);
                }
            } else if (list.size() == 2) {
                Arrangement arrangement2 = new Arrangement(list.get(0).getaId(), a.getuId(), list.get(0).getPlan(), list.get(0).getaBegin(), getDate(begin, -1), dId);
                Arrangement arrangement3 = new Arrangement(list.get(1).getaId(), a.getuId(), list.get(1).getPlan(), getDate(end, 1), list.get(1).getaEnd(), dId);
                result = arrangementMapper.updateByPrimaryKeySelective(arrangement2);
                result = arrangementMapper.updateByPrimaryKeySelective(arrangement3);

            }

        }
        return result == 1;

    }

    private static Date getDate(Date date, int days) {
        java.util.Date date1;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        date1 = cal.getTime();
        return new Date(date1.getTime());
    }


}

