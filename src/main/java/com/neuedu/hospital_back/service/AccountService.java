package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.AccountDiagnosisMapper;
import com.neuedu.hospital_back.mapper.AccountExaminationApplicationMapper;
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

    @Resource
    private AccountExaminationApplicationMapper accountExaminationApplicationMapper;

    @Resource
    private AccountDiagnosisMapper accountDiagnosisMapper;

    public boolean insertDiagnosisAccount(JSONObject object) {
        JSONArray jsonArray = object.getJSONArray("accounts");
        List<Account> accounts = (List) JSONArray.toCollection(jsonArray, Account.class);
        int result = 0;
        for (Account account : accounts) {
            System.out.println(account.toString());
            result += accountMapper.insert(account);
            accountDiagnosisMapper.insert(account.getAccId(), account.getDiaId());
        }
        return result == accounts.size();
    }

    public boolean insertAccount(JSONObject object){
        JSONArray jsonArray = object.getJSONArray("accounts");
        List<Account> accounts = (List) JSONArray.toCollection(jsonArray, Account.class);
        int result = 0;
        for (Account account : accounts) {
            System.out.println(account.toString());
            result += accountMapper.insert(account);
            accountExaminationApplicationMapper.insert(account.getAccId(), account.geteAId());
        }
        return result == accounts.size();
    }

    public boolean updateUId(JSONObject object){
        Integer rId = object.getInt("rId");
        String dId = object.getString("dId");
        Integer uId = object.getInt("uId");
        List<Integer> eAIdList = object.getJSONArray("eAIdList");
        int result = 0;
        for (Integer eAId : eAIdList){
            result += accountMapper.updateUId(rId,dId,eAId, uId);
        }
        return result == eAIdList.size();
    }
}
