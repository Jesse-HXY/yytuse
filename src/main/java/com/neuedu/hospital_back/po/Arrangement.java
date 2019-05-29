package com.neuedu.hospital_back.po;

import java.util.Date;

public class Arrangement {
    private Integer aId;

    private String arId;

    private Date aBegin;

    private Date aEnd;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId;
    }

    public Date getaBegin() {
        return aBegin;
    }

    public void setaBegin(Date aBegin) {
        this.aBegin = aBegin;
    }

    public Date getaEnd() {
        return aEnd;
    }

    public void setaEnd(Date aEnd) {
        this.aEnd = aEnd;
    }
}