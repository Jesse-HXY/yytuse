package com.neuedu.hospital_back.po;

public class Doctor {
    private Integer uId;

    private String dVacation;

    private Boolean isDue;

    private String rLName;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getdVacation() {
        return dVacation;
    }

    public void setdVacation(String dVacation) {
        this.dVacation = dVacation;
    }

    public Boolean getIsDue() {
        return isDue;
    }

    public void setIsDue(Boolean isDue) {
        this.isDue = isDue;
    }

    public String getrLName() {
        return rLName;
    }

    public void setrLName(String rLName) {
        this.rLName = rLName;
    }
}