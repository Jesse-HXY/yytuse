package com.neuedu.hospital_back.po;

import java.sql.Date;

public class RegistrationInfo {

    private int rId;

    private String pId;

    private String pName;

    private Date pBirth;

    private String pAddress;

    private boolean pSex;

    private String MorningOrEvening;

    private String rStatus;

    private String dName;

    private boolean okToWithdraw;

    private long rDate;

    private String rTime;

    private String dId;

    private String uId;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public long getrDate() {
        return rDate;
    }

    public void setrDate(long rDate) {
        this.rDate = rDate;
    }


    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }
    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getMorningOrEvening() {
        return MorningOrEvening;
    }

    public void setMorningOrEvening(String MorningOrEvening) {
        this.MorningOrEvening = MorningOrEvening;
    }

    public String getrStatus() {
        return rStatus;
    }

    public void setrStatus(String rStatus) {
        this.rStatus = rStatus;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public boolean isOkToWithdraw() {
        return okToWithdraw;
    }

    public void setOkToWithdraw(boolean okToWithdraw) {
        this.okToWithdraw = okToWithdraw;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Date getpBirth() {
        return pBirth;
    }

    public void setpBirth(Date pBirth) {
        this.pBirth = pBirth;
    }

    public boolean ispSex() {
        return pSex;
    }

    public void setpSex(boolean pSex) {
        this.pSex = pSex;
    }
}
