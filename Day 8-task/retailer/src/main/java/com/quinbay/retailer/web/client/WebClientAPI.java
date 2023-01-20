package com.quinbay.retailer.web.client;

import com.quinbay.retailer.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class WebClientAPI {

    @Autowired
    RestTemplate restTemplate;

    public Product[] getWholesaler(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);
        return  restTemplate.exchange("http://localhost:8080/getWholesaler",HttpMethod.GET,entity,Product[].class).getBody();

    }

}
