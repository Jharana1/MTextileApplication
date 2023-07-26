package com.example.textile_app;

public class greyModel {

    private String srNo;
    private String grayType;
    private String grayLot;
    private String dDate;
    private String dNumber;

    greyModel(String srNo, String grayType, String grayLot, String dDate, String dNumber)
    {
        this.srNo = srNo;
        this.grayType = grayType;
        this.grayLot = grayLot;
        this.dDate = dDate;
        this.dNumber = dNumber;
    }

    public String getSrNo() {
        return srNo;
    }

    public String getGrayType() {
        return grayType;
    }

    public String getGrayLot() {
        return grayLot;
    }

    public String getdDate() {
        return dDate;
    }

    public String getdNumber() {
        return dNumber;
    }
}
