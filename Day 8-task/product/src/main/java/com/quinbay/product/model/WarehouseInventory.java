package com.quinbay.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WarehouseInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int wcode;
    String wname;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWcode() {
        return wcode;
    }

    public void setWcode(int wcode) {
        this.wcode = wcode;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }





}
