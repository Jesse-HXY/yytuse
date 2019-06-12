package com.neuedu.hospital_back.po;

public class Account {

    private Integer accId;
    private String dId;
    private int uId;
    private long payTime;
    private Double fee;
    private String feeType;
    private String payType;
    private Integer rId;
    private int cId;//收费员Id
    private int eAId;
    private String postDId;//开单科室Id
    private Integer dia_M_Id;

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    private String iId;

    public String getPostDId() {
        return postDId;
    }

    public void setPostDId(String postDId) {
        this.postDId = postDId;
    }

    public int geteAId() {
        return eAId;
    }

    public void seteAId(int eAId) {
        this.eAId = eAId;
    }

    public Integer getDia_M_Id() {
        return dia_M_Id;
    }

    public void setDia_M_Id(Integer dia_M_Id) {
        this.dia_M_Id = dia_M_Id;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public long getPayTime() {
        return payTime;
    }

    public void setPayTime(long payTime) {
        this.payTime = payTime;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
}