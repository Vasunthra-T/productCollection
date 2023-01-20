package com.quinbay.product.service;

import com.quinbay.product.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;

public interface ProductInterface {
    ArrayList<Product> findAllProduct();
    ResponseEntity<Product> findAllProductByID(int id);
    String addProduct(ArrayList<Product>inputProduct);
    void deleteAllData();
    //void deleteProductById(int id);
     Map<String, Boolean> deleteProductById(int id);
    String updateProduct( int id,int price);
   // ResponseEntity<Object> updateStudent(Product product, int id);
}
