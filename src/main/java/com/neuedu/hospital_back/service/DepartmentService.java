package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DepartmentMapper;
import com.neuedu.hospital_back.mapper.DepartmentUserMapper;
import com.neuedu.hospital_back.po.Department;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private DepartmentUserMapper departmentUserMapper;

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
