package com.quinbay.retailer.controller;

import com.quinbay.retailer.model.Retailer;
//import com.quinbay.retailer.service.RetailerDetails;
import com.quinbay.retailer.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class RetailerController {
    @Autowired
    RetailerService retailerService;

    @PostMapping("/addRetailer")
    public String postData(@RequestBody ArrayList<Retailer> inputRetailer)
    {
        return retailerService.addRetailer(inputRetailer);
    }
    @GetMapping("/findall")
    public ArrayList<Retailer> getAllProduct() {
        return retailerService.findAllRetailer();
    }

    @GetMapping("/findbyid/{id}")
    public Retailer getRetailerUsingId(@PathVariable int id) {
        return retailerService.findRetailerByID(id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public Map<String, Boolean> deleteProductUsingId(@PathVariable(value = "id") Integer id){
        return retailerService.deleteRetailerById(id);
    }

    @DeleteMapping("/delete")
    public void delete() {
        retailerService.deleteAllData();
    }

//    @Autowired
//    RetailerService retailerService;
//    @Autowired
//    RetailerDetails retailerDetails;
//
//    @GetMapping("/loadData")
//    public String loadData(){
//        retailerService.Service();
//        return "Data loaded";
//    }
//
//    @GetMapping("/displayRetailer/{retailerId}")
//    public String viewProduct(@PathVariable int retailerId)
//    {
//        //pr.Service();
//        return retailerDetails.getDetails(retailerId);
//    }
//    @PostMapping("/addRetailer")
//    public String postData(@RequestBody ArrayList<Retailer> inputRetailer)
//    {
//        return retailerService.addRetailer(inputRetailer);
//    }
//    @PostMapping("/updateRetailer")
//    public String updateRetailer(@RequestBody Retailer rs)
//    {
//        return retailerService.updateRetailer(rs);
//    }
//
//    @DeleteMapping("/deleteRetailer/{retailerId}")
//    public String deleteRetailer(@PathVariable int retailerId)
//    {
//        return retailerService.deleteRetailer(retailerId);
//    }

//    @PutMapping("/allocateRetailer/{retailerId}/{wholeSalerId}/{productId}/{itemCountToBuy}")
//    public String allocateRetailer(@PathVariable int retailerId,@PathVariable int wholeSalerId,@PathVariable int productId,@PathVariable int itemCountToBuy){
//        return retailerService.allocateRetailer(retailerId,wholeSalerId,productId,itemCountToBuy);
//    }

}
