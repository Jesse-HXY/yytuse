package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.ExaminationTemplateDepartmentMapper;
import com.neuedu.hospital_back.mapper.ExaminationTemplateUserMapper;
import com.neuedu.hospital_back.mapper.ExamnationTemplateExamnationItemMapper;
import com.neuedu.hospital_back.po.ExaminationTemplateDepartment;
import com.neuedu.hospital_back.po.ExaminationTemplateUser;
import com.neuedu.hospital_back.po.ExamnationTemplateExamnationItem;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.neuedu.hospital_back.po.ExamnationTemplate;
import com.neuedu.hospital_back.mapper.ExamnationTemplateMapper;

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

    
    public int updateByPrimaryKeySelective(ExamnationTemplate record) {
        return examnationTemplateMapper.updateByPrimaryKeySelective(record);
    }

}
