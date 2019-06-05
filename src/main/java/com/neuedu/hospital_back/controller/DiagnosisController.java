package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.ExaminationApplication;
import com.neuedu.hospital_back.po.MedicalRecord;
import com.neuedu.hospital_back.service.DiagnosisService;
import com.neuedu.hospital_back.service.ExaminationApplicationService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

    @Resource
    private DiagnosisService diagnosisService;

    @Resource
    private ExaminationApplicationService examinationApplicationService;


    @PostMapping("/insertMedicalRecord")
    public boolean insertMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return diagnosisService.insertMedicalRecord(medicalRecord);
    }

    @PostMapping("/insertDiagnosisTypes")
    public boolean insertDiagnosisTypes(@RequestBody JSONObject object) {
        return diagnosisService.insertDiagnosisTypes(object);
    }

    @PostMapping("/insertAndGet")
    public ExaminationApplication insertAndGet(ExaminationApplication examinationApplication) {
        return examinationApplicationService.insertAndGet(examinationApplication);
    }
}
