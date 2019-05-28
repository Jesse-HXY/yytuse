package com.neuedu.hospital_back.po;

public class RegistrationLevel {
    private Integer rLId;

    private String rLName;

    private Integer rLLimitation;

    private Double rLFee;

    public Integer getrLId() {
        return rLId;
    }

    public void setrLId(Integer rLId) {
        this.rLId = rLId;
    }

    public String getrLName() {
        return rLName;
    }

    public void setrLName(String rLName) {
        this.rLName = rLName;
    }

    public Integer getrLLimitation() {
        return rLLimitation;
    }

    public void setrLLimitation(Integer rLLimitation) {
        this.rLLimitation = rLLimitation;
    }

    public Double getrLFee() {
        return rLFee;
    }

    public void setrLFee(Double rLFee) {
        this.rLFee = rLFee;
    }
}