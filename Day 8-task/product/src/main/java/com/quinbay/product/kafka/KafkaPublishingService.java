package com.quinbay.product.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublishingService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void productInfo(Product product){
        try{
            kafkaTemplate.send("send.billingInformation",this.objectMapper.writeValueAsString(product));

        }catch(Exception e){
            System.out.println("Error in publishing"+e);
        }
    }
}
