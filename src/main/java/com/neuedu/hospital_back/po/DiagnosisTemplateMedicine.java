package com.neuedu.hospital_back.po;

public class DiagnosisTemplateMedicine {

    private Integer diaT_M;

    private Integer mId;

    private Integer datId;

    private String usage;

    private String dosage;

    private String times;

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
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