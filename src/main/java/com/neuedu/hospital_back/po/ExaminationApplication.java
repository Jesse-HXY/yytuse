package com.neuedu.hospital_back.po;

public class ExaminationApplication {

    private int eAId;
    private String eAName;
    private int eIId;
    private String dId;
    private String eAStatus;
    private int rId;
    private String eAResult;
    private ExamnationItem examnationItem;

    public ExamnationItem getExamnationItem() {
        return examnationItem;
    }

    public void setExamnationItem(ExamnationItem examnationItem) {
        this.examnationItem = examnationItem;
    }

    public String geteAResult() {
        return eAResult;
    }

    public void seteAResult(String eAResult) {
        this.eAResult = eAResult;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int geteAId() {
        return eAId;
    }

    public void seteAId(int eAId) {
        this.eAId = eAId;
    }

    public String geteAName() {
        return eAName;
    }

    public void seteAName(String eAName) {
        this.eAName = eAName;
    }

    public int geteIId() {
        return eIId;
    }

    public void seteIId(int eIId) {
        this.eIId = eIId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String geteAStatus() {
        return eAStatus;
    }

    public void seteAStatus(String eAStatus) {
        this.eAStatus = eAStatus;
    }
}
