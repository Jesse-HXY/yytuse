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

    @RequestMapping("/getDepartments")
    public List<Department> getDepartments(@RequestBody Department department) {
        return departmentService.getDepartments(department);
    }

    @PostMapping("/getDepartmentByPage")
    public List<Department> getAllDepartments(@RequestBody JSONObject object) {
        return  departmentService.getDepartmentByPage(object.getInt("pageNum"), object.getInt("pageSize"));
    }

    @RequestMapping("/deleteDepartment")
    public String deleteDepartment(@RequestBody JSONObject dId) {
        Boolean result = departmentService.deleteDepartment(dId.getString("dId"));
        if (result) {
            return "{\"result\":true}";
        } else {
            return "{\"result\":false}";
        }

    }

    @RequestMapping("/insertDepartment")
    public String insertDepartment(@RequestBody Department department) {

        Boolean result = departmentService.insertDepartment(department);
        if (result) {
            return "{\"result\":true}";
        } else {
            return "{\"result\":false}";
        }
    }

    @RequestMapping("/updateDepartment")
    public String updateDepartment(@RequestBody Department department){
        Boolean result = departmentService.updateDepartment(department);
        if (result) {
            return "{\"result\":true}";
        } else {
            return "{\"result\":false}";
        }
    }

    @RequestMapping("/getPageCount")
    public int getPageCount(@RequestBody JSONObject object){
        return departmentService.getPageCount(object.getInt("pageSize"));
    }
}