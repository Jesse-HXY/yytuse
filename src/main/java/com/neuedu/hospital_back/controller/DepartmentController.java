package com.neuedu.hospital_back.controller;

import com.neuedu.hospital_back.po.Department;
import com.neuedu.hospital_back.service.DepartmentService;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/getAllDepartments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping("/getDepartments")
    public List<Department> getDepartments(@RequestBody Department department) {
        return departmentService.getDepartments(department);
    }

    @PostMapping("/getDepartmentByPage")
    public List<Department> getDepartmentByPage(@RequestBody JSONObject object) {
        return  departmentService.getDepartmentByPage(object);
    }

    @PostMapping("/deleteDepartment")
    public boolean deleteDepartment(@RequestBody JSONObject object) {
        return departmentService.deleteDepartment(object);
    }

    @PostMapping("/insertDepartment")
    public boolean insertDepartment(@RequestBody Department department) {
        return departmentService.insertDepartment(department);
    }

    @PostMapping("/updateDepartment")
    public boolean updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @PostMapping("/getDepartmentCount")
    public int getDepartmentCount(){
        return departmentService.getDepartmentCount();
    }
}