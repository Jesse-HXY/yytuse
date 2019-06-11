package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Account;
import com.neuedu.hospital_back.po.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

    int insert(Account account);

    int updateUId(@Param("rId") Integer rId, @Param("dId") String dId, @Param("eAId") Integer eAId, @Param("uId") Integer uId);

    List<Medicine> getMedicineByRIdAndTime(@Param("rId") Integer rId, @Param("time") String time);

    int updateFeeById(@Param("accId") Integer accId, @Param("fee") double fee);

    int updateIId(@Param("originalIId") String originalIId, @Param("iId") String iId);

    String getIIdByAccId(Integer accId);

    int updateIIdByAccId(@Param("accId") int accId, @Param("iId") String iId);

  //  int deleteAccount(Integer accId);

//

    List<Medicine> getAlreadyDrawMedicineByRIdAndTime(@Param("rId") Integer rId, @Param("time") String time);
}
