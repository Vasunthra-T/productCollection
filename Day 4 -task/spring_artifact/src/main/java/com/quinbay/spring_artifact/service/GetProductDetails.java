package com.quinbay.spring_artifact.service;

import com.quinbay.spring_artifact.model.FetchDetails;
import com.quinbay.spring_artifact.model.Product;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
@Service
public class GetProductDetails implements FetchDetails {
    @Override
    public String getDetails(int id){
        ArrayList<Product> products = ProductService.products;
        for (Product itr : products) {
            if (itr.getId() == id) {
                return itr.getId()+" "+itr.getName()+" "+itr.getPrice()+" "+itr.getStock();

            }
        }
        return "No products found";
    }
}
