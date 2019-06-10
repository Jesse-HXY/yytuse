package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.po.ExamnationItem;
import com.neuedu.hospital_back.util.ReadExcelUtil;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.neuedu.hospital_back.mapper.MedicineMapper;
import com.neuedu.hospital_back.po.Medicine;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class MedicineService{

    @Resource
    private MedicineMapper medicineMapper;

    @Resource
    private ReadExcelUtil readExcelUtil;

    public boolean importMedicine() throws Exception {
        String path = ClassUtils.getDefaultClassLoader().getResource("static/medicine.xlsx").getPath();
        File excelFile = new File(path);//创建excel文件对象
        InputStream is = new FileInputStream(excelFile);//创建输入流对象
        readExcelUtil.checkExcelVaild(excelFile);
        Workbook workbook = readExcelUtil.getWorkBook(is, excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            Medicine medicine = new Medicine();
            medicine.setmCode(readExcelUtil.getCellValue(row.getCell(0)));
            medicine.setmName(readExcelUtil.getCellValue(row.getCell(1)));
            medicine.setmSpecification(readExcelUtil.getCellValue(row.getCell(2)));
            medicine.setmUnit(readExcelUtil.getCellValue(row.getCell(3)));
            medicine.setmProducer(readExcelUtil.getCellValue(row.getCell(4)));
            medicine.setmFormulation(readExcelUtil.getCellValue(row.getCell(5)));
            medicine.setmType(readExcelUtil.getCellValue(row.getCell(6)));
            medicine.setmFee(Double.valueOf(readExcelUtil.getCellValue(row.getCell(7))));
            medicine.setmSpell(readExcelUtil.getCellValue(row.getCell(8)));
            medicineMapper.insert(medicine);
        }
        is.close();
        return true;
    }
    
    public int deleteByPrimaryKey(JSONObject object) {
        return medicineMapper.deleteByPrimaryKey(object.getInt("mId"));
    }

    
    public int insert(Medicine record) {
        return medicineMapper.insert(record);
    }
    public int getMedicineCount() {
        return medicineMapper.getMedicineCount();
    }

    public List<Medicine> selectMedicineByMName(JSONObject object){
        return medicineMapper.selectMedicineByMName(object.getString("mName"),object.getString("mType"));
    }

    public List<Medicine> selectMedicineByCondition(Medicine medicine){
        return medicineMapper.selectMedicineByCondition(medicine);
    }

    public List<Medicine> getMedicineByPage(JSONObject jsonObject){
        return medicineMapper.getMedicineByPage(jsonObject.getInt("pageNum"), jsonObject.getInt("pageSize"));
    }


    public int updateByPrimaryKeySelective(Medicine record) {
        return medicineMapper.updateByPrimaryKeySelective(record);
    }

}
