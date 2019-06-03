package com.neuedu.hospital_back.po;

import java.sql.Date;

public class RegistrationInfo {

    private int rId;

    private String pId;

    private String pName;

    private Date pBirth;

    private boolean pSex;


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
