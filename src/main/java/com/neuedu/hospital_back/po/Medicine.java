package com.neuedu.hospital_back.po;

public class Medicine {
    private Integer mId;

    private String mCode;

    private String mName;

    private String mSpell;

    private String mSpecification;

    private String mUnit;

    private String mProducer;

    private String mType;

    private Double mFee;

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

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSpell() {
        return mSpell;
    }

    public void setmSpell(String mSpell) {
        this.mSpell = mSpell;
    }

    public String getmSpecification() {
        return mSpecification;
    }

    public void setmSpecification(String mSpecification) {
        this.mSpecification = mSpecification;
    }

    public String getmUnit() {
        return mUnit;
    }

    public void setmUnit(String mUnit) {
        this.mUnit = mUnit;
    }

    public String getmProducer() {
        return mProducer;
    }

    public void setmProducer(String mProducer) {
        this.mProducer = mProducer;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public Double getmFee() {
        return mFee;
    }

    public void setmFee(Double mFee) {
        this.mFee = mFee;
    }
}