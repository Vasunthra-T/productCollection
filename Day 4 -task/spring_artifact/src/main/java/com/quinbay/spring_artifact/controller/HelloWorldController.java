package com.quinbay.spring_artifact.controller;

import com.quinbay.spring_artifact.model.Product;
import com.quinbay.spring_artifact.model.Wholesaler;
import com.quinbay.spring_artifact.model.Retailer;

import com.quinbay.spring_artifact.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.quinbay.spring_artifact.ProductRequest;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/api")
public class HelloWorldController {
    @Autowired
    ProductService pr;
    @Autowired
    GetProductDetails gpd;
    @Autowired
    GetWholesalerDetails gwd;
    @Autowired
    GetRetailerDetails grd;


    @GetMapping("/loadData")
    public String loadData(){
        pr.Service();
        return "data loaded";
    }



    @GetMapping("/displayProduct/{productId}")
    public String viewProduct(@PathVariable int productId)
    {
        //pr.Service();
        return gpd.getDetails(productId);
    }

    @GetMapping("/displayWholesaler/{wholesalerId}")
    public String viewWholesaler(@PathVariable int wholesalerId){
        return gwd.getDetails(wholesalerId);
    }

    @GetMapping("/displayRetailer/{retailerId}")
    public String viewRetailer(@PathVariable int retailerId){
        return grd.getDetails(retailerId);
    }

    @PostMapping("/addProduct")
    public String postData(@RequestBody ArrayList<Product> inputProduct)
    {
        return pr.addProduct(inputProduct);
    }

    @PostMapping("/addWholeSaler")
    public String addWholeSaler(@RequestBody ArrayList<Wholesaler> inputWholeSaler)
    {
        return pr.addWholeSaler(inputWholeSaler);
    }

    @PostMapping("/addRetailer")
    public String addRetailer(@RequestBody ArrayList<Retailer> inputRetailer)
    {
        return pr.addRetailer(inputRetailer);
    }

    @PutMapping("/allocateWholeSaler/{wholeSalerId}/{productId}/{itemCountToBuy}")
    public String allocateWholesaler(@PathVariable int wholeSalerId,@PathVariable int productId,@PathVariable int itemCountToBuy){
        pr.allocateWholesaler(wholeSalerId,productId,itemCountToBuy);
        return gwd.getDetails(wholeSalerId);
    }

    @PutMapping("/allocateRetailer/{retailerId}/{wholeSalerId}/{productId}/{itemCountToBuy}")
    public String allocateRetailer(@PathVariable int retailerId,@PathVariable int wholeSalerId,@PathVariable int productId,@PathVariable int itemCountToBuy){
        pr.allocateRetailer(retailerId,wholeSalerId,productId,itemCountToBuy);
        return grd.getDetails(retailerId);
    }




}
