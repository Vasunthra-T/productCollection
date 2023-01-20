package com.quinbay.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Wholesaler {
  // @Id
    //@Column(name = "id")
    int id;

    //@Column(name = "whname")
    String whname;

   // @Column(name = "whcode")
    int whcode;


    public Wholesaler(int id, int whcode, String whname) {
        this.id = id;
        this.whname = whname;
        this.whcode = whcode;
    }
    public Wholesaler(){

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
}

