package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.AccountDiagnosisMapper;
import com.neuedu.hospital_back.mapper.AccountExaminationApplicationMapper;
import com.neuedu.hospital_back.mapper.AccountMapper;
import com.neuedu.hospital_back.mapper.DiagnosisMedicineMapper;
import com.neuedu.hospital_back.po.Account;
import com.neuedu.hospital_back.po.DiagnosisMedicine;
import com.neuedu.hospital_back.po.Medicine;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountExaminationApplicationMapper accountExaminationApplicationMapper;

    @Resource
    private AccountDiagnosisMapper accountDiagnosisMapper;

    @Resource
    private DiagnosisMedicineMapper diagnosisMedicineMapper;

    public boolean insertDiagnosisAccount(JSONObject object) {
        JSONArray jsonArray = object.getJSONArray("accounts");
        List<Account> accounts = (List) JSONArray.toCollection(jsonArray, Account.class);
        int result = 0;
        for (Account account : accounts) {
            System.out.println(account.toString());
            result += accountMapper.insert(account);
            accountDiagnosisMapper.insert(account.getAccId(), account.getDia_M_Id());
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
            if(account.getFeeType().equals("中药")||account.getFeeType().equals("西药")){
                accountDiagnosisMapper.insert(account.getAccId(), account.getDia_M_Id());
            }
            else accountExaminationApplicationMapper.insert(account.getAccId(), account.geteAId());
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

    public List<Medicine> getMedicineByRIdAndTime(JSONObject object){
        Integer rId = object.getInt("rId");
        String time=object.getString("Date");
       return accountMapper.getMedicineByRIdAndTime(rId,time);
    }

    public List<Medicine> getAlreadyDrawMedicineByRIdAndTime(JSONObject object){
        Integer rId = object.getInt("rId");
        String time=object.getString("Date");
        return accountMapper.getAlreadyDrawMedicineByRIdAndTime(rId,time);
    }

   public Boolean returnExamApplication(JSONObject object){
       List<Integer> eAIds=object.getJSONArray("eAIds");
       List<Double> fees=object.getJSONArray("fee");
       List<Integer> dia_M_Ids=object.getJSONArray("dia_M_Ids");
       List<Double> fees2=object.getJSONArray("fee2");

       int re=0;
       for(int i=0;i<eAIds.size();i++){
           //获取accId
           Integer accId=accountExaminationApplicationMapper.getAccId(eAIds.get(i));
           //更新account中费用
           re+=accountMapper.updateFeeById(accId,fees.get(i));
           //删除中间表
           accountExaminationApplicationMapper.deleteByeAId(eAIds.get(i));

       }
       for(int i=0;i<dia_M_Ids.size();i++){
           //获取accId
           Integer accId=accountDiagnosisMapper.getAccId(dia_M_Ids.get(i));
           //更新account中费用
           re+=accountMapper.updateFeeById(accId,fees2.get(i));
           //删除中间表
           accountDiagnosisMapper.deleteBydia_M_Id(dia_M_Ids.get(i));

       }
       return re==eAIds.size();
   }




}
