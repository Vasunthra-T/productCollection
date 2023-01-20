package com.quinbay.wholesaler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Wholesaler {
    @Id
    @Column(name="id")
    int id;

    @Column(name="whname")
    String whname;

    @Column(name="whcode")
    int whcode;


    public Wholesaler(int id, int whcode, String whname) {
        this.id = id;
        this.whname = whname;
        this.whcode = whcode;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhname() {
        return whname;
    }

    public void setWhname(String whname) {
        this.whname = whname;
    }

    public int getWhcode() {
        return whcode;
    }

    public void setWhcode(int whcode) {
        this.whcode = whcode;
    }



   // public ArrayList<Product> wholesaler_product_list = new ArrayList<>();

    public Wholesaler(){

    }


//    public Wholesaler(int wholesaler_id, String wholesaler_name) {
//        this.wholesaler_name = wholesaler_name;
//        this.wholesaler_id = wholesaler_id;
//    }
//
//    public String getWholesaler_name() {
//        return wholesaler_name;
//    }
//
//    public void setWholesaler_name(String wholesaler_name) {
//        this.wholesaler_name = wholesaler_name;
//    }
//
//    public int getWholesaler_id() {
//        return wholesaler_id;
//    }
//
//    public void setWholesaler_id(int wholesaler_id) {
//        this.wholesaler_id = wholesaler_id;
//    }
//
//  public void setWholesaler_product_list(Product pr) {
//        this.wholesaler_product_list.add(pr);
//  }

}

