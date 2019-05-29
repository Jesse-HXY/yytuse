package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    List<Department> getAllDepartments();

    List<Department> getDepartments(Department department);

    List<Department> getDepartmentByPage(@Param("begin")int begin, @Param("pageSize")int pageSize);

    int deleteDepartment(String dId);

    int insertDepartment(Department department);

    int updateDepartment(Department department);

    int getDepartmentCount();
}
