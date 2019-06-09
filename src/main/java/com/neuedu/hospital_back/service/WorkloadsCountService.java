package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.RegistrationMapper;
import com.neuedu.hospital_back.mapper.WorkloadsCountMapper;
import com.neuedu.hospital_back.po.WorkloadsCount;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class WorkloadsCountService {

    @Resource
    private WorkloadsCountMapper workloadsCountMapper;
    @Resource
    private RegistrationMapper registrationMapper;

    private String[] names = {"中药费", "西药费", "挂号费", "诊察费", "检查费", "检验费", "治疗费", "材料费", "手术费", "其他费用"};

    public WorkloadsCount getWorkloadsCountByPostDId(JSONObject object) {
        String postDId = object.getString("postDId");
        Long beginTime = object.getLong("beginTime");
        Long endTime = object.getLong("endTime");
        Map<String, Double> fees = new HashMap<>();
        for (String name : names) {
            fees.put(name, workloadsCountMapper.getFeesByPostDId(postDId, beginTime, endTime, name));
        }
        WorkloadsCount workloadsCount = new WorkloadsCount();
        workloadsCount.setVisits(registrationMapper.getPostVisits(postDId, beginTime, endTime));
        return setValues(workloadsCount, fees);
    }

    public WorkloadsCount getWorkloadsCountBydId(JSONObject object) {
        String dId = object.getString("dId");
        Long beginTime = object.getLong("beginTime");
        Long endTime = object.getLong("endTime");
        Map<String, Double> fees = new HashMap<>();
        for (String name : names) {
            fees.put(name, workloadsCountMapper.getFeesBydId(dId, beginTime, endTime, name));
        }
        WorkloadsCount workloadsCount = new WorkloadsCount();
        workloadsCount.setVisits(registrationMapper.getVisits(dId, beginTime, endTime));
        return setValues(workloadsCount, fees);
    }

    public WorkloadsCount getWorkloadsCountByuId(JSONObject object) {
        Integer uId = object.getInt("uId");
        Long beginTime = object.getLong("beginTime");
        Long endTime = object.getLong("endTime");
        Map<String, Double> fees = new HashMap<>();
        for (String name : names) {
            fees.put(name, workloadsCountMapper.getFeesByuId(uId, beginTime, endTime, name));
        }
        WorkloadsCount workloadsCount = new WorkloadsCount();
        workloadsCount.setVisits(registrationMapper.getUserVisits(uId, beginTime, endTime));
        return setValues(workloadsCount, fees);
    }

    private WorkloadsCount setValues(WorkloadsCount workloadsCount, Map<String, Double> fees){
        workloadsCount.setZyFee(fees.get("中药费"));
        workloadsCount.setXyFee(fees.get("西药费"));
        workloadsCount.setRegistrationFee(fees.get("挂号费"));
        workloadsCount.setDiagnosticFee(fees.get("诊察费"));
        workloadsCount.setExaminationFee(fees.get("检查费"));
        workloadsCount.setTestFee(fees.get("检验费"));
        workloadsCount.setTreatmentFee(fees.get("治疗费"));
        workloadsCount.setMaterialFee(fees.get("材料费"));
        workloadsCount.setSurgeryFee(fees.get("手术费"));
        workloadsCount.setOtherFee(fees.get("其他费用"));
        return workloadsCount;
    }
}
