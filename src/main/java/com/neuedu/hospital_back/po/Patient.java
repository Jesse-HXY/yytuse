package com.neuedu.hospital_back.po;

import java.sql.Date;

public class Patient {
    private String pId;
    private Date pBirth;
    private String pAddress;
    private boolean pSex;
    private String pName;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Date getpBirth() {
        return pBirth;
    }

    public void setpBirth(Date pBirth) {
        this.pBirth = pBirth;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public boolean ispSex() {
        return pSex;
    }

    public void setpSex(boolean pSex) {
        this.pSex = pSex;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
}
