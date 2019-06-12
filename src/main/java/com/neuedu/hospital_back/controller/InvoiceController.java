package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.Invoice;
import com.neuedu.hospital_back.service.InvoiceService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Resource
    private InvoiceService invoiceService;

    @PostMapping("/update")
    public boolean update(@RequestBody Invoice object) {
        return invoiceService.update(object);
    }

    @PostMapping("/selectByCondition")
    public List<Invoice> selectByCondition(@RequestBody Invoice invoice) {
        return invoiceService.selectByCondition(invoice);
    }

    @PostMapping("/selectIId")
    public List<String> selectIId(@RequestBody JSONObject object){
        return invoiceService.selectIId(object);
    }
}
