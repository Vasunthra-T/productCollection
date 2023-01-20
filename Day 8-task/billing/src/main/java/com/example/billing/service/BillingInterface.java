package com.example.billing.service;

public interface BillingInterface {
    void  generatePDFWholesaler(String whname,int pid,String pname,int price,double gst);
    void  generatePDFRetailer(String rname,int pid,String pname,int price,double gst);
    void sendEmail();

}
