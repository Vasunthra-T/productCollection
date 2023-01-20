package com.quinbay.wholesaler.controller;

import com.quinbay.wholesaler.model.Product;
import com.quinbay.wholesaler.model.Wholesaler;
//import com.quinbay.wholesaler.service.WholeSalerDetails;
import com.quinbay.wholesaler.service.WholesalerService;
import com.quinbay.wholesaler.web.client.WebClientAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class WholesalerController {
    @Autowired
    WholesalerService wholesalerService;

    @PostMapping("/addWholesaler")
    public String postData(@RequestBody ArrayList<Wholesaler> inputWholesaler)
    {
        return wholesalerService.addWholesaler(inputWholesaler);
    }
    @GetMapping("/findall")
    public ArrayList<Wholesaler> getAllWholesaler() {
        return wholesalerService.findAllWholesaler();
    }

    @GetMapping("/findbyid/{id}")
    public Wholesaler getWholesalerUsingId(@PathVariable int id) {
        return wholesalerService.findWholesalerByID(id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public Map<String, Boolean> deleteWholesalerUsingId(@PathVariable(value = "id") Integer id){
        return wholesalerService.deleteWholesalerById(id);
    }

    @DeleteMapping("/delete")
    public void delete() {
        wholesalerService.deleteAllData();
    }

//    @Autowired
//    WholesalerService wholesalerService;
//    @Autowired
//    WholeSalerDetails wholeSalerDetails;
//
//    @GetMapping("/loadData")
//    public String loadData(){
//        wholesalerService.Service();
//        return "Data loaded";
//    }
//
//    @GetMapping("/displayWholeSaler/{wholeSalerId}")
//    public String viewProduct(@PathVariable int wholeSalerId)
//    {
//        //pr.Service();
//        return wholeSalerDetails.getDetails(wholeSalerId);
//    }
//    @PostMapping("/addWholeSaler")
//    public String postData(@RequestBody ArrayList<Wholesaler> inputWholeSaler)
//    {
//        return wholesalerService.addWholeSaler(inputWholeSaler);
//    }
//    @PostMapping("/updateWholeSaler")
//    public String updateWholeSaler(@RequestBody Wholesaler ws)
//    {
//        return wholesalerService.updateWholeSaler(ws);
//    }
//
//    @DeleteMapping("/deleteWholeSaler/{wholeSalerId}")
//    public String deleteWholeSaler(@PathVariable int wholeSalerId)
//    {
//        return wholesalerService.deleteWholesaler(wholeSalerId);
//    }
//
//    @PutMapping("/allocateWholeSaler/{wholeSalerId}/{productId}/{itemCountToBuy}")
//    public String allocateWholeSaler(@PathVariable int wholeSalerId,@PathVariable int productId,@PathVariable int itemCountToBuy){
//        return wholesalerService.allocateWholesaler(wholeSalerId,productId,itemCountToBuy);
//    }
//
//    @GetMapping("/getWholesaler")
//    public ArrayList<Wholesaler> getWholesaler()
//    {
//        return wholesalerService.getWholesaler();
//    }

}
