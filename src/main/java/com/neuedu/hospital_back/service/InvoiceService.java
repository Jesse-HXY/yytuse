package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.ExamnationitemMapper;
import com.neuedu.hospital_back.po.ExaminationApplication;
import com.neuedu.hospital_back.po.Medicine;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.neuedu.hospital_back.mapper.InvoiceMapper;
import com.neuedu.hospital_back.po.Invoice;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    @Resource
    private InvoiceMapper invoiceMapper;

    @Resource
    private ExamnationitemMapper examnationitemMapper;

    public List<String> selectIId(JSONObject object){
        return invoiceMapper.selectIId(object.getInt("cId"), object.getLong("beginTime"), object.getLong("endTime"),object.getString("iStatus"));
    }

    public int deleteByPrimaryKey(String iId) {
        return invoiceMapper.deleteByPrimaryKey(iId);
    }

    public int insert(Invoice record) {
        return invoiceMapper.insert(record);
    }

    public boolean update(Invoice object){
      return invoiceMapper.update(object)==1;
    }

    public List<Invoice> selectByCondition(Invoice invoice){
        return invoiceMapper.selectByCondition(invoice);
    }

    public List<Medicine> selectMedicineByiId(JSONObject object){
        return invoiceMapper.selectMedicineByiId(object.getString("iId"));
    }

    public List<ExaminationApplication> selectExaminationApplicationByiId(JSONObject object){
        List<ExaminationApplication> examinationApplications = invoiceMapper.selectExaminationApplicationByiId(object.getString("iId"));
        for (ExaminationApplication examinationApplication : examinationApplications) {
            examinationApplication.setExamnationItem(examnationitemMapper.selectById(examinationApplication.geteIId()));
        }
        return examinationApplications;
    }

    public List<String> getCancelledInvoice(JSONObject object){
        return invoiceMapper.getCancelledInvoice(object.getInt("cId"), object.getLong("beginTime"), object.getLong("endTime"));
    }

    public int updateInvoice(JSONObject object){
        return invoiceMapper.updateInvoice(object.getString("iId"), object.getString("iStatus"));
    }

}

