package com.quinbay.retailer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RetailerInventory {
    @Id
    @Column(name="id")
    int id;

    @Column(name="whid")
    int whid;

    @Column(name="pid")
    int pid;

    @Column(name="rid")
    int rid;

    @Column(name="rstock")
    int rstock;

    @Column(name="rprice")
    int rprice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWhid() {
        return whid;
    }

    public void setWhid(int whid) {
        this.whid = whid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getRstock() {
        return rstock;
    }

    public void setRstock(int rstock) {
        this.rstock = rstock;
    }

    public int getRprice() {
        return rprice;
    }

    public void setRprice(int rprice) {
        this.rprice = rprice;
    }

    public RetailerInventory(){

    }

    public RetailerInventory(int id, int whid, int pid, int rid, int rstock, int rprice) {
        this.id = id;
        this.whid = whid;
        this.pid = pid;
        this.rid = rid;
        this.rstock = rstock;
        this.rprice = rprice;
    }
}
