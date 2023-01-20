package com.quinbay.product.model;

import javax.persistence.*;

/*public class Product {
    int id;
    String name;
    int price;
    int stock;

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    int gst;

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Product() {
    }

    public Product(int id, String name, int price, int stock,int gst) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.gst=gst;
    }

}*/
@Entity
public class Product{
    @Id
    @Column(name="id")
    int id;

    @Column(name = "pcode")
    int pcode;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    int price;

    @Column(name = "gst")
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

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", pcode=" + pcode + ", name=" + name + ", price=" + price +"gst="+gst +"]";
    }





}


