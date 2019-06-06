package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Invoice;

import java.util.List;

public interface InvoiceMapper {
    int deleteByPrimaryKey(String iId);

    int insert(Invoice record);

    int update(Invoice record);

    String getNowIId();

    List<Invoice> selectByCondition(Invoice invoice);
}