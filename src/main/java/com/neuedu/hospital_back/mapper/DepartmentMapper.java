package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Department;

import java.util.List;

public interface DepartmentMapper {
    List<Department> getDepartments(Department department);

    List<Department> getAllDepartments();

    void deleteDepartment(String dId);

    void insertDepartment(Department department);

    void updateDepartment(Department department);
}
