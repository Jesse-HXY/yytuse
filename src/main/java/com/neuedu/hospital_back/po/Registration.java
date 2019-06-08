package com.neuedu.hospital_back.po;

public class Registration {
    private int rId;
    private int drId;
    private int eId;
    private String dId;
    private int mRId;
    private String rLName;
    private String pId;
    private int uId;
    private int rOrder;
    private double rFee;
    private String rStatus;
    private String payType;
    private boolean hasMedicalHistory;
    private long rDate;
    private String rResult;

    public String getrResult() {
        return rResult;
    }

    public void setrResult(String rResult) {
        this.rResult = rResult;
    }

    public long getrDate() {
        return rDate;
    }

    public void setrDate(long rDate) {
        this.rDate = rDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getDrId() {
        return drId;
    }

    public void setDrId(int drId) {
        this.drId = drId;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public int getmRId() {
        return mRId;
    }

    public void setmRId(int mRId) {
        this.mRId = mRId;
    }

    public String getrLName() {
        return rLName;
    }

    public void setrLName(String rLName) {
        this.rLName = rLName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getrStatus() {
        return rStatus;
    }

    public void setrStatus(String rStatus) {
        this.rStatus = rStatus;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getrOrder() {
        return rOrder;
    }

    public void setrOrder(int rOrder) {
        this.rOrder = rOrder;
    }

    public double getrFee() {
        return rFee;
    }

    public void setrFee(double rFee) {
        this.rFee = rFee;
    }

    public boolean getHasMedicalHistory() {
        return hasMedicalHistory;
    }

    public void setHasMedicalHistory(boolean hasMedicalHistory) {
        this.hasMedicalHistory = hasMedicalHistory;
    }
}
