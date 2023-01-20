package com.example.billing.model;

public class Product {
    int id;

   // @Column(name = "pcode")
    int pcode;

  //  @Column(name = "name")
    String name;

 //   @Column(name = "price")
    int price;

 //   @Column(name = "gst")
    double gst;
    public Product(){

    }

    public Product(int id, int pcode, String name, int price, double gst) {
        this.id = id;
        this.pcode = pcode;
        this.name = name;
        this.price = price;
        this.gst = gst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }
    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }



}
