package com.neuedu.hospital_back.po;

import java.sql.Date;

public class Patient {
    private int pId;
    private Date pBirth;
    private String pAddress;
    private boolean pSex;
    private String pName;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public Date getpBirth() {
        return pBirth;
    }

    public void setpBirth(Date pBirth) {
        this.pBirth = pBirth;
    }

    public String getpAdress() {
        return pAddress;
    }

    public void setpAdress(String pAdress) {
        this.pAddress = pAdress;
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
