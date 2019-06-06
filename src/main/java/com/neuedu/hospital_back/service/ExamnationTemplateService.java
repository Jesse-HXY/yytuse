package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.*;
import com.neuedu.hospital_back.po.ExaminationTemplateDepartment;
import com.neuedu.hospital_back.po.ExaminationTemplateUser;
import com.neuedu.hospital_back.po.ExamnationTemplateExamnationItem;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.neuedu.hospital_back.po.ExamnationTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamnationTemplateService {

    @Resource
    private ExamnationTemplateMapper examnationTemplateMapper;

    @Resource
    private ExaminationTemplateUserMapper examinationTemplateUserMapper;

    @Resource
    private ExaminationTemplateDepartmentMapper examinationTemplateDepartmentMapper;

    @Resource
    private ExamnationTemplateExamnationItemMapper examnationTemplateExamnationItemMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private DepartmentUserMapper departmentUserMapper;


    public boolean deleteByPrimaryKey(JSONObject object) {
        String dId = object.getString("dId");
        Integer uId = object.getInt("uId");
        Integer eTId = object.getInt("eTId");
        String scope = object.getString("scope");
        //删除与item连接中间表
        int result;
        if (scope.equals("科室")) {
            //删除与科室相连中间表
            result = examinationTemplateDepartmentMapper.deleteByETId(eTId);
        } else if (scope.equals("个人")) {
            //删除与个人相连中间表
            result = examinationTemplateUserMapper.deleteByETId(eTId);
        }
        //删除模板表中数据
        result = examnationTemplateMapper.deleteByPrimaryKey(eTId);
        return result == 1;
    }


    public boolean insert(JSONObject object) {

        ExamnationTemplate examnationTemplate = new ExamnationTemplate();
        examnationTemplate.seteTName(object.getString("eTName"));
        long rDate = object.getLong("eTDate") / 1000;
        examnationTemplate.seteTDate(rDate);
        String eTScope = object.getString("eTScope");
        examnationTemplate.seteTScope(eTScope);
        examnationTemplate.setRecordType(object.getString("recordType"));
        int result = examnationTemplateMapper.insert(examnationTemplate);
        int eTId = examnationTemplate.geteTId();
        List<Integer> list = object.getJSONArray("eIds");
        if (eTScope.equals("个人")) {
            ExaminationTemplateUser examinationTemplateUser = new ExaminationTemplateUser();
            examinationTemplateUser.seteTId(eTId);
            examinationTemplateUser.setuId(object.getInt("uId"));
            result = examinationTemplateUserMapper.insert(examinationTemplateUser);
        } else if (eTScope.equals("科室")) {
            ExaminationTemplateDepartment examinationTemplateDepartment = new ExaminationTemplateDepartment();
            examinationTemplateDepartment.seteTId(eTId);
            examinationTemplateDepartment.setdId(object.getString("dId"));
            result = examinationTemplateDepartmentMapper.insert(examinationTemplateDepartment);
        }
        for (Integer integer : list) {
            ExamnationTemplateExamnationItem e = new ExamnationTemplateExamnationItem();
            e.seteIId(integer);
            e.seteTId(eTId);
            examnationTemplateExamnationItemMapper.insert(e);
        }
        return result == 1;
    }

    public List<ExamnationTemplate> selectByCondition(JSONObject object) {
        String recordType = object.getString("recordType");
        String eTScope = object.getString("eTScope");
        String eTName = object.getString("eTName");
        int uId = object.getInt("uId");


        switch (eTScope) {
            case "科室":
                String dId = object.getString("dId");
                return examnationTemplateMapper.selectExamnationItemBydId(eTName, recordType, dId);
            case "个人":
                return examnationTemplateMapper.selectExamnationItemByuId(eTName, recordType, uId);
            case "全院":
                return examnationTemplateMapper.selectByCondition(eTName, "全院", recordType);
            default:
                ExamnationTemplate e = new ExamnationTemplate();
                List<ExamnationTemplate> el = new ArrayList<>();
                List<String> dIdList = departmentUserMapper.selectByuId(uId);
                for (String s : dIdList) {
                    el.addAll(examnationTemplateMapper.selectExamnationItemBydId(eTName, recordType, s));
                }
                el.addAll(examnationTemplateMapper.selectExamnationItemByuId(eTName, recordType, uId));
                el.addAll(examnationTemplateMapper.selectByCondition(eTName, "全院", recordType));
                return el;
        }
    }

    public ExamnationTemplate checkDetail(JSONObject object) {
        Integer eTId = object.getInt("eTId");
        ExamnationTemplate e = examnationTemplateMapper.selectExamnationTemplateByeTId(eTId);
        e.setExamnationItemList(examnationTemplateMapper.selectExamnationItemByeTId(eTId));
        if (e.geteTScope().equals("科室")) {
            e.setDepartment(departmentMapper.getDepartmentBydId(examinationTemplateDepartmentMapper.getDId(eTId)));
        }
        return e;
    }

    public int updateByPrimaryKeySelective(ExamnationTemplate record) {
        return examnationTemplateMapper.updateByPrimaryKeySelective(record);
    }

}
