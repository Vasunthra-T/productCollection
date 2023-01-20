//package com.quinbay.product.kafka;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.quinbay.product.model.Wholesaler;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaListeners {
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @KafkaListener(topics="send.wholesalerInformation",groupId = "billing")
//    public void getWholesaler(ConsumerRecord<?,String> consumerRecord){
//        Wholesaler wholesaler =null;
//        try{
//            wholesaler = objectMapper.readValue(consumerRecord.value(), new TypeReference<Wholesaler>() {
//            });
//            System.out.println(wholesaler.getWhname());
//        }catch(Exception e){
//
//        }
//    }
//
//}
