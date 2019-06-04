package com.neuedu.hospital_back.po;

import java.util.Date;

public class ExamnationTemplate {
    private Integer eTId;

    private String eTName;

    private long eTDate;

    private String eTScope;

    private String recordType;

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