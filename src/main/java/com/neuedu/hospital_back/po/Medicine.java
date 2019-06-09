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

    private String instruction;

    private String dosage;

    private String times;

    private int mAmount;

    private long useDate;

    private String diaState;

    public int getDia_M_Id() {
        return dia_M_Id;
    }

    public void setDia_M_Id(int dia_M_Id) {
        this.dia_M_Id = dia_M_Id;
    }

    public long getUseDate() {
        return useDate;
    }

    public void setUseDate(long useDate) {
        this.useDate = useDate;
    }

    public String getDiaState() {
        return diaState;
    }

    public void setDiaState(String diaState) {
        this.diaState = diaState;
    }

    private int dia_M_Id;


    private String mFormulation;

    public String getmFormulation() {
        return mFormulation;
    }

    public void setmFormulation(String mFormulation) {
        this.mFormulation = mFormulation;
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
    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getmAmount() {
        return mAmount;
    }

    public void setmAmount(int mAmount) {
        this.mAmount = mAmount;
    }

}