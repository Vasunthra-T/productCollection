package com.quinbay.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
@Entity
public class Retailer {
    @Id
    @Column(name="id")
    int id;

    @Column(name="rcode")
    int rcode;

    public Retailer(int id, int rcode, String rname) {
        this.id = id;
        this.rcode = rcode;
        this.rname = rname;
    }

    @Column(name="rname")
    String rname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRcode() {
        return rcode;
    }

    public void setRcode(int rcode) {
        this.rcode = rcode;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }




   //public ArrayList<Product> retailer_product_list = new ArrayList<Product>();

    public Retailer(){

    }


}
