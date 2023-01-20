package com.quinbay.wholesaler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WholesalerInventory {
    @Id
    @Column(name="id")
    int id;

    @Column(name="wid")
    int wid;

    @Column(name="pid")
    int pid;

    @Column(name="whid")
    int whid;

    @Column(name="whstock")
    int whstock;

    @Column(name="whprice")
    int whprice;

    public WholesalerInventory(int id, int wid, int pid, int whid, int whstock, int whprice) {
        this.id = id;
        this.wid = wid;
        this.pid = pid;
        this.whid = whid;
        this.whstock = whstock;
        this.whprice = whprice;
    }
    public WholesalerInventory(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getWhid() {
        return whid;
    }

    public void setWhid(int whid) {
        this.whid = whid;
    }

    public int getWhstock() {
        return whstock;
    }

    public void setWhstock(int whstock) {
        this.whstock = whstock;
    }

    public int getWhprice() {
        return whprice;
    }

    public void setWhprice(int whprice) {
        this.whprice = whprice;
    }

}
