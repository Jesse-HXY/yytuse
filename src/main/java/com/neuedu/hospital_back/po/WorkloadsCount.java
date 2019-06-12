package com.neuedu.hospital_back.po;

public class WorkloadsCount {
    private int visits;//看诊人次
    private int invoiceNum;//发票数量
    private double zyFee;//中药费
    private double xyFee;//西药费
    private double registrationFee;//挂号费
    private double diagnosticFee;//诊察费
    private double examinationFee;//检查费
    private double testFee;//检验费
    private double treatmentFee;//治疗费
    private double materialFee;//材料费
    private double surgeryFee;//手术费
    private double otherFee;//其他费用
    private double ownExpenses;//自费
    private double medicalInsurance;//医保
    private double nCMS;//新农合

    public double getOwnExpenses() {
        return ownExpenses;
    }

    public void setOwnExpenses(double ownExpenses) {
        this.ownExpenses = ownExpenses;
    }

    public double getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(double medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public double getnCMS() {
        return nCMS;
    }

    public void setnCMS(double nCMS) {
        this.nCMS = nCMS;
    }

    public double getTestFee() {
        return testFee;
    }

    public void setTestFee(double testFee) {
        this.testFee = testFee;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public double getZyFee() {
        return zyFee;
    }

    public void setZyFee(double zyFee) {
        this.zyFee = zyFee;
    }

    public double getXyFee() {
        return xyFee;
    }

    public void setXyFee(double xyFee) {
        this.xyFee = xyFee;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public double getDiagnosticFee() {
        return diagnosticFee;
    }

    public void setDiagnosticFee(double diagnosticFee) {
        this.diagnosticFee = diagnosticFee;
    }

    public double getExaminationFee() {
        return examinationFee;
    }

    public void setExaminationFee(double examinationFee) {
        this.examinationFee = examinationFee;
    }

    public double getTreatmentFee() {
        return treatmentFee;
    }

    public void setTreatmentFee(double treatmentFee) {
        this.treatmentFee = treatmentFee;
    }

    public double getMaterialFee() {
        return materialFee;
    }

    public void setMaterialFee(double materialFee) {
        this.materialFee = materialFee;
    }

    public double getSurgeryFee() {
        return surgeryFee;
    }

    public void setSurgeryFee(double surgeryFee) {
        this.surgeryFee = surgeryFee;
    }

    public double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(double otherFee) {
        this.otherFee = otherFee;
    }
}
