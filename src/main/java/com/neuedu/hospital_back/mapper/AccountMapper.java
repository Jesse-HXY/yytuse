package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Account;
import com.neuedu.hospital_back.po.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

    int insert(Account account);

    int updateUId(@Param("rId") Integer rId, @Param("dId") String dId, @Param("eAId") Integer eAId, @Param("uId") Integer uId);

    List<Medicine> getMedicineByRIdAndTime(@Param("rId") Integer rId, @Param("time") String time);

    int updateFeeByrId(@Param("accId") Integer accId, @Param("fee") double fee);

    int getAccId(@Param("rId") Integer rId, @Param("time") String time,@Param("dia_M_Id")Integer dia_M_Id);

    List<Medicine> getAlreadyDrawMedicineByRIdAndTime(@Param("rId") Integer rId, @Param("time") String time);
}
