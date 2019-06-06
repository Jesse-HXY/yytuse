package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.AccountMapper;
import com.neuedu.hospital_back.po.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    public boolean insertAccount(Account account){
        return accountMapper.insert(account) == 1;
    }
}
