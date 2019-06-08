package com.neuedu.hospital_back.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.neuedu.hospital_back.mapper.InvoiceMapper;
import com.neuedu.hospital_back.po.Invoice;

import java.util.List;

@Service
public class InvoiceService {

    @Resource
    private InvoiceMapper invoiceMapper;


    public int deleteByPrimaryKey(String iId) {
        return invoiceMapper.deleteByPrimaryKey(iId);
    }


    public int insert(Invoice record) {
        return invoiceMapper.insert(record);
    }


    public String getNowIId(){
        return invoiceMapper.getNowIId();
    }

    public boolean update(Invoice object){
      return invoiceMapper.update(object)==1;
    }

    public List<Invoice> selectByCondition(Invoice invoice){
        return invoiceMapper.selectByCondition(invoice);
    }

}

