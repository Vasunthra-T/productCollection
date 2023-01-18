package com.quinbay.product.service;

import com.quinbay.product.model.Product;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Service
public class ProductService {
    static ArrayList<Product> products = new ArrayList<>();

    public static void Service() { //To load csv data into array list
        try {
            String line = "";
            String splitBy = ",";
            BufferedReader sc1 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Product.csv"));
            while ((line = sc1.readLine()) != null) // returns a Boolean value
            {
                String[] productSplit = line.split(splitBy); // use comma as separator
                products.add(new Product(Integer.parseInt(productSplit[0]), productSplit[1],
                        Integer.parseInt(productSplit[2]), Integer.parseInt(productSplit[3])));
            }
            sc1.close();


        } catch (Exception e) {

        }
    }

    //Add new product to products arraylist
    public static String addProduct(ArrayList<Product> inputProducts) {
        for(Product input:inputProducts) {


            Product newProduct = new Product(input.getId(), input.getName(), input.getPrice(), input.getStock());
            products.add(newProduct);
        }

        String str = "";
        for (Product p : products) {
            str += p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getStock() + "\n";
        }
        return str;
    }
    public static String updateProduct(Product inputProduct){
            for (Product pr : products) {
                if (inputProduct.getId() == pr.getId()) {
                    pr.setStock(inputProduct.getStock());
                }
            }

            return "Product updated";
        }

    public static String deleteProduct(int productId) {
            int count = 0;
            int delIndex =0;
            boolean flag=false;
            for (Product pr : products) {
                if (productId == pr.getId()) {
                    System.out.println(pr.getId());
                    delIndex=count;
                    flag=true;
                }
                count++;

            }
            if(flag==true) {
                products.remove(delIndex);
            }

            String str = "";
            for (Product p : products) {
                str += p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getStock() + "\n";
            }

            return str;


    }
    public static ArrayList<Product> getAllProducts()
    {
        return products;
    }
}
