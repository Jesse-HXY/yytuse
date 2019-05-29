package com.neuedu.hospital_back;

import com.neuedu.hospital_back.po.Department;
import com.neuedu.hospital_back.po.User;
import com.neuedu.hospital_back.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTest {

    @Resource
    private DepartmentService departmentService;

    @Test
    public void getDepartmentTest() {
        Department department = new Department();
        department.setdId("AZBK");
        List<Department> departments = departmentService.getDepartments(department);
        System.out.println(departments);
    }


    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setdId("df");
        department.setdName("h3h");
        department.setdType("内科");
        department.setdCategory("临床科室");
        assertEquals(true, departmentService.insertDepartment(department));
    }

    @Test
    public void updateDepartment(){
        Department department = new Department();
        department.setdId("BLK");
        department.setdName("病理科");
        department.setdType("东北");
        department.setdCategory("你好");
        assertEquals(true, departmentService.updateDepartment(department));
    }

}
