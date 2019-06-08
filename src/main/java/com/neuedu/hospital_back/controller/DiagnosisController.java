package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.*;
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

    @PostMapping("/getDiagnosisTypeByrId")
    public List<DiagnosisType> getDiagnosisTypeByrId(@RequestBody JSONObject object) {
        return diagnosisService.getDiagnosisTypeByrId(object);
    }

    @PostMapping("/insertDiagnosisTypes")
    public boolean insertDiagnosisTypes(@RequestBody JSONObject object) {
        return diagnosisService.insertDiagnosisTypes(object);
    }

    @PostMapping("/getByrIdAndEIFeeType")
    public List<ExaminationApplication> getByrIdAndEIFeeType(@RequestBody JSONObject object) {
        return examinationApplicationService.getByrIdAndEIFeeType(object);
    }

    @PostMapping("/deleteExaminationApplication")
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

    @PostMapping("/updateResult")
    public boolean updateResult(@RequestBody JSONObject object) {
        return examinationApplicationService.updateResult(object);
    }

    @PostMapping("/selectByrId")
    public List<ExaminationApplication> selectByrId(@RequestBody JSONObject object) {
        return examinationApplicationService.selectByrId(object);
    }

    @PostMapping("/selectByrIdAndStatus")
    public List<ExaminationApplication> selectByrIdAndStatus(@RequestBody JSONObject object) {
        return examinationApplicationService.selectByrIdAndStatus(object);
    }

    @PostMapping("/insertDiagnosis")
    public Diagnosis insertDiagnosis(@RequestBody JSONObject object){
        return diagnosisService.insertDiagnosis(object);
    }

    @PostMapping("/insertDiagnosisMedicine")
    public boolean insertDiagnosisMedicine(@RequestBody JSONObject object){
        return diagnosisService.insertDiagnosisMedicine(object);
    }

    @PostMapping("/updateDiagnosisState")
    public boolean updateDiagnosis(@RequestBody JSONObject object){
        return diagnosisService.updateState(object);
    }

    @PostMapping("/deleteDiagnosis")
    public boolean deleteDiagnosis(@RequestBody JSONObject object){
        return diagnosisService.deleteByPrimaryKey(object);
    }

    @RequestMapping("/selectByCondition")
    public List<Diagnosis> selectByCondition(@RequestBody Diagnosis object){
        return diagnosisService.selectByCondition(object);
    }

    @PostMapping("/selectMedicineDetail")
    public Diagnosis selectMedicineDetail(@RequestBody JSONObject object){
        return diagnosisService.getDetail(object);
    }

    @PostMapping("/deleteMedicineFromDiagnosis")
    public boolean deleteMedicineFromDiagnosis(@RequestBody JSONObject object){
        return diagnosisService.deleteMedicineFromDiagnosis(object);
    }

    @PostMapping("/updateDiagnosisMedicineBydiaIdAndMId")
    public boolean updateBydiaId(@RequestBody JSONObject object){
        return diagnosisService.updateBydiaId(object);
    }

    @PostMapping("/selectHistoryDiagnosis")
    public List<Diagnosis> selectHistoryDiagnosis(@RequestBody JSONObject object)
    {
        return diagnosisService.selectHistoryDiagnosis(object);
    }

    @GetMapping("/getPopularMedicine")
    public List<Medicine> getPopularMedicine()
    {
        return diagnosisService.getPopularMedicine();
    }

}
