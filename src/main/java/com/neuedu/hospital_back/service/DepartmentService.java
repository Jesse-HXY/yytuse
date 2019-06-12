package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DepartmentMapper;
import com.neuedu.hospital_back.mapper.DepartmentUserMapper;
import com.neuedu.hospital_back.po.Department;
import com.neuedu.hospital_back.po.Disease;
import com.neuedu.hospital_back.util.ReadExcelUtil;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private DepartmentUserMapper departmentUserMapper;
    @Resource
    private ReadExcelUtil readExcelUtil;

    public boolean importDepartment() throws Exception {
        String path = ClassUtils.getDefaultClassLoader().getResource("static/department.xlsx").getPath();
        File excelFile = new File(path);//创建excel文件对象
        InputStream is = new FileInputStream(excelFile);//创建输入流对象
        readExcelUtil.checkExcelVaild(excelFile);
        Workbook workbook = readExcelUtil.getWorkBook(is, excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            Department department = new Department();
            department.setdId(readExcelUtil.getCellValue(row.getCell(0)));
            department.setdName(readExcelUtil.getCellValue(row.getCell(1)));
            department.setdType(readExcelUtil.getCellValue(row.getCell(2)));
            department.setdCategory(readExcelUtil.getCellValue(row.getCell(3)));
            departmentMapper.insertDepartment(department);
        }
        is.close();
        return true;
    }

    public List<Department> selectByuId(JSONObject object) {
        List<String> dIds = departmentUserMapper.selectByuId(object.getInt("uId"));
        List<Department> departments = new ArrayList<>();
        for (String dId : dIds) {
            departments.add(departmentMapper.getDepartmentBydId(dId));
        }
        return departments;
    }

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments();
    }

    public List<Department> getDepartments(Department department) {
        return departmentMapper.getDepartments(department);
    }

    public List<Department> getDepartmentByPage(JSONObject jsonObject) {
        return departmentMapper.getDepartmentByPage(jsonObject.getInt("pageNum"), jsonObject.getInt("pageSize"));
    }

    public boolean deleteDepartment(JSONObject object) {
        return departmentMapper.deleteDepartment(object.getString("dId")) == 1;
    }

    public boolean insertDepartment(Department department) {
        return departmentMapper.insertDepartment(department) == 1;
    }

    public boolean updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department) == 1;
    }

    public int getDepartmentCount() {
        return departmentMapper.getDepartmentCount();
    }
}
