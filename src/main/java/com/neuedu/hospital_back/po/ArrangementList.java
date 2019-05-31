package com.neuedu.hospital_back.po;

public class ArrangementList {
    private String arName;
    private String rLName;
    private String uName;
    private int arPlan;
    private int uId;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    private int[] arPlanList = new int[14];

    public int getArPlan() {
        return arPlan;
    }

    public void setArPlan(int arPlan) {
        this.arPlan = arPlan;
    }

    public int[] getArPlanList() {
        return arPlanList;
    }

    public void setArPlanList(int[] arPlanList) {
        this.arPlanList = arPlanList;
    }

    public String getArName() {
        return arName;
    }

    public void setArName(String arName) {
        this.arName = arName;
    }

    public String getrLName() {
        return rLName;
    }

    public void setrLName(String rLName) {
        this.rLName = rLName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

}
