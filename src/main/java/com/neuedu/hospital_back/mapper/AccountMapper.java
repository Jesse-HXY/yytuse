package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    int insert(Account account);

    int updateUId(@Param("rId") Integer rId, @Param("dId") String dId, @Param("eAId") Integer eAId, @Param("uId") Integer uId);
}
