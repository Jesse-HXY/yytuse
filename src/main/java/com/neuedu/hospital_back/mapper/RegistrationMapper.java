package com.neuedu.hospital_back.mapper;

import com.neuedu.hospital_back.po.Registration;
import com.neuedu.hospital_back.po.RegistrationInfo;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegistrationMapper {

    int insertRegistration(Registration registration);

    List<RegistrationInfo> getAlreadyDiagnosisByuId(@Param("uId") int uId, @Param("pName")String pName);

    List<RegistrationInfo> getNotDiagnosisByuId(@Param("uId") int uId, @Param("pName")String pName);

    List<RegistrationInfo> getAlreadyDiagnosisByuIdAndDId(@Param("uId") int uId, @Param("pName")String pName,@Param("dId")String dId);

    List<RegistrationInfo> getNotDiagnosisByuIdAndDId(@Param("uId") int uId, @Param("pName")String pName,@Param("dId")String dId);

    List<RegistrationInfo> getRegistrationInfoByrId(@Param("rId")int rId);

    int updateRegistration(@Param("rId")int rId, @Param("rStatus")String rStatus);

    List<RegistrationInfo> getRegistrationInfoByrIdOrPName(@Param("rId")int rId, @Param("pName")String pName);

}
