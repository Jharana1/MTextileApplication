package com.example.textile_app;

public class wholesalerModel {

    private int img;
    private String catalogueN;
    private String designN;


    wholesalerModel(int img,String catalogueN, String designN)
    {
        this.img = img;
        this.catalogueN = catalogueN;
        this.designN = designN;
    }

    public int getImg() {
        return img;
    }

    public String getCatalogueN() {
        return catalogueN;
    }

    public String getDesignN() {
        return designN;
    }
}
