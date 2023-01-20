package com.quinbay.retailer.service;

import com.quinbay.retailer.model.Retailer;
import com.quinbay.retailer.repository.RetailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RetailerService implements RetailerInterface{
    @Autowired
    RetailerRepository retailerRepository;

//    @Autowired
//    Product product;

    @Override
    public ArrayList<Retailer> findAllRetailer() {
        return (ArrayList<Retailer>) retailerRepository.findAll();
    }

    @Override
    public Retailer findRetailerByID(int id) {
        Optional<Retailer> opt = retailerRepository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public String addRetailer(ArrayList<Retailer> inputRetailer) {
        Retailer retailer = new Retailer(inputRetailer.get(0).getId(), inputRetailer.get(0).getRcode(), inputRetailer.get(0).getRname());
        retailerRepository.save(retailer);
        return "Retailer added";
    }

    @Override
    public void deleteAllData() {
        retailerRepository.deleteAll();
    }

    @Override
    public Map<String, Boolean> deleteRetailerById(int id) {
        Map<String, Boolean> response = new HashMap<>();

        try {

            Optional<Retailer> product = retailerRepository.findById(id);
            if (product != null) {

                retailerRepository.deleteById(id);
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
//    static ArrayList<Retailer> retailer_details = new ArrayList<>();
//
//    public static void Service() { //To load csv data into array list
//
//        try {
//            String line = "";
//            String splitBy = ",";
//
//            BufferedReader sc2 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Retailer.csv"));
//            while ((line = sc2.readLine()) != null) {
//                String[] productSplit = line.split(splitBy);
//                retailer_details.add(new Retailer(Integer.parseInt(productSplit[0]), productSplit[1]));
//            }
//            sc2.close();
//        } catch (Exception e) {
//
//        }
//    }
//
//    //Add new retailer to retailer arraylist
//    public static String addRetailer(ArrayList<Retailer> inputRetailer) {
//        for (Retailer input : inputRetailer) {
//            int flag = 0;
//            for (Retailer rs : retailer_details) {
//                if (input.getRetailer_id() == rs.getRetailer_id()) {
//                    flag = 1;
//                }
//            }
//            if (flag == 0) {
//                Retailer newRetailer = new Retailer(input.getRetailer_id(), input.getRetailer_name());
//                retailer_details.add(newRetailer);
//            }
//        }
//        String str = "";
//        for (Retailer rs : retailer_details) {
//            str += rs.getRetailer_id() + " " + rs.getRetailer_name() + "\n";
//        }
//        return str;
//    }
//
//    public static String deleteRetailer(int retailerId) {
//        int count = 0;
//        int delIndex = 0;
//        boolean flag = false;
//        for (Retailer rl : retailer_details) {
//            if (retailerId == rl.getRetailer_id()) {
//                System.out.println(rl.getRetailer_id());
//                delIndex = count;
//                flag = true;
//            }
//            count++;
//        }
//        if (flag == true) {
//            retailer_details.remove(delIndex);
//        }
//        String str = "";
//        for (Retailer r : retailer_details) {
//            str += r.getRetailer_id() + r.getRetailer_name() + "\n";
//        }
//        return str;
//    }
//
//    public static String updateRetailer(Retailer inputRetailer) {
//        for (Retailer rs : retailer_details) {
//            if (inputRetailer.getRetailer_id() == rs.getRetailer_id()) {
//                rs.setRetailer_name(inputRetailer.getRetailer_name());
//            }
//        }
//
//        return "Product updated";
//    }

    //Allocate wholesaler product to retailer product according to product id , wholesaler id and retailer id
//    public  void allocateRetailer(int retailerId, int wholeSalerId, int productId, int itemCountToBuy) {
//        for (Retailer re : retailer_details) {
//            if (re.getRetailer_id() == retailerId) {
//    Product[] wholesaler_list= webClientAPI.getWholesaler();
//
//                for (Wholesaler ws : wholesaler_details) {
//                    if (ws.getWholesaler_id() == wholeSalerId) {
//                        for (Product pr : ws.wholesaler_product_list) {
//                            if (pr.getId() == productId) {
//                                if (pr.getStock() >= itemCountToBuy && itemCountToBuy > 0) {
//                                    if (re.retailer_product_list.size() == 0) {
//                                        Product newProduct = new Product(pr.getId(), pr.getName(),
//                                                pr.getPrice(), itemCountToBuy);
//                                        re.setRetailerProductList(newProduct);
//                                        pr.setStock(pr.getStock() - itemCountToBuy);
//                                        System.out.println("Product added to retailer");
//                                    } else {
//                                        int flag = 0;
//                                        for (Product checkProduct : re.retailer_product_list) {
//                                            if (checkProduct.getId() == productId) {
//                                                checkProduct.setStock(checkProduct.getStock() + itemCountToBuy);
//                                                pr.setStock(pr.getStock() - itemCountToBuy);
//                                                flag = 1;
//                                                System.out.println("Product added to retailer");
//                                            }
//                                            if (flag == 0) {
//                                                Product newProduct = new Product(pr.getId(), pr.getName(),
//                                                        pr.getPrice(), itemCountToBuy);
//                                                re.setRetailerProductList(newProduct);
//                                                pr.setStock(pr.getStock() - itemCountToBuy);
//                                                System.out.println("Product added to retailer");
//                                                break;
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }






