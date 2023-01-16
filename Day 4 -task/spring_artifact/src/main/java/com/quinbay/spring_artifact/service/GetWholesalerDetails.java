package com.quinbay.spring_artifact.service;



import com.quinbay.spring_artifact.model.FetchDetails;
import com.quinbay.spring_artifact.model.Product;
import com.quinbay.spring_artifact.model.Wholesaler;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
@Service
public class GetWholesalerDetails implements FetchDetails {
    @Override
    public String getDetails(int id) {
        ArrayList<Wholesaler> wholesaler_details = ProductService.wholesaler_details;
        String str="";
        for (Wholesaler itr : wholesaler_details) {
            if (itr.getWholesaler_id() == id) {

                str += itr.getWholesaler_id()+" "+itr.getWholesaler_name();
                for(Product pr: itr.wholesaler_product_list)
                {
                    str += " ("+pr.getId()+" "+pr.getName()+" "+pr.getPrice()+" "+pr.getStock()+") ";
                }
            }
        }
        return str;

    }
}

