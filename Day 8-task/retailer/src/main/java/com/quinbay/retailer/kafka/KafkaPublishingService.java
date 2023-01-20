package com.quinbay.retailer.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.retailer.model.Retailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaPublishingService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void retailerInfo(Retailer retailer){
        try{
            kafkaTemplate.send("send.billingInformation",this.objectMapper.writeValueAsString(retailer));

        }catch(Exception e){
            System.out.println("Error in publishing"+e);
        }
    }
}
