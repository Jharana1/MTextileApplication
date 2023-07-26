package com.example.textile_app;

public class delivery_model {


    private String dNO;
    private String dDate;
    private String tGray;
    private String cNo;
    private String deNo;
    private String vNo;
    private String dName;
    private String dNumber;

    delivery_model(String dNo,String dDate, String tGray,String cNo, String deNo, String vNo, String dName, String dNumber){
        this.dNO=dNo;
        this.dDate=dDate;
        this.tGray=tGray;
        this.cNo=cNo;
        this.deNo=dNo;
        this.vNo=vNo;
        this.dName=dName;
        this.dNumber= dNumber;


    }

    public String getdNO() {
        return dNO;
    }

    public String getdDate() {
        return dDate;
    }

    public String gettGray() {
        return tGray;
    }

    public String getcNo() {
        return cNo;
    }

    public String getDeNo() {
        return deNo;
    }

    public String getvNo() {
        return vNo;
    }

    public String getdName() {
        return dName;
    }

    public String getdNumber() {
        return dNumber;
    }
}
