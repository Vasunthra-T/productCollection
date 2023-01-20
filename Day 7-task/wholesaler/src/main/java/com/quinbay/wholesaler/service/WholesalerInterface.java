package com.quinbay.wholesaler.service;

import com.quinbay.wholesaler.model.Wholesaler;

import java.util.ArrayList;
import java.util.Map;

public interface WholesalerInterface {
    ArrayList<Wholesaler> findAllWholesaler();
    Wholesaler findWholesalerByID(int id);
    String addWholesaler(ArrayList<Wholesaler>inputWholesaler);
    void deleteAllData();
    //void deleteProductById(int id);
    Map<String, Boolean> deleteWholesalerById(int id);
}
