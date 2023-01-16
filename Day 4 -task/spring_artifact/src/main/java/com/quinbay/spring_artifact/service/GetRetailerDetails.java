package com.quinbay.spring_artifact.service;

import com.quinbay.spring_artifact.model.FetchDetails;
import com.quinbay.spring_artifact.model.Product;
import com.quinbay.spring_artifact.model.Retailer;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
@Service
public class GetRetailerDetails implements FetchDetails {
    @Override
    public String getDetails(int id) {
        ArrayList<Retailer> retailer_details = ProductService.retailer_details;
        String str="";
        for (Retailer itr : retailer_details) {
            if (itr.getRetailer_id() == id) {

                str += itr.getRetailer_id()+" "+itr.getRetailer_name();
                for(Product pr: itr.retailer_product_list)
                {
                    str += " ("+pr.getId()+" "+pr.getName()+" "+pr.getPrice()+" "+pr.getStock()+") ";
                }
            }
        }
        return str;

    }
}



