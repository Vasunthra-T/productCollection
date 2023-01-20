package com.quinbay.product.controller;

import com.quinbay.product.model.Product;
import com.quinbay.product.model.Warehouse;
import com.quinbay.product.service.ProductService;
//import com.quinbay.product.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class WarehouseController {
//    @Autowired
//    WarehouseService warehouseService;

//    @PostMapping("/addWarehouse")
//    public String postData(@RequestBody ArrayList<Warehouse> inputWarehouse)
//    {
//        //return warehouseService.addWarehouse(inputWarehouse);
//    }
//
//    @GetMapping("/findallWarehouse")
//    public ArrayList<Warehouse> getAllWarehouse() {
//       // return warehouseService.findAllWarehouse();
//    }
//
//    @GetMapping("/findbywid/{wid}")
//    public Warehouse getWarehouseUsingId(@PathVariable int wid) {
//       // return warehouseService.findAllWarehouseByID(wid);
//    }
//
//    @DeleteMapping("/deletebywid/{wid}")
//    public Map<String, Boolean> deleteWarehouseUsingId(@PathVariable(value = "id") Integer id){
//        return warehouseService.deleteWarehouseById(id);
//    }
//
//    @DeleteMapping("/delete")
//    public void delete() {
//        warehouseService.deleteAllData();
//    }
//
//    @PutMapping("/update/{id}/{wname}")
//    public String updateWarehouse( @PathVariable int id,@PathVariable String wname) {
//        return warehouseService.updateWarehouse(id,wname);
//    }
}
