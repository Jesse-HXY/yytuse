package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.AccountMapper;
import com.neuedu.hospital_back.po.Account;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    public boolean insertAccount(JSONObject object) {
        JSONArray jsonArray = object.getJSONArray("accounts");
        List<Account> accounts = (List) JSONArray.toCollection(jsonArray, Account.class);
        int result = 0;
        for (Account account : accounts) {
            result += accountMapper.insert(account);
        }
        return result == accounts.size();
    }
}
