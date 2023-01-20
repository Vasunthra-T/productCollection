package com.quinbay.wholesaler.service;

import com.quinbay.wholesaler.model.Wholesaler;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;

public interface WholesalerInterface {
    ArrayList<Wholesaler> findAllWholesaler();
    Wholesaler findWholesalerByID(int id);
    String addWholesaler(ArrayList<Wholesaler>inputWholesaler);
    void deleteAllData();
    //String updateWholesaler(int id,int code);
   // void deleteProductById(int id);
    Map<String, Boolean> deleteWholesalerById(int id);
    ResponseEntity<Wholesaler> findWholesaler(int wid);
    String updateWholesaler(int id,int code);
}
