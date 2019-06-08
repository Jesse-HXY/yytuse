package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.service.AccountService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
}
