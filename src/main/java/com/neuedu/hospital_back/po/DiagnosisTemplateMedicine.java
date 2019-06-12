package com.neuedu.hospital_back.po;

public class DiagnosisTemplateMedicine {

    private Integer diaT_M;

    private Integer mId;

    private Integer datId;

    private String instruction;

    private String dosage;

    private String times;

    private String diaState;

    private String mFormulation;

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    private String dId;

    public String getmFormulation() {
        return mFormulation;
    }

    public void setmFormulation(String mFormulation) {
        this.mFormulation = mFormulation;
    }

    public String getDiaState() {
        return diaState;
    }

    public void setDiaState(String diaState) {
        this.diaState = diaState;
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

    public String getinstruction() {
        return instruction;
    }

    public void setinstruction(String instruction) {
        this.instruction = instruction;
    }
    public Integer getDiaT_M() {
        return diaT_M;
    }

    public void setDiaT_M(Integer diaT_M) {
        this.diaT_M = diaT_M;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getDatId() {
        return datId;
    }

    public void setDatId(Integer datId) {
        this.datId = datId;
    }
}