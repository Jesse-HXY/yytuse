package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.*;
import com.neuedu.hospital_back.po.Account;
import com.neuedu.hospital_back.po.DiagnosisMedicine;
import com.neuedu.hospital_back.po.Medicine;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
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

    @Resource
    private ExaminationApplicationMapper examinationApplicationMapper;

    @Resource
    private InvoiceMapper invoiceMapper;

    @Resource
    private RegistrationMapper registrationMapper;

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

    public String insertAccount(JSONObject object) {
        JSONArray jsonArray = object.getJSONArray("accounts");
        String iStatus = object.getString("iStatus");
        List<Account> accounts = (List) JSONArray.toCollection(jsonArray, Account.class);
        String iId = generateIId();
        invoiceMapper.insertInvoice(iId, iStatus);
        for (Account account : accounts) {
            System.out.println(account.getFee());
            account.setiId(iId);
            accountMapper.insert(account);
            if (account.getFeeType().equals("中药") || account.getFeeType().equals("西药")) {
                accountDiagnosisMapper.insert(account.getAccId(), account.getDia_M_Id());
            } else if(account.getFeeType().equals("挂号费")){

            }else accountExaminationApplicationMapper.insert(account.getAccId(), account.geteAId());
        }
        return iId;
    }

    public String updateIId(JSONObject object){
        String iId = object.getString("iId");
        String newIId = generateIId();
        accountMapper.updateIId(newIId, iId);
        invoiceMapper.insertInvoice(newIId,"生效");
        invoiceMapper.updateInvoice(iId, "作废");
        return newIId;
    }

    private String generateIId(){
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DATE);
        int date = year * 10000 + (month + 1) * 100 + day;
        /**发票前缀*/
        String profix = String.valueOf(date);
        /**发票后缀*/
        int suffix = invoiceMapper.getNowIId(String.valueOf(date));
        String iId = "";
        if(suffix < 10){
            iId = profix + "00" + String.valueOf(suffix);
        }else if(suffix < 100){
            iId = profix + "0" + String.valueOf(suffix);
        }else{
            iId = profix + String.valueOf(suffix);
        }
        return iId;
    }

    public boolean updateUId(JSONObject object) {
        Integer rId = object.getInt("rId");
        String dId = object.getString("dId");
        Integer uId = object.getInt("uId");
        List<Integer> eAIdList = object.getJSONArray("eAIdList");
        int result = 0;
        for (Integer eAId : eAIdList) {
            result += accountMapper.updateUId(rId, dId, eAId, uId);
        }
        return result == eAIdList.size();
    }

    public List<Medicine> getMedicineByRIdAndTime(JSONObject object) {
        Integer rId = object.getInt("rId");
        String time = object.getString("Date");
        return accountMapper.getMedicineByRIdAndTime(rId, time);
    }

    public List<Medicine> getAlreadyDrawMedicineByRIdAndTime(JSONObject object) {
        Integer rId = object.getInt("rId");
        String time = object.getString("Date");
        return accountMapper.getAlreadyDrawMedicineByRIdAndTime(rId, time);
    }

    public ArrayList<String> returnExamApplication(JSONObject object) {
        List<Double> eAFees = (List) JSONArray.toCollection(object.getJSONArray("eAFee"), Double.class);
        List<Integer> eAIds =(List) JSONArray.toCollection(object.getJSONArray("eAIds"), Integer.class);
        List<Integer> dia_M_Ids = (List) JSONArray.toCollection(object.getJSONArray("dia_M_Ids"), Integer.class);
        List<Double> medicineFees = (List) JSONArray.toCollection(object.getJSONArray("medicineFee"), Double.class);

        int re = 0;
        List<String> iIdList = new ArrayList<>();
        List<Integer> accIdList = new ArrayList<>();
        for (int i = 0; i < eAIds.size(); i++) {
            //获取accId
            Integer accId = accountExaminationApplicationMapper.getAccId(eAIds.get(i));
            //获取iId
            String iId = accountMapper.getIIdByAccId(accId);
            if(!iIdList.contains(iId)){
                iIdList.add(iId);
            }
            accIdList.add(accId);
            //更新account中费用
            re += accountMapper.updateFeeById(accId, 0-eAFees.get(i));
            //删除中间表
//            accountExaminationApplicationMapper.deleteByeAId(eAIds.get(i));
            //更新ea状态
            examinationApplicationMapper.updateStatus(eAIds.get(i), "已退费");

        }
        for (int i = 0; i < dia_M_Ids.size(); i++) {
            //获取accId
            Integer accId = accountDiagnosisMapper.getAccId(dia_M_Ids.get(i));

            Account account=new Account();
            account.setAccId(accId);
           Account account1=accountMapper.selectByCondition(account).get(0);
           account1.setiId(null);
           account1.setFee(-medicineFees.get(i));
            accountMapper.insert(account1);
            accIdList.add(account1.getAccId());
            //获取iId
            String iId = accountMapper.getIIdByAccId(accId);
            if(!iIdList.contains(iId)){
                iIdList.add(iId);
            }

            //更新account中费用
            re += accountMapper.updateFeeById(accId, medicineFees.get(i));
            //更新中间表
            accountDiagnosisMapper.updateByia_M_Id(account1.getAccId(),dia_M_Ids.get(i));
//            accountDiagnosisMapper.deleteBydia_M_Id(dia_M_Ids.get(i));
            //更新d_a状态
            DiagnosisMedicine d = new DiagnosisMedicine();
            d.setmState("已退费");
            d.setDia_M_Id(dia_M_Ids.get(i));
            diagnosisMedicineMapper.updateByKey(d);
        }


        //更新account中退费部分的发票号
        String newRefundIId = generateIId();
        System.out.println(newRefundIId);
        for(Integer accId: accIdList){
            accountMapper.updateIIdByAccId(accId, accountMapper.getIIdByAccId(accId), newRefundIId);
        }
        invoiceMapper.insertInvoice(newRefundIId,"冲红");

        //更新中间表对应accId
        //更改account中未退费的发票号
        String newIId = generateIId();
        System.out.println(newIId);
        for(String iId: iIdList){
            accountMapper.updateIId(iId,newIId);
            invoiceMapper.updateInvoice(iId, "作废");
            invoiceMapper.insertConnection(iId, newRefundIId);
        }
        invoiceMapper.insertInvoice(newIId,"生效");
        ArrayList<String> returnList = new ArrayList<>();
        returnList.add(newRefundIId);
        returnList.add(newIId);
        return returnList;
    }

    public boolean returnRegistration(JSONObject object){
        registrationMapper.updateRegistration(object.getInt("rId"), object.getString("rStatus"), object.getString("rResult"));
        Account a=new Account();
        a.setrId(object.getInt("rId"));
        a.setFeeType("挂号费");
        List<Account> accounts= accountMapper.selectByCondition(a);
        if(accounts.size()>=1){
            a=accounts.get(0);
            String iId=a.getiId();
            String newRefundIId = generateIId();
            accountMapper.updateIIdByAccId(a.getAccId(), accountMapper.getIIdByAccId(a.getAccId()),newRefundIId);
            invoiceMapper.insertInvoice(newRefundIId,"冲红");
            invoiceMapper.insertConnection(iId, newRefundIId);
        }

        return accounts.size()==1;
    }

}
