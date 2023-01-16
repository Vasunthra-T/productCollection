package com.quinbay.spring_artifact.service;

import org.springframework.stereotype.Service;
import  com.quinbay.spring_artifact.model.*;



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;



@Service
public class ProductService {
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Wholesaler> wholesaler_details = new ArrayList<>();
    static ArrayList<Retailer> retailer_details = new ArrayList<>();

    public static void Service() {

        try {
            String line = "";
            String splitBy = ",";
            BufferedReader sc1 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Product.csv"));
            while ((line = sc1.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                // System.out.println("Product ID=" + productSplit[0] + ", Product Name=" + productSplit[1] + ", Price="
                //       + productSplit[2] + ", Stock=" + productSplit[3]);
                products.add(new Product(Integer.parseInt(productSplit[0]), productSplit[1],
                        Integer.parseInt(productSplit[2]), Integer.parseInt(productSplit[3])));
            }
            sc1.close();

            BufferedReader sc2 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Wholesaler.csv"));
            while ((line = sc2.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                //System.out.println("Product ID=" + productSplit[0] + ", Product Name=" + productSplit[1]);
                wholesaler_details.add(new Wholesaler(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc2.close();

            BufferedReader sc3 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Retailer.csv"));
            while ((line = sc3.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                //System.out.println("Product ID=" + productSplit[0] + ", Product Name=" + productSplit[1]);
                retailer_details.add(new Retailer(Integer.parseInt(productSplit[0]), productSplit[1]));
            }
            sc3.close();
        } catch (Exception e) {

        }
    }

        public static void allocateWholesaler ( int wholeSalerId, int productId, int itemCountToBuy){
            for (Wholesaler eachWholesaler : wholesaler_details) {
                if (eachWholesaler.getWholesaler_id() == wholeSalerId) {
                    for (Product eachProduct : products) {
                        if (eachProduct.getStock() >= itemCountToBuy && itemCountToBuy > 0) {
                            if (eachProduct.getId() == productId) {
                                if (eachWholesaler.wholesaler_product_list.size() == 0) {
                                    Product newProduct = new Product(eachProduct.getId(), eachProduct.getName(),
                                            eachProduct.getPrice(), itemCountToBuy);
                                    eachWholesaler.setWholesaler_product_list(newProduct);
                                    eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
                                    System.out.println("Product added to wholesaler");
                                } else {
                                    int flag = 0;
                                    for (Product checkProduct : eachWholesaler.wholesaler_product_list) {
                                        if (checkProduct.getId() == productId) {
                                            checkProduct.setStock(checkProduct.getStock() + itemCountToBuy);
                                            eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
                                            System.out.println("Product added to wholesaler");

                                            flag = 1;
                                        }
                                        if (flag == 0) {
                                            Product newProduct = new Product(eachProduct.getId(), eachProduct.getName(),
                                                    eachProduct.getPrice(), itemCountToBuy);
                                            eachWholesaler.setWholesaler_product_list(newProduct);
                                            eachProduct.setStock(eachProduct.getStock() - itemCountToBuy);
                                            System.out.println("Product added to wholesaler");

                                            break;
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("Warehouse doesn't have enough stock to deliver");
                        }
                    }
                }
            }
        }

        public static void allocateRetailer ( int retailerId, int wholeSalerId, int productId, int itemCountToBuy){
            for (Retailer re : retailer_details) {
                if (re.getRetailer_id() == retailerId) {
                    for (Wholesaler ws : wholesaler_details) {
                        if (ws.getWholesaler_id() == wholeSalerId) {
                            for (Product pr : ws.wholesaler_product_list) {
                                if (pr.getId() == productId) {
                                    if (pr.getStock() >= itemCountToBuy && itemCountToBuy > 0) {
                                        if (re.retailer_product_list.size() == 0) {
                                            Product newProduct = new Product(pr.getId(), pr.getName(),
                                                    pr.getPrice(), itemCountToBuy);
                                            re.setRetailerProductList(newProduct);
                                            pr.setStock(pr.getStock() - itemCountToBuy);
                                            System.out.println("Product added to retailer");

                                        } else {
                                            int flag = 0;
                                            for (Product checkProduct : re.retailer_product_list) {
                                                if (checkProduct.getId() == productId) {
                                                    checkProduct.setStock(checkProduct.getStock() + itemCountToBuy);
                                                    pr.setStock(pr.getStock() - itemCountToBuy);
                                                    flag = 1;
                                                    System.out.println("Product added to retailer");

                                                }
                                                if (flag == 0) {
                                                    Product newProduct = new Product(pr.getId(), pr.getName(),
                                                            pr.getPrice(), itemCountToBuy);
                                                    re.setRetailerProductList(newProduct);
                                                    pr.setStock(pr.getStock() - itemCountToBuy);
                                                    System.out.println("Product added to retailer");

                                                    break;
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("Wholesale dealer doesn't have enough stock to deliver");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public static String displayProduct ( int nameProduct){

            for (Product itr : products) {
                if (itr.getId() == nameProduct) {
                    return itr.getId()+" "+itr.getName()+" "+itr.getPrice()+" "+itr.getStock();

                }
            }
            return "No products found";
        }

        public  static String displayWholesaler ( int wholesalerId){
        //Service();
            String str="";
            for (Wholesaler itr : wholesaler_details) {
                if (itr.getWholesaler_id() == wholesalerId) {

                    str += itr.getWholesaler_id()+" "+itr.getWholesaler_name();
                    for(Product pr: itr.wholesaler_product_list)
                    {
                        str += " ("+pr.getId()+" "+pr.getName()+" "+pr.getPrice()+" "+pr.getStock()+") ";
                    }
                }
            }
            return str;
        }


    public  static String displayRetailer ( int retailerId){
        for (Retailer itr : retailer_details) {
            if (itr.getRetailer_id() == retailerId) {
                return itr.getRetailer_id()+" "+itr.getRetailer_name();
            }
        }
        return "No retailer found";
    }
    public static String addProduct(ArrayList<Product> inputProducts){
        for(Product input:inputProducts)
        {
            int flag =0;
            for(Product pr:products){
                if(input.getId() == pr.getId()){
                    pr.setStock(pr.getStock()+input.getStock());
                    flag = 1;
                }
            }
            if(flag==0){
                Product newProduct = new Product(input.getId(),input.getName(),input.getPrice(),input.getStock());
                products.add(newProduct);
            }
        }
        String str="";
        for(Product p:products){
            str+= p.getId()+" "+p.getName()+" "+p.getPrice()+" "+p.getStock()+"\n";
        }

        return str;
    }
    public static String addWholeSaler(ArrayList<Wholesaler> inputWholeSaler){
        for(Wholesaler input:inputWholeSaler)
        {
            int flag =0;
            for(Wholesaler ws:wholesaler_details){
                if(input.getWholesaler_id() == ws.getWholesaler_id()){
                    flag = 1;
                }
            }
            if(flag==0){
                Wholesaler newWholeSaler = new Wholesaler(input.getWholesaler_id(),input.getWholesaler_name());
                wholesaler_details.add(newWholeSaler);
            }
        }
        String str="";
        for(Wholesaler ws:wholesaler_details){
            str+= ws.getWholesaler_id()+" "+ws.getWholesaler_name()+"\n";
        }

        return str;
    }
    public static String addRetailer(ArrayList<Retailer> inputRetailer){
        for(Retailer input:inputRetailer)
        {
            int flag =0;
            for(Retailer rs:retailer_details){
                if(input.getRetailer_id() == rs.getRetailer_id()){
                    flag = 1;
                }
            }
            if(flag==0){
                Retailer newRetailer = new Retailer(input.getRetailer_id(),input.getRetailer_name());
                retailer_details.add(newRetailer);
            }
        }
        String str="";
        for(Retailer rs:retailer_details){
            str+= rs.getRetailer_id()+" "+rs.getRetailer_name()+"\n";
        }

        return str;
    }

    }



