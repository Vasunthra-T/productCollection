package com.quinbay.spring_artifact;

import java.util.ArrayList;

public class ProductRequest {

    public ArrayList<ProductRequest> getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(ArrayList<ProductRequest> productRequest) {
        this.productRequest = productRequest;
    }

    // ProductRequest productRequest = new ProductRequest();
    ArrayList <ProductRequest> productRequest = new ArrayList<>();

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    ProductRequest(){

    }
    ProductRequest(int id,String name)
    {
        this.id =id;
        this.name =name;
    }






}
