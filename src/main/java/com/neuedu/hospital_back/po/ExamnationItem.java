package com.neuedu.hospital_back.po;

public class ExamnationItem {
    private Integer eIId;

    private String dId;

    private String eIName;

    private String elSpecification;

    private Double eIFee;

    private String elFeeType;

    private String elCode;

    public Integer geteIId() {
        return eIId;
    }

    public void seteIId(Integer eIId) {
        this.eIId = eIId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String geteIName() {
        return eIName;
    }

    public void seteIName(String eIName) {
        this.eIName = eIName;
    }

    public String getElSpecification() {
        return elSpecification;
    }

    public void setElSpecification(String elSpecification) {
        this.elSpecification = elSpecification;
    }

    public Double geteIFee() {
        return eIFee;
    }

    public void seteIFee(Double eIFee) {
        this.eIFee = eIFee;
    }

    public String getElFeeType() {
        return elFeeType;
    }

    public void setElFeeType(String elFeeType) {
        this.elFeeType = elFeeType;
    }

    public String getElCode() {
        return elCode;
    }

    public void setElCode(String elCode) {
        this.elCode = elCode;
    }
}