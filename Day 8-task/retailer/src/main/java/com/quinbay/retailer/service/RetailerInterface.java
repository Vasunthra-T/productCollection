package com.quinbay.retailer.service;

import com.quinbay.retailer.model.Retailer;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;

public interface RetailerInterface {
    ArrayList<Retailer> findAllRetailer();
    ResponseEntity<Retailer> findRetailerByID(int id);
    String addRetailer(ArrayList<Retailer>inputRetailer);
    String updateRetailer(int id,int code);
    //void deleteProductById(int id);
    Map<String, Boolean> deleteRetailerById(int id);
}
