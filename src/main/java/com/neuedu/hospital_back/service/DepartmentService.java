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
        return departmentMapper.deleteDepartment(dId) == 1;
    }

    public boolean insertDepartment(Department department) {
        return departmentMapper.insertDepartment(department) == 1;
    }

    public boolean updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department) == 1;
    }

    public int getPageCount() {
        return departmentMapper.getDepartmentCount();
    }
}
