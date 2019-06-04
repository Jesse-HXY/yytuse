package com.neuedu.hospital_back.po;

import java.util.Date;
import java.util.List;

public class ExamnationTemplate {
    private Integer eTId;

    private String eTName;

    private long eTDate;

    private String eTScope;

    private String recordType;

    private List<ExamnationItem> examnationItemList;

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<ExamnationItem> getExamnationItemList() {
        return examnationItemList;
    }

    public void setExamnationItemList(List<ExamnationItem> examnationItemList) {
        this.examnationItemList = examnationItemList;
    }

    public Integer geteTId() {
        return eTId;
    }

    public void seteTId(Integer eTId) {
        this.eTId = eTId;
    }

    public String geteTName() {
        return eTName;
    }

    public void seteTName(String eTName) {
        this.eTName = eTName;
    }

    public long geteTDate() {
        return eTDate;
    }

    public void seteTDate(long eTDate) {
        this.eTDate = eTDate;
    }

    public String geteTScope() {
        return eTScope;
    }

    public void seteTScope(String eTScope) {
        this.eTScope = eTScope;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }
}