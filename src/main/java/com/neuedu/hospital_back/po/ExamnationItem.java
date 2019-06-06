package com.neuedu.hospital_back.po;

public class ExamnationItem {

    private Integer eIId;

    private String eIName;

    private String eISpecification;

    private Double eIFee;

    private String eIFeeType;

    private String eICode;

    @Override
    public String toString() {
        return "ExamnationItem{" +
                "eIId=" + eIId +
                ", eIName='" + eIName + '\'' +
                ", eISpecification='" + eISpecification + '\'' +
                ", eIFee=" + eIFee +
                ", eIFeeType='" + eIFeeType + '\'' +
                ", eICode='" + eICode + '\'' +
                '}';
    }

    public String geteISpecification() {
        return eISpecification;
    }

    public void seteISpecification(String eISpecification) {
        this.eISpecification = eISpecification;
    }

    public Double geteIFee() {
        return eIFee;
    }

    public void seteIFee(Double eIFee) {
        this.eIFee = eIFee;
    }

    public String geteIFeeType() {
        return eIFeeType;
    }

    public void seteIFeeType(String eIFeeType) {
        this.eIFeeType = eIFeeType;
    }

    public String geteICode() {
        return eICode;
    }

    public void seteICode(String eICode) {
        this.eICode = eICode;
    }



    public Integer geteIId() {
        return eIId;
    }

    public void seteIId(Integer eIId) {
        this.eIId = eIId;
    }

    public String geteIName() {
        return eIName;
    }

    public void seteIName(String eIName) {
        this.eIName = eIName;
    }


}