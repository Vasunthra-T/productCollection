package com.quinbay.retailer.service;

import com.quinbay.retailer.api.FetchDetails;
import com.quinbay.retailer.model.Product;
import com.quinbay.retailer.model.Retailer;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class RetailerDetails implements FetchDetails {
//    @Override
//    public String getDetails(int id) { //Get wholesaler details according to wholesaler id
//        ArrayList<Retailer> retailer_details = RetailerService.retailer_details;
//        String str="";
//        for (Retailer itr : retailer_details) {
//            if (itr.getRetailer_id() == id) {
//
//                str += itr.getRetailer_id()+" "+itr.getRetailer_name();
//                for(Product pr: itr.retailer_product_list)
//                {
//                    str += " ("+pr.getId()+" "+pr.getName()+" "+pr.getPrice()+" "+pr.getStock()+") ";
//                }
//            }
//        }
//        return str;
//
//    }
//
//}
