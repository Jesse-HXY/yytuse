package com.neuedu.hospital_back.po;

import java.util.List;

public class DiagnosisTemplate {
    private Integer datId;

    private String diaType;

    private String datName;

    private Long datTime;

    private String datScope;

    private List<Medicine> medicines;

    private Department department;
    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getDatId() {
        return datId;
    }

    public void setDatId(Integer datId) {
        this.datId = datId;
    }

    public String getDiaType() {
        return diaType;
    }

    public void setDiaType(String diaType) {
        this.diaType = diaType;
    }

    public String getDatName() {
        return datName;
    }

    public void setDatName(String datName) {
        this.datName = datName;
    }

    public Long getDatTime() {
        return datTime;
    }

    public void setDatTime(Long datTime) {
        this.datTime = datTime;
    }

    public String getDatScope() {
        return datScope;
    }

    public void setDatScope(String datScope) {
        this.datScope = datScope;
    }
}