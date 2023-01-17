package com.quinbay.retailer.model;

import java.util.ArrayList;

public class Retailer {
    String retailer_name;
    int retailer_id;
  //  public ArrayList<Product> retailer_product_list = new ArrayList<Product>();

    public Retailer(){

    }

    public Retailer(int retailer_id, String retailer_name) {
        this.retailer_name = retailer_name;
        this.retailer_id = retailer_id;
    }

    public String getRetailer_name() {
        return retailer_name;
    }

    public void setRetailer_name(String retailer_name) {
        this.retailer_name = retailer_name;
    }

    public int getRetailer_id() {
        return retailer_id;
    }

    public void setRetailer_id(int retailer_id) {
        this.retailer_id = retailer_id;
    }

  //  public void setRetailerProductList(Product pr) {
 //       this.retailer_product_list.add(pr);
   // }
}
