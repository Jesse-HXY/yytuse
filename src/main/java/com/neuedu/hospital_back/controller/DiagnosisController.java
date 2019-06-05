package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.ExaminationApplication;
import com.neuedu.hospital_back.po.MedicalRecord;
import com.neuedu.hospital_back.service.DiagnosisService;
import com.neuedu.hospital_back.service.ExaminationApplicationService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/DeleteExaminationApplication")
    public boolean DeleteExaminationApplication(@RequestBody JSONObject object) {
        return examinationApplicationService.DeleteExaminationApplication(object);
    }

    @PostMapping("/insertAndGet")
    public ExaminationApplication insertAndGet(@RequestBody ExaminationApplication examinationApplication) {
        return examinationApplicationService.insertAndGet(examinationApplication);
    }

    @PostMapping("/updateStatus")
    public boolean updateStatus(@RequestBody JSONObject object) {
        return examinationApplicationService.updateStatus(object);
    }

    @PostMapping("/selectByrId")
    public List<ExaminationApplication> selectByrId(@RequestBody JSONObject object){
        return examinationApplicationService.selectByrId(object);
    }
}
