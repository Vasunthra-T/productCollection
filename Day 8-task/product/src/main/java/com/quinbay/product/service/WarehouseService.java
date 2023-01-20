//package com.quinbay.product.service;
//
//import com.quinbay.product.model.Product;
//import com.quinbay.product.model.Warehouse;
//import com.quinbay.product.repository.ProductRepository;
//import com.quinbay.product.repository.WarehouseRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//@Service
//public class WarehouseService implements WarehouseInterface{
//    @Autowired
//    WarehouseRepository warehouseRepository;
//
//    @Override
//    public ArrayList<Warehouse> findAllWarehouse() {
//        return (ArrayList<Warehouse>) warehouseRepository.findAll();
//    }
//
//    @Override
//    public Warehouse findAllWarehouseByID(int id) {
//        Optional<Warehouse> opt = warehouseRepository.findById(id);
//        if (opt.isPresent())
//            return opt.get();
//        else
//            return null;
//    }
//
//    @Override
//    public String addWarehouse(ArrayList<Warehouse> inputWarehouse) {
//        for (Warehouse w : inputWarehouse) {
//            Warehouse warehouse = new Warehouse(w.getId(), w.getWcode(), w.getWname());
//            warehouseRepository.save(warehouse);
//        }
//        return "Warehouse added";
//    }
//
//    @Override
//    public void deleteAllWarehouse() {
//        warehouseRepository.deleteAll();
//    }
//
//    @Override
//    public Map<String, Boolean> deleteWarehouseById(int id) {
//        Map<String, Boolean> response = new HashMap<>();
//
//        try {
//            Optional<Warehouse> warehouse = warehouseRepository.findById(id);
//            if (warehouse != null) {
//
//                warehouseRepository.deleteById(id);
//                response.put("deleted", Boolean.TRUE);
//            } else {
//                response.put("deleted", Boolean.FALSE);
//            }
//            return response;
//        } catch (Exception e) {
//            response.put("deleted", Boolean.FALSE);
//            return response;
//        }
//
//    }
//    @Override
//    public String updateWarehouse( int id,int price)
//    {
//        Optional<Product> opt = warehouseRepository.findById(id);
//        if (opt.isPresent())
//        {
//            opt.get().setPrice(price);
//            productRepository.save(opt.get());
//            return "Product data updated successfully";
//        }
//        return "Product id doesn't exist";
//    }
//}
