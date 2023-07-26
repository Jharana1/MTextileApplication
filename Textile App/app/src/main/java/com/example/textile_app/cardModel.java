package com.example.textile_app;

public class cardModel {
    private int img;
    private String catalogueN;
    private String designN;
//    private String amount;
//    private  int delete;

    public  cardModel(){

    }


    public cardModel(int img,String catalogueN, String designN, String amount, int delete)
    {
        this.img = img;
        this.catalogueN = catalogueN;
        this.designN = designN;
//        this.amount = amount ;
//        this.delete = delete;
    }

//    public String getImg1() {return img1;}
//
//    public void setImg1(String img1){
//        this.img1=img1;
//    }

    public String getCatalogueN() {
        return catalogueN;
    }

    public void setCatalogueN(String catalogueN){
        this.catalogueN=catalogueN;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDesignN() {
        return designN;
    }
    public void setDesignN(String designN){
        this.designN=designN;
    }
//    public String getAmount() {
//        return amount;
//    }
//
//    public int getDelete(){return delete;}
}
