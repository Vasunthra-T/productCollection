package com.quinbay.wholesaler.model;

import java.util.ArrayList;

public class Wholesaler {
    String wholesaler_name;
    int wholesaler_id;
    public ArrayList<Product> wholesaler_product_list = new ArrayList<>();

    public Wholesaler(){

    }

    public Wholesaler(int wholesaler_id, String wholesaler_name) {
        this.wholesaler_name = wholesaler_name;
        this.wholesaler_id = wholesaler_id;
    }

    public String getWholesaler_name() {
        return wholesaler_name;
    }

    public void setWholesaler_name(String wholesaler_name) {
        this.wholesaler_name = wholesaler_name;
    }

    public int getWholesaler_id() {
        return wholesaler_id;
    }

    public void setWholesaler_id(int wholesaler_id) {
        this.wholesaler_id = wholesaler_id;
    }

  public void setWholesaler_product_list(Product pr) {
        this.wholesaler_product_list.add(pr);
  }

}

