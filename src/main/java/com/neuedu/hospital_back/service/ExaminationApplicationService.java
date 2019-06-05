package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.ExaminationApplicationMapper;
import com.neuedu.hospital_back.po.ExaminationApplication;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExaminationApplicationService {

    @Resource
    private ExaminationApplicationMapper examinationApplicationMapper;

    public ExaminationApplication insertAndGet(ExaminationApplication examinationApplication) {
        examinationApplicationMapper.insert(examinationApplication);
        return examinationApplicationMapper.selectById(examinationApplication.geteAId());
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
            result += examinationApplicationMapper.updateStatus(eAId, eAStatus);
        }
        return result == eAIds.size();
    }
}
