package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.mapper.DepartmentMapper;
import com.neuedu.hospital_back.po.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> getDepartments(Department department) {
        List<Department> departments = departmentMapper.getDepartments(department);
        return departments;
    }

    public List<Department> getDepartmentByPage(int begin, int pageSize) {
        List<Department> departments = departmentMapper.getDepartmentByPage(begin, pageSize);
        return departments;
    }

    public boolean deleteDepartment(String dId) {
        departmentMapper.deleteDepartment(dId);
        return true;
    }

    public boolean insertDepartment(Department department) {
        departmentMapper.insertDepartment(department);
        return true;
    }

    public boolean updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
        return true;
    }

    public int getPageCount(int pageSize) {
        return (departmentMapper.getDepartmentCount() / pageSize) + 1;
    }
}
