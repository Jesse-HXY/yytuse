package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.DiagnosisTemplate;
import com.neuedu.hospital_back.po.DiagnosisTemplateMedicine;
import com.neuedu.hospital_back.po.Medicine;
import com.neuedu.hospital_back.service.DiagnosisTemplateService;
import com.neuedu.hospital_back.service.MedicineService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Resource
    private DiagnosisTemplateService diagnosisTemplateService;

    @Resource
    private MedicineService medicineService;

    @PostMapping("/getMedicineByMName")
    public List<Medicine> getMedicineByEIName(@RequestBody JSONObject object) {
        return  medicineService.selectMedicineByMName(object);
    }

    @PostMapping("/getMedicine")
    public List<Medicine> getMedicineByCondition(@RequestBody Medicine medicine){
        return medicineService.selectMedicineByCondition(medicine);
    }

    @PostMapping("/getMedicineByPage")
    public List<Medicine> getMedicineByPage(@RequestBody JSONObject object){
        return medicineService.getMedicineByPage(object);
    }
    @RequestMapping("/deleteMedicine")
    public boolean deleteMedicine(@RequestBody JSONObject object) {
        return medicineService.deleteByPrimaryKey(object)==1;
    }

    @RequestMapping("/insertMedicine")
    public boolean insertMedicine(@RequestBody Medicine medicine) {
        return medicineService.insert(medicine)==1;
    }

    @RequestMapping("/updateMedicine")
    public boolean updateMedicine(@RequestBody Medicine medicine){
        return medicineService.updateByPrimaryKeySelective(medicine)==1;
    }

    @RequestMapping("/insertDiagnosisTemplate")
    public boolean insertDiagnosisTemplate(@RequestBody JSONObject object){
        return diagnosisTemplateService.insert(object);
    }

    @PostMapping("/getDiagnosisTemplateByCondition")
    public List<DiagnosisTemplate> getDiagnosisTemplateByCondition(@RequestBody JSONObject object){
        return diagnosisTemplateService.selectByCondition(object);
    }

    @PostMapping("/checkDetail")
    public DiagnosisTemplate checkDetail(@RequestBody JSONObject object){
        return diagnosisTemplateService.checkDetail(object);
    }

    @PostMapping("/deleteDiagnosisTemplateByPrimaryKey")
    public Boolean DiagnosisTemplate(@RequestBody JSONObject object){
        return diagnosisTemplateService.deleteByPrimaryKey(object);
    }

    @PostMapping("/updateDiagnosisTemplateMedicine")
    public int updateDiagnosisTemplateMedicine(@RequestBody DiagnosisTemplateMedicine d){
        return diagnosisTemplateService.updateDiagnosisTemplateMedicine(d);
    }


}
