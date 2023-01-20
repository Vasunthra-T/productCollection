package com.quinbay.wholesaler.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.wholesaler.model.Wholesaler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublishingService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void wholesalerInfo(Wholesaler wholesaler){
        try{
            kafkaTemplate.send("send.billingInformation",this.objectMapper.writeValueAsString(wholesaler));

        }catch(Exception e){
            System.out.println("Error in publishing"+e);
        }
    }
}
