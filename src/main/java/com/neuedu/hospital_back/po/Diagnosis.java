package com.neuedu.hospital_back.po;

import java.util.List;

public class Diagnosis {
    private Integer diaId;

    private String diaType;

    private Integer rId;

    private String diaName;

    private Long createDate;

    private Long useDate;

    private String diaState;

    private List<DiagnosisMedicine> diagnosisMedicines;

    public Diagnosis() {
    }

    public Diagnosis( String diaType, Integer rId, String diaName, Long createDate, String diaState) {
        this.diaType = diaType;
        this.rId = rId;
        this.diaName = diaName;
        this.createDate = createDate;
        this.diaState = diaState;
    }

    public List<DiagnosisMedicine> getDiagnosisMedicines() {
        return diagnosisMedicines;
    }

    public void setDiagnosisMedicines(List<DiagnosisMedicine> diagnosisMedicines) {
        this.diagnosisMedicines = diagnosisMedicines;
    }

    public Integer getDiaId() {
        return diaId;
    }

    public void setDiaId(Integer diaId) {
        this.diaId = diaId;
    }

    public String getDiaType() {
        return diaType;
    }

    public void setDiaType(String diaType) {
        this.diaType = diaType;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getDiaName() {
        return diaName;
    }

    public void setDiaName(String diaName) {
        this.diaName = diaName;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getUseDate() {
        return useDate;
    }

    public void setUseDate(Long useDate) {
        this.useDate = useDate;
    }

    public String getDiaState() {
        return diaState;
    }

    public void setDiaState(String diaState) {
        this.diaState = diaState;
    }
}