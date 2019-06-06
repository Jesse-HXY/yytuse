package com.neuedu.hospital_back.po;

public class DiagnosisMedicine {
    private Integer dia_M_Id;

    private Integer mId;

    private Integer diaId;

    private String instruction;

    private String dosage;

    private String times;

    public Integer getmAmount() {
        return mAmount;
    }

    public void setmAmount(Integer mAmount) {
        this.mAmount = mAmount;
    }

    private Integer mAmount;

    public Integer getDia_M_Id() {
        return dia_M_Id;
    }

    public void setDia_M_Id(Integer dia_M_Id) {
        this.dia_M_Id = dia_M_Id;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getDiaId() {
        return diaId;
    }

    public void setDiaId(Integer diaId) {
        this.diaId = diaId;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}