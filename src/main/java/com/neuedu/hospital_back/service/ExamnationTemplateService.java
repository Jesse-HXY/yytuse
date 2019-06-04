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
public class ExamnationTemplateService{

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

    
    public int deleteByPrimaryKey(Integer eTId) {
        return examnationTemplateMapper.deleteByPrimaryKey(eTId);
    }

    
    public boolean insert(JSONObject object) {

        ExamnationTemplate examnationTemplate=new ExamnationTemplate();
        examnationTemplate.seteTName(object.getString("eTName"));
        long rDate=object.getLong("eTDate")/1000;
        examnationTemplate.seteTDate(rDate);
        String eTScope=object.getString("eTScope");
        examnationTemplate.seteTScope(eTScope);
        examnationTemplate.setRecordType(object.getString("recordType"));
        int result=examnationTemplateMapper.insert(examnationTemplate);
        int eTId=examnationTemplate.geteTId();
        List<Integer> list=object.getJSONArray("eIds");
        if(eTScope.equals("个人")){
            ExaminationTemplateUser examinationTemplateUser=new ExaminationTemplateUser();
            examinationTemplateUser.seteTId(eTId);
            examinationTemplateUser.setuId(object.getInt("uId"));
           result= examinationTemplateUserMapper.insert(examinationTemplateUser);
        }else if(eTScope.equals("科室")){
            ExaminationTemplateDepartment examinationTemplateDepartment=new ExaminationTemplateDepartment();
            examinationTemplateDepartment.seteTId(eTId);
            examinationTemplateDepartment.setdId(object.getString("dId"));
           result= examinationTemplateDepartmentMapper.insert(examinationTemplateDepartment);
        }
        for(int i=0;i<list.size();i++){
            ExamnationTemplateExamnationItem e=new ExamnationTemplateExamnationItem();
            e.seteIId(list.get(i));
            e.seteTId(eTId);
            examnationTemplateExamnationItemMapper.insert(e);
        }
        return result==1;
    }

    public List<ExamnationTemplate> selectByCondition(JSONObject object){
        String recordType=object.getString("recordType");
        String eTScope=object.getString("eTScope");
        String eTName=object.getString("eTName");
        Integer uId=object.getInt("uId");


        if(eTScope.equals("科室")) {
          String dId=object.getString("dId");
           return examnationTemplateMapper.selectExamnationItemBydId(eTName,recordType,dId);
        }else if(eTScope.equals("个人")){
          return examnationTemplateMapper.selectExamnationItemByuId(eTName,recordType,uId);
        }else if(eTScope.equals("全院")){
            return examnationTemplateMapper.selectByCondition(eTName,"全院",recordType);
        }
        else {
            ExamnationTemplate e=new ExamnationTemplate();
            List<ExamnationTemplate> el=new ArrayList<>();
            List<String> dIdList=departmentUserMapper.selectByuId(uId);
            for(int i=0;i<dIdList.size();i++){
                el.addAll(examnationTemplateMapper.selectExamnationItemBydId(eTName,recordType,dIdList.get(i)));
            }
            el.addAll(examnationTemplateMapper.selectExamnationItemByuId(eTName,recordType,uId));
            el.addAll(examnationTemplateMapper.selectByCondition(eTName,"全院",recordType));
            return el;
        }
    }

    public ExamnationTemplate checkDetail(JSONObject object){
        Integer eTId=object.getInt("eTId");
        ExamnationTemplate e=examnationTemplateMapper.selectExamnationTemplateByeTId(eTId);
        e.setExamnationItemList(examnationTemplateMapper.selectExamnationItemByeTId(eTId));
        if(e.geteTScope().equals("科室")){
            e.setDepartment(departmentMapper.getDepartmentBydId(examinationTemplateDepartmentMapper.getDId(eTId)));
        }
        return e;
    }
    
    public int updateByPrimaryKeySelective(ExamnationTemplate record) {
        return examnationTemplateMapper.updateByPrimaryKeySelective(record);
    }

}
