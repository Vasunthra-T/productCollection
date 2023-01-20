package com.quinbay.product.service;

import com.quinbay.product.model.Product;
import com.quinbay.product.model.Warehouse;

import java.util.ArrayList;
import java.util.Map;

public interface WarehouseInterface {
    ArrayList<Warehouse> findAllWarehouse();
    Product findAllWarehouseByID(int id);
    String addWarehouse(ArrayList<Warehouse>inputWarehouse);
    void deleteAllWarehouse();
    Map<String, Boolean> deleteWarehouseById(int id);
    String updateWarehouse( int id,String wname);
}
