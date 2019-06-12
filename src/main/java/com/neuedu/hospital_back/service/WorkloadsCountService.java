package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.InvoiceMapper;
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
    @Resource
    private InvoiceMapper invoiceMapper;

    private String[] feeTypes = {"中药费", "西药费", "挂号费", "诊察费", "检查费", "检验费", "治疗费", "材料费", "手术费", "其他费用"};
    private String[] payTypes = {"自费", "医保卡", "新农合"};

    public WorkloadsCount getWorkloadsCountByPostDId(JSONObject object) {
        String postDId = object.getString("postDId");
        Long beginTime = object.getLong("beginTime");
        Long endTime = object.getLong("endTime");
        Map<String, Double> fees = new HashMap<>();
        for (String feeType : feeTypes) {
            fees.put(feeType, workloadsCountMapper.getFeesByPostDId(postDId, beginTime, endTime, feeType));
        }
        WorkloadsCount workloadsCount = new WorkloadsCount();
        workloadsCount.setVisits(registrationMapper.getPostVisits(postDId, beginTime, endTime));
        workloadsCount.setInvoiceNum(invoiceMapper.getInvoiceCountByPostDId(postDId, beginTime, endTime));
        return setValues(workloadsCount, fees);
    }

    public WorkloadsCount getWorkloadsCountBycId(JSONObject object) {
        Integer cId = object.getInt("cId");
        Long beginTime = object.getLong("beginTime");
        Long endTime = object.getLong("endTime");
        Map<String, Double> fees = new HashMap<>();
        for (String feeType : feeTypes) {
            fees.put(feeType, workloadsCountMapper.getFeesBycIdOnFeeType(cId, beginTime, endTime, feeType));
        }
        for (String payType : payTypes) {
            fees.put(payType, workloadsCountMapper.getFeesBycIdOnPayType(cId, beginTime, endTime, payType));
        }
        WorkloadsCount workloadsCount = new WorkloadsCount();
        return setValues(workloadsCount, fees);
    }

    public WorkloadsCount getWorkloadsCountBydId(JSONObject object) {
        String dId = object.getString("dId");
        Long beginTime = object.getLong("beginTime");
        Long endTime = object.getLong("endTime");
        Map<String, Double> fees = new HashMap<>();
        for (String feeType : feeTypes) {
            fees.put(feeType, workloadsCountMapper.getFeesBydId(dId, beginTime, endTime, feeType));
        }
        WorkloadsCount workloadsCount = new WorkloadsCount();
        workloadsCount.setVisits(registrationMapper.getVisits(dId, beginTime, endTime));
        workloadsCount.setInvoiceNum(invoiceMapper.getInvoiceCountBydId(dId, beginTime, endTime));
        return setValues(workloadsCount, fees);
    }

    public WorkloadsCount getWorkloadsCountByuId(JSONObject object) {
        Integer uId = object.getInt("uId");
        Long beginTime = object.getLong("beginTime");
        Long endTime = object.getLong("endTime");
        Map<String, Double> fees = new HashMap<>();
        for (String feeType : feeTypes) {
            fees.put(feeType, workloadsCountMapper.getFeesByuId(uId, beginTime, endTime, feeType));
        }
        WorkloadsCount workloadsCount = new WorkloadsCount();
        workloadsCount.setVisits(registrationMapper.getUserVisits(uId, beginTime, endTime));
        workloadsCount.setInvoiceNum(invoiceMapper.getInvoiceCountByuId(uId, beginTime, endTime));
        return setValues(workloadsCount, fees);
    }

    private WorkloadsCount setValues(WorkloadsCount workloadsCount, Map<String, Double> fees) {
        if (fees.get("中药费") != null) workloadsCount.setZyFee(fees.get("中药费"));
        if (fees.get("西药费") != null) workloadsCount.setXyFee(fees.get("西药费"));
        if (fees.get("挂号费") != null) workloadsCount.setRegistrationFee(fees.get("挂号费"));
        if (fees.get("诊察费") != null) workloadsCount.setDiagnosticFee(fees.get("诊察费"));
        if (fees.get("检查费") != null) workloadsCount.setExaminationFee(fees.get("检查费"));
        if (fees.get("检验费") != null) workloadsCount.setTestFee(fees.get("检验费"));
        if (fees.get("治疗费") != null) workloadsCount.setTreatmentFee(fees.get("治疗费"));
        if (fees.get("材料费") != null) workloadsCount.setMaterialFee(fees.get("材料费"));
        if (fees.get("手术费") != null) workloadsCount.setSurgeryFee(fees.get("手术费"));
        if (fees.get("其他费用") != null) workloadsCount.setOtherFee(fees.get("其他费用"));
        if (fees.get("自费") != null) workloadsCount.setOtherFee(fees.get("自费"));
        if (fees.get("医保") != null) workloadsCount.setOtherFee(fees.get("医保"));
        if (fees.get("新农合") != null) workloadsCount.setOtherFee(fees.get("新农合"));
        return workloadsCount;
    }
}
