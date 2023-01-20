package com.quinbay.wholesaler.web.client;

import com.quinbay.wholesaler.model.Product;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.simple.JSONArray;
@Component
public class WebClientAPI {
    @Autowired
    RestTemplate restTemplate;

    public Product[] getProducts(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);
       return  restTemplate.exchange("http://localhost:8080/getProducts",HttpMethod.GET,entity,Product[].class).getBody();

    }

    public String updateProduct(Product products){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(products,headers);
        return restTemplate.exchange("http://localhost:8080/updateProduct",HttpMethod.POST,entity,String.class).getBody();

    }

    public String getProductDetails(@PathVariable int productId){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/")
                .queryParam("productId",productId)
                .toUriString();
        HttpEntity<String> entity =new HttpEntity<String>(headers);
        return restTemplate.exchange(url,HttpMethod.GET,entity,String.class).getBody();
    }

//    public Product displayProduct(@RequestBody Product product){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/displayProductDetails")
//                .queryParam("product",product)
//                .toUriString();
//        HttpEntity<Product> entity =new HttpEntity<Product>(product,headers);
//        return restTemplate.exchange("http://localhost:8080/displayProductDetails",HttpMethod.POST,entity,Product.class).getBody();
    }
