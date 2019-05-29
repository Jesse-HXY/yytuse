package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DepartmentMapper;
import com.neuedu.hospital_back.po.Department;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    public  List<Department> getAllDepartments() {
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
