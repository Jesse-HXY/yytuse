package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.ExaminationApplicationMapper;
import com.neuedu.hospital_back.mapper.ExamnationitemMapper;
import com.neuedu.hospital_back.po.ExaminationApplication;
import com.neuedu.hospital_back.po.ExamnationItem;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExaminationApplicationService {

    @Resource
    private ExaminationApplicationMapper examinationApplicationMapper;

    @Resource
    private ExamnationitemMapper examnationitemMapper;

    public ExaminationApplication insertAndGet(ExaminationApplication examinationApplication) {
        examinationApplicationMapper.insert(examinationApplication);
        return examinationApplicationMapper.selectById(examinationApplication.geteAId());
    }

    public List<ExaminationApplication> getByrIdAndEIFeeType(JSONObject object) {
        List<ExaminationApplication> examinationApplications = examinationApplicationMapper.selectByrIdAndDId(object.getInt("rId"), object.getString("dId"));
        for (ExaminationApplication examinationApplication : examinationApplications) {
            //通过eIId属性拿到对象
            ExamnationItem examnationItem = examnationitemMapper.selectById(examinationApplication.geteIId());
            //如果eIFeeType符合条件就加入其属性
            if(examnationItem.geteIFeeType().contains(object.getString("eIFeeType"))){
                examinationApplication.setExamnationItem(examnationItem);
                //否则remove这个对象
            }else {
                examinationApplications.remove(examinationApplication);
            }
        }
        return examinationApplications;
    }

    public boolean DeleteExaminationApplication(JSONObject object) {
        List<Integer> eAIds = object.getJSONArray("eAIdList");
        int result = 0;
        for (int eAId : eAIds) {
            result += examinationApplicationMapper.delete(eAId);
        }
        return result == eAIds.size();
    }

    public boolean updateStatus(JSONObject object) {
        List<Integer> eAIds = object.getJSONArray("eAIdList");
        String eAStatus = object.getString("eAStatus");
        int result = 0;
        for (int eAId : eAIds) {
            if (eAStatus.equals("开立")) {
                result += examinationApplicationMapper.updateStatusAndTime(eAId, eAStatus, System.currentTimeMillis() / 1000);
            } else {
                result += examinationApplicationMapper.updateStatus(eAId, eAStatus);
            }
        }
        return result == eAIds.size();
    }

    public List<ExaminationApplication> selectByrId(JSONObject object) {
        List<ExaminationApplication> examinationApplications = examinationApplicationMapper.selectByrId(object.getInt("rId"));
        for (ExaminationApplication examinationApplication : examinationApplications) {
            examinationApplication.setExamnationItem(examnationitemMapper.selectById(examinationApplication.geteIId()));
        }
        return examinationApplications;
    }

    public List<ExaminationApplication> selectByrIdAndStatus(JSONObject object) {
        List<ExaminationApplication> examinationApplications = examinationApplicationMapper.selectByrIdAndStatus(object.getInt("rId"), object.getString("eAStatus"));
        for (ExaminationApplication examinationApplication : examinationApplications) {
            examinationApplication.setExamnationItem(examnationitemMapper.selectById(examinationApplication.geteIId()));
        }
        return examinationApplications;
    }
}
