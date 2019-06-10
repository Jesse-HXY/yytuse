package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.Medicine;
import com.neuedu.hospital_back.service.AccountService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/insertAccount")
    public boolean insertAccount(@RequestBody JSONObject object){
        return accountService.insertAccount(object);
    }

    @PostMapping("/updateUId")
    public boolean updateUId(@RequestBody JSONObject object){
        return accountService.updateUId(object);
    }

    @PostMapping("/insertDiagnosisAccount")
    public boolean insertDiagnosisAccount(@RequestBody JSONObject object){
        return accountService.insertDiagnosisAccount(object);
    }

    @PostMapping("/getMedicineByRIdAndTime")
    public List<Medicine> getMedicineByRIdAndTime(@RequestBody JSONObject object){
        return accountService.getMedicineByRIdAndTime(object);
    }

    @PostMapping("/getAlreadyDrawMedicineByRIdAndTime")
    public List<Medicine> getAlreadyDrawMedicineByRIdAndTime(@RequestBody JSONObject object){
        return accountService.getAlreadyDrawMedicineByRIdAndTime(object);
    }

    @PostMapping("/returnExamApplication")
    public Boolean returnExamApplication(@RequestBody JSONObject object){
        return accountService.returnExamApplication(object);
    }

    @PostMapping("/returnMedicine")
    public Boolean returnMedicine(@RequestBody JSONObject object){
        return accountService.returnMedicine(object);
    }


}
