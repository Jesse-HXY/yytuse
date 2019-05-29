package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    List<Department> getDepartments(Department department);

    List<Department> getDepartmentByPage(@Param("begin")int begin, @Param("pageSize")int pageSize);

    void deleteDepartment(String dId);

    void insertDepartment(Department department);

    void updateDepartment(Department department);

    int getDepartmentCount();
}
