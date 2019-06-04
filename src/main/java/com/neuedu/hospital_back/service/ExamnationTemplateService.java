package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.ExaminationTemplateDepartmentMapper;
import com.neuedu.hospital_back.mapper.ExaminationTemplateUserMapper;
import com.neuedu.hospital_back.po.ExaminationTemplateDepartment;
import com.neuedu.hospital_back.po.ExaminationTemplateUser;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.neuedu.hospital_back.po.ExamnationTemplate;
import com.neuedu.hospital_back.mapper.ExamnationTemplateMapper;
@Service
public class ExamnationTemplateService{

    @Resource
    private ExamnationTemplateMapper examnationTemplateMapper;

    @Resource
    private ExaminationTemplateUserMapper examinationTemplateUserMapper;

    @Resource
    private ExaminationTemplateDepartmentMapper examinationTemplateDepartmentMapper;

    
    public int deleteByPrimaryKey(Integer eTId) {
        return examnationTemplateMapper.deleteByPrimaryKey(eTId);
    }

    
    public boolean insert(JSONObject object) {

        ExamnationTemplate examnationTemplate=new ExamnationTemplate();
        examnationTemplate.seteTName(object.getString("eTName"));
        long rDate=object.getInt("eTDate")/1000;
        examnationTemplate.seteTDate(rDate);
        String eTScope=object.getString("eTScope");
        examnationTemplate.seteTScope(eTScope);
        examnationTemplate.setRecordType(object.getString("recordType"));
        int result=examnationTemplateMapper.insert(examnationTemplate);
        int eTId=examnationTemplate.geteTId();
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
        return result==1;
    }

    
    public int updateByPrimaryKeySelective(ExamnationTemplate record) {
        return examnationTemplateMapper.updateByPrimaryKeySelective(record);
    }

}
