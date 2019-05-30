package com.neuedu.hospital_back.po;

public class DoctorArrangementRegulation {
    private Integer do_Ar_Id;

    private Integer uId;

    private Integer arId;

    private Integer arPlan;

    public Integer getDo_Ar_Id() {
        return do_Ar_Id;
    }

    public void setDo_Ar_Id(Integer do_Ar_Id) {
        this.do_Ar_Id = do_Ar_Id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public Integer getArPlan() {
        return arPlan;
    }

    public void setArPlan(Integer arPlan) {
        this.arPlan = arPlan;
    }
}