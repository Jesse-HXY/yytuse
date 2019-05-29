package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.DepartmentUser;

import java.util.List;

public interface DepartmentUserMapper {

    int insert(DepartmentUser departmentUser);

    List<String> selectByuId(int uId);

    List<Integer> selectBydId(String dId);

    int deleteByuId(int uId);
}
