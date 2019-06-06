package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.Invoice;
import com.neuedu.hospital_back.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Resource
    private InvoiceService invoiceService;

    @PostMapping("getNowIId")
    public String getNowIId(){
        return invoiceService.getNowIId();
    }
    @PostMapping("update")
    public boolean update(@RequestBody Invoice object){
        return invoiceService.update(object);
    }
    @PostMapping("selectByCondition")
    public List<Invoice> selectByCondition(@RequestBody Invoice invoice){
        return invoiceService.selectByCondition(invoice);
    }
}
