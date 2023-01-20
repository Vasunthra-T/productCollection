package com.quinbay.wholesaler.service;

import com.quinbay.wholesaler.model.Product;
import com.quinbay.wholesaler.model.Wholesaler;
import com.quinbay.wholesaler.repository.WholesalerRepository;
import com.quinbay.wholesaler.web.client.WebClientAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

@Service
public class WholesalerService implements WholesalerInterface {
    @Autowired
    WholesalerRepository wholesalerRepository;


    @Override
    public ArrayList<Wholesaler> findAllWholesaler() {
        return (ArrayList<Wholesaler>) wholesalerRepository.findAll();
    }

    @Override
    public Wholesaler findWholesalerByID(int id) {
        Optional<Wholesaler> opt = wholesalerRepository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public String addWholesaler(ArrayList<Wholesaler> inputWholesaler) {
        Wholesaler wholesaler = new Wholesaler(inputWholesaler.get(0).getId(), inputWholesaler.get(0).getWhcode(), inputWholesaler.get(0).getWhname());
        wholesalerRepository.save(wholesaler);
        return "Wholesaler added";
    }

    @Override
    public void deleteAllData() {
        wholesalerRepository.deleteAll();
    }

    @Override
    public Map<String, Boolean> deleteWholesalerById(int id) {
        Map<String, Boolean> response = new HashMap<>();

        try {

            Optional<Wholesaler> wholesaler = wholesalerRepository.findById(id);
            if (wholesaler != null) {

                wholesalerRepository.deleteById(id);
                response.put("deleted", Boolean.TRUE);
            } else {
                response.put("deleted", Boolean.FALSE);
            }
            return response;
        } catch (Exception e) {
            response.put("deleted", Boolean.FALSE);
            return response;

        }

    }
}
//    @Autowired
//    WebClientAPI webClientAPI;
//    static ArrayList<Wholesaler> wholesaler_details = new ArrayList<>();
//
//    public static void Service() { //To load csv data into array list
//
//        try {
//            String line = "";
//            String splitBy = ",";
//
//
//            BufferedReader sc2 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Wholesaler.csv"));
//            while ((line = sc2.readLine()) != null) {
//                String[] productSplit = line.split(splitBy);
//                wholesaler_details.add(new Wholesaler(Integer.parseInt(productSplit[0]), productSplit[1]));
//            }
//            sc2.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    //Add new wholesaler to wholesaler arraylist
//    public static String addWholeSaler(ArrayList<Wholesaler> inputWholeSaler) {
//        for (Wholesaler input : inputWholeSaler) {
//            int flag = 0;
//            for (Wholesaler ws : wholesaler_details) {
//                if (input.getWholesaler_id() == ws.getWholesaler_id()) {
//                    flag = 1;
//                }
//            }
//            if (flag == 0) {
//                Wholesaler newWholeSaler = new Wholesaler(input.getWholesaler_id(), input.getWholesaler_name());
//                wholesaler_details.add(newWholeSaler);
//            }
//        }
//        String str = "";
//        for (Wholesaler ws : wholesaler_details) {
//            str += ws.getWholesaler_id() + " " + ws.getWholesaler_name() + "\n";
//        }
//        return str;
//    }
//
//    public static String deleteWholesaler(int wholeSalerId){
//        int count = 0;
//        int delIndex =0;
//        boolean flag=false;
//        for (Wholesaler wl : wholesaler_details) {
//            if(wholeSalerId == wl.getWholesaler_id()) {
//                System.out.println(wl.getWholesaler_id());
//                delIndex=count;
//                flag=true;
//            }
//            count++;
//
//        }
//        if(flag==true) {
//            wholesaler_details.remove(delIndex);
//        }
//
//        String str = "";
//        for (Wholesaler w : wholesaler_details) {
//            str += w.getWholesaler_id()+w.getWholesaler_name()  + "\n";
//        }
//
//        return str;
//    }
//    public static String updateWholeSaler(Wholesaler inputWholeSaler){
//        for (Wholesaler ws : wholesaler_details) {
//            if (inputWholeSaler.getWholesaler_id() == ws.getWholesaler_id()) {
//                ws.setWholesaler_name(inputWholeSaler.getWholesaler_name());
//            }
//        }
//
//        return "Product updated";
//    }
//
//    //Allocate product to wholesaler according to product id and wholesaler id
//    public  String allocateWholesaler(int wholeSalerId, int productId, int itemCountToBuy) {
//       // System.out.println(wholesaler_details.get(0).getWholesaler_name());
//      //LinkedHashMap<String,String> lmap =         webClientAPI.getAllProducts();
//       Product[] products= webClientAPI.getProducts();
//       // System.out.println(products);
//        for (Wholesaler eachWholesaler : wholesaler_details) {
//            if (eachWholesaler.getWholesaler_id() == wholeSalerId) {
//                for (Product eachProduct : products) {
//                    if (eachProduct.getStock() >= itemCountToBuy && itemCountToBuy > 0) {
//                        if (eachProduct.getId() == productId) {
//                            if (eachWholesaler.wholesaler_product_list.size() == 0) {
//                                Product newProduct = new Product(eachProduct.getId(), eachProduct.getName(),
//                                        eachProduct.getPrice(), itemCountToBuy);
//                                eachWholesaler.setWholesaler_product_list(newProduct);
//                                eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
//                                webClientAPI.updateProduct(eachProduct);
//                                System.out.println("Product added to wholesaler");
//                            } else {
//                                int flag = 0;
//                                for (Product checkProduct : eachWholesaler.wholesaler_product_list) {
//                                    if (checkProduct.getId() == productId) {
//                                        checkProduct.setStock(checkProduct.getStock() + itemCountToBuy);
//                                        eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
//                                        webClientAPI.updateProduct(eachProduct);
//
//                                        System.out.println("Product added to wholesaler");
//
//                                        flag = 1;
//                                    }
//                                    if (flag == 0) {
//                                        Product newProduct = new Product(eachProduct.getId(), eachProduct.getName(),
//                                                eachProduct.getPrice(), itemCountToBuy);
//                                        eachWholesaler.setWholesaler_product_list(newProduct);
//                                        eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
//                                        webClientAPI.updateProduct(eachProduct);
//
//                                        System.out.println("Product added to wholesaler");
//                                        break;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//       // webClientAPI.updateProduct(products);
//        return "Wholesaler allocated";
//    }
//
//    public static ArrayList<Wholesaler> getWholesaler()
//    {
//        return wholesaler_details;
//    }





