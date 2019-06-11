package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Invoice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvoiceMapper {
    int deleteByPrimaryKey(String iId);

    int insert(Invoice record);

    int update(Invoice record);

    int getNowIId(String profix);

    List<Invoice> selectByCondition(Invoice invoice);

    int insertInvoice(@Param("iId") String iId, @Param("iStatus") String iStatus);

    int updateInvoice(@Param("iId") String iId, @Param("iStatus") String iStatus);

    int insertConnection(@Param("originaliId") String originaliId, @Param("newIId") String newIId);
}