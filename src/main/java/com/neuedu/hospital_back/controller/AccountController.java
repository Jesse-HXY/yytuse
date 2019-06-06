package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.mapper.AccountMapper;
import com.neuedu.hospital_back.po.Account;
import com.neuedu.hospital_back.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping
    public boolean insertAccount(@RequestBody Account account){
        return accountService.insertAccount(account);
    }
}
