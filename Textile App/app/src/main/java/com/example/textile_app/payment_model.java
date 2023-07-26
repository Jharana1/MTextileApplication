package com.example.textile_app;

public class payment_model {

    private String oNo;
    private String oDate;
    private String tAmount;
    private String aPay;
    private String rAmount;
    private String status;

    payment_model(String oNo, String oDate, String tAmount, String aPay, String rAmount, String status){
        this.oDate=oDate;
        this.oNo=oNo;
        this.tAmount=tAmount;
        this.aPay=aPay;
        this.rAmount=rAmount;
        this.status=status;


    }

    public String getoNo() {
        return oNo;
    }

    public String getoDate() {
        return oDate;
    }

    public String gettAmount() {
        return tAmount;
    }

    public String getaPay(){return aPay;}

    public String getrAmount() {
        return rAmount;
    }

    public String getStatus() {
        return status;
    }
}

