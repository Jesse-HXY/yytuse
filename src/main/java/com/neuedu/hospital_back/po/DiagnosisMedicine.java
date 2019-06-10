package com.neuedu.hospital_back.po;

public class DiagnosisMedicine {
    private Integer dia_M_Id;

    private Integer mId;

    private Integer diaId;

    private String instruction;

    private String dosage;

    private String times;

    private Integer mAmount;

    private String mState;

    private String dId;

    public String getmFormulation() {
        return mFormulation;
    }

    public void setmFormulation(String mFormulation) {
        this.mFormulation = mFormulation;
    }

    private String mFormulation;

    public String getDiaState() {
        return diaState;
    }

    public void setDiaState(String diaState) {
        this.diaState = diaState;
    }

    private String diaState;

    public Integer getmAmount() {
        return mAmount;
    }

    public void setmAmount(Integer mAmount) {
        this.mAmount = mAmount;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

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

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }
}