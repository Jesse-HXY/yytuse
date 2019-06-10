package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DiseaseMapper;
import com.neuedu.hospital_back.po.Disease;
import com.neuedu.hospital_back.po.ExamnationItem;
import com.neuedu.hospital_back.util.ReadExcelUtil;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class DiseaseService {

    @Resource
    private DiseaseMapper diseaseMapper;

    @Resource
    private ReadExcelUtil readExcelUtil;

    public boolean importDiseases() throws Exception {
        String path = ClassUtils.getDefaultClassLoader().getResource("static/disease.xlsx").getPath();
        File excelFile = new File(path);//创建excel文件对象
        InputStream is = new FileInputStream(excelFile);//创建输入流对象
        readExcelUtil.checkExcelVaild(excelFile);
        Workbook workbook = readExcelUtil.getWorkBook(is, excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            Disease disease = new Disease();
            disease.setDisIcd(readExcelUtil.getCellValue(row.getCell(0)));
            disease.setDisCode(readExcelUtil.getCellValue(row.getCell(1)));
            disease.setDisName(readExcelUtil.getCellValue(row.getCell(2)));
            disease.setDisType(readExcelUtil.getCellValue(row.getCell(3)));
            diseaseMapper.insert(disease);
        }
        is.close();
        return true;
    }

    public List<String> getDiseaseType() {
        return diseaseMapper.getDiseaseType();

    }

    public List<Disease> getDiseaseByType(String disType) {
        return diseaseMapper.getDiseaseByType(disType);
    }

    public List<Disease> getDiseaseByPage(JSONObject object) {
        return diseaseMapper.getDiseaseByPage(object.getString("disType"), object.getInt("pageNum"), object.getInt("pageSize"));
    }

    public List<Disease> getDiseases(Disease disease) {
        return diseaseMapper.getDiseases(disease);
    }

    public boolean insert(Disease record) {
        return diseaseMapper.insert(record) == 1;

    }

    public boolean updateDisease(Disease disease) {
        return diseaseMapper.updateByPrimaryKeySelective(disease) == 1;

    }

    public boolean deleteDisease(JSONObject disId) {
        return diseaseMapper.deleteByPrimaryKey(disId.getInt("disId")) == 1;

    }

    public int getDiseaseCount(JSONObject object) {
        String disType=object.getString("disType");
        return diseaseMapper.getDiseaseCount(disType);
    }
}


