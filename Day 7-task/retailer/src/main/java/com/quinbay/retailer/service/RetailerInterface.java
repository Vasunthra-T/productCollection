package com.quinbay.retailer.service;

import com.quinbay.retailer.model.Retailer;

import java.util.ArrayList;
import java.util.Map;

public interface RetailerInterface {
    ArrayList<Retailer> findAllRetailer();
    Retailer findRetailerByID(int id);
    String addRetailer(ArrayList<Retailer>inputRetailer);
    void deleteAllData();
    //void deleteProductById(int id);
    Map<String, Boolean> deleteRetailerById(int id);
}
