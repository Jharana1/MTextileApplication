package com.example.textile_app;

public class order_detail_model {

    private String oDate;
    private String oNo;
    private String tGray;
    private String mType;
    private String cNo;
    private String dNo;
    private String apLot;
    private String tAmount;
    private String status;

    order_detail_model(String oDate,String oNo, String tGray, String mType, String cNo, String dNo, String apLot, String tAmount, String status){
        this.oDate=oDate;
        this.oNo=oNo;
        this.tGray=tGray;
        this.mType=mType;
        this.cNo=cNo;
        this.dNo=dNo;
        this.apLot=apLot;
        this.tAmount=tAmount;
        this.status=status;


    }

    public String getoDate() {
        return oDate;
    }

    public String getoNo() {
        return oNo;
    }

    public String gettGray() {
        return tGray;
    }

    public String getmType() {
        return mType;
    }

    public String getcNo() {
        return cNo;
    }

    public String getdNo() {
        return dNo;
    }

    public String getApLot() {
        return apLot;
    }

    public String gettAmount() {
        return tAmount;
    }

    public String getStatus() {
        return status;
    }
}
