package com.neuedu.hospital_back.po;

import java.util.Date;

public class Invoice {
    private String iId;

    private Integer eAId;

    private Integer rId;

    private Integer diaId;

    private Date payTime;

    private String offsetNum;

    private String iState;

    private Integer reprintTime;

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    public Integer geteAId() {
        return eAId;
    }

    public void seteAId(Integer eAId) {
        this.eAId = eAId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getDiaId() {
        return diaId;
    }

    public void setDiaId(Integer diaId) {
        this.diaId = diaId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getOffsetNum() {
        return offsetNum;
    }

    public void setOffsetNum(String offsetNum) {
        this.offsetNum = offsetNum;
    }

    public String getiState() {
        return iState;
    }

    public void setiState(String iState) {
        this.iState = iState;
    }

    public Integer getReprintTime() {
        return reprintTime;
    }

    public void setReprintTime(Integer reprintTime) {
        this.reprintTime = reprintTime;
    }
}