package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.po.ExamnationItem;
import com.neuedu.hospital_back.util.ReadExcelUtil;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.neuedu.hospital_back.mapper.ExamnationitemMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class ExamnationitemService {

    @Resource
    private ExamnationitemMapper examnationitemMapper;

    @Resource
    private ReadExcelUtil readExcelUtil;

    public boolean importExamnationItems(JSONObject object) throws Exception {
        File excelFile = new File(object.getString("fileName"));//创建excel文件对象
        InputStream is = new FileInputStream(excelFile);//创建输入流对象
        readExcelUtil.checkExcelVaild(excelFile);
        Workbook workbook = readExcelUtil.getWorkBook(is, excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            ExamnationItem examnationItem = new ExamnationItem();
            examnationItem.seteICode(readExcelUtil.getCellValue(row.getCell(0)));
            examnationItem.seteIName(readExcelUtil.getCellValue(row.getCell(1)));
            examnationItem.seteISpecification(readExcelUtil.getCellValue(row.getCell(2)));
            examnationItem.seteIFee(Double.valueOf(readExcelUtil.getCellValue(row.getCell(3))));
            examnationItem.seteIFeeType(readExcelUtil.getCellValue(row.getCell(4)));
            examnationitemMapper.insert(examnationItem);
        }
        is.close();
        return true;
    }

    public boolean deleteByPrimaryKey(JSONObject eIId) {
        return examnationitemMapper.deleteByPrimaryKey(eIId.getInt("eIId")) == 1;
    }


    public boolean insert(ExamnationItem record) {
        return examnationitemMapper.insert(record) == 1;
    }


    public boolean updateByPrimaryKeySelective(ExamnationItem record) {
        return examnationitemMapper.updateByPrimaryKeySelective(record) == 1;
    }

    public List<ExamnationItem> selectExamnationItem(ExamnationItem examnationItem) {
        return examnationitemMapper.selectExamnationItem(examnationItem);
    }

    public List<ExamnationItem> selectExamnationItemByEIName(JSONObject object) {
        return examnationitemMapper.selectExamnationItemByeIName(object.getString("eIName"), object.getString("recordType"));
    }

    public List<ExamnationItem> selectAllExamnationItem() {
        return examnationitemMapper.selectAllExamnationItem();
    }

    public List<ExamnationItem> selectExamnationItemByPage(JSONObject object) {
        return examnationitemMapper.selectExamnationItemByPage(object.getInt("pageNum"), object.getInt("pageSize"));
    }

    public int getPageCount() {
        return examnationitemMapper.getExamnationItemCount();
    }

}
