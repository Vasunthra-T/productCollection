package com.example.billing.kafka;

import com.example.billing.model.Product;
import com.example.billing.model.Retailer;
import com.example.billing.model.Wholesaler;
import com.example.billing.service.BillingService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class KafkaListeners {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    BillingService billingService;

    @KafkaListener(topics="send.billingInformation",groupId = "billing")
    public void getWholesaler(ConsumerRecord<?,String> consumerRecord){
       Wholesaler wholesaler =null;
       Product product =null;
        Retailer retailer =null;
        try{
            product = objectMapper.readValue(consumerRecord.value(), new TypeReference<Product>() {
            });
            wholesaler = objectMapper.readValue(consumerRecord.value(), new TypeReference<Wholesaler>() {
            });
            retailer = objectMapper.readValue(consumerRecord.value(), new TypeReference<Retailer>() {
            });
            String whname=wholesaler.getWhname();
            int pid=product.getId();
            String pname=product.getName();
            int price=product.getPrice();
           double gst=product.getGst();
            String rname=retailer.getRname();
            System.out.println(retailer.getRname());
            System.out.println(wholesaler.getWhname());
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getGst());
            System.out.println(retailer.getRname());

            billingService.sendEmail();

            Scanner sc = new Scanner(System.in);

            System.out.println("Want to generate bill for?");
            System.out.println("Enter 1 for wholesaler");
            System.out.println("Enter 2 for retailer");
            System.out.println("Enter 3 for both");
            int user = sc.nextInt();

            switch(user)
            {
                case 1:
                {
                    billingService.generatePDFWholesaler(whname,pid,pname,price,gst);
                    break;

                }
                case 2:
                {
                    billingService.generatePDFRetailer(rname,pid,pname,price,gst);
                    break;
                }
                case 3:
                {
                    billingService.generatePDFWholesaler(whname,pid,pname,price,gst);
                    billingService.generatePDFRetailer(rname,pid,pname,price,gst);
                    }

                }


        }catch(Exception e){

        }
      }

}