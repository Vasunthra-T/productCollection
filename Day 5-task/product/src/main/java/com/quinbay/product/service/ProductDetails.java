package com.quinbay.product.service;

import com.quinbay.product.api.FetchDetails;
import com.quinbay.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ProductDetails implements FetchDetails { //Get product details according to product id
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
