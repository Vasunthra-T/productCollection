package com.example.billing.controller;

import com.example.billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public class BillingController {
    @Autowired
    BillingService billingService;


//    @GetMapping("/generatePDFWholesaler")
//    public void generatePDFWholesaler() {
//        return billingService.generatePDFWholesaler();
//    }
//
//    @GetMapping("/generatePDFRetailer")
//    public void generatePDFRetailer() {
//        return billingService.generatePDFRetailer();
//    }




}
