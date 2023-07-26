package com.example.textile_app;

public class payment_history_model {



    private String pId;
    private String oNO;
    private String tAmount;
    private String pDetail;


    payment_history_model(String pId,String oNO, String tAmount,String pDetail){
        this.pId=pId;
        this.oNO=oNO;
        this.tAmount=tAmount;
        this.pDetail=pDetail;



    }

    public String getpId() {
        return pId;
    }

    public String getoNO() {
        return oNO;
    }

    public String gettAmount() {
        return tAmount;
    }

    public String getpDetail() {
        return pDetail;
    }
}
