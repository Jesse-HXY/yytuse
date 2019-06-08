package com.neuedu.hospital_back.po;

public class DiagnosisType {

    private int rId;
    private int disId;
    private String diaType;
    private long diaTime;
    private Disease disease;

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public int getDisId() {
        return disId;
    }

    public void setDisId(int disId) {
        this.disId = disId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getDiaType() {
        return diaType;
    }

    public void setDiaType(String diaType) {
        this.diaType = diaType;
    }

    public long getDiaTime() {
        return diaTime;
    }

    public void setDiaTime(long diaTime) {
        this.diaTime = diaTime;
    }
}
