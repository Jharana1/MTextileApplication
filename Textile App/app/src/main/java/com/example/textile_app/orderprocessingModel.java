package com.example.textile_app;

public class orderprocessingModel {
    private String oDate;
    private String oNumber;
    private String totalGrayLot;
    private String completedGrayLot;
    private String remainingGrayLot;

    orderprocessingModel(String oDate, String oNumber, String totalGrayLot,String completedGrayLot,String remainingGrayLot)
    {
        this.oDate=oDate;
        this.oNumber=oNumber;
        this.totalGrayLot=totalGrayLot;
        this.completedGrayLot=completedGrayLot;
        this.remainingGrayLot=remainingGrayLot;

    }

    public String getoDate(){return oDate;}
    public String getoNumber(){return oNumber;}
    public String getTotalGrayLot(){return totalGrayLot;}
    public String getCompletedGrayLot(){return completedGrayLot;}
    public String getRemainingGrayLot(){return remainingGrayLot;}
}
