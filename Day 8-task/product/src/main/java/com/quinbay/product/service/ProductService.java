package com.quinbay.product.service;

import com.quinbay.product.kafka.KafkaPublishingService;
import com.quinbay.product.model.Product;
import com.quinbay.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;



@Service
public class ProductService implements ProductInterface {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    KafkaPublishingService kafkaPublishingService;

//    @Autowired
//    Product product;

    @Override
    public ArrayList<Product> findAllProduct() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    @Override
    public ResponseEntity<Product> findAllProductByID(int id) {
        Optional<Product> opt = productRepository.findById(id);
        kafkaPublishingService.productInfo(opt.get());
        if (opt.isPresent())
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);

        else
            return new ResponseEntity<>(opt.get(), HttpStatus.NOT_FOUND);

    }

    @Override
    public String addProduct(ArrayList<Product> inputProduct) {
        for (Product p : inputProduct) {
            Product products = new Product(p.getId(), p.getPcode(), p.getName(), p.getPrice(), p.getGst());
            productRepository.save(products);
        }
        return "Product added";
    }

    @Override
    public void deleteAllData() {
        productRepository.deleteAll();
    }

    @Override
    public Map<String, Boolean> deleteProductById(int id) {
        Map<String, Boolean> response = new HashMap<>();

        try {
            Optional<Product> product = productRepository.findById(id);
            if (product != null) {

                productRepository.deleteById(id);
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
    @Override
    public String updateProduct( int id,int price)
    {
        Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent())
        {
            opt.get().setPrice(price);
            productRepository.save(opt.get());
            return "Product data updated successfully";
        }
        return "Product id doesn't exist";
    }
//    @Override
//    public String updateProduct(Product product,int id) {
//        Optional<Product> productData = productRepository.findById(id);
//
//        if (productData.isPresent()) {
//            Product _product = productData.get();
//            _product.setPrice(product.getPrice());
//            _product.setName(product.getName());
//            _product.setPcode(product.getPcode());
//            _product.setGst(product.getGst());
//
//            return "Product updated";
//        } else {
//            return "Product is not present";
//        }
//    }

//    @Override
//    public String updateProduct(Product product,int id){
//        Optional<Product> opt = productRepository.findById(id);
//        if (opt.isPresent())
//            opt.get().setPrice(product.getPrice());
//
//        productRepository.save(opt.get());
//        opt.get().setId(product.getId());
//
//        productRepository.save(opt.get());
//        opt.get().setGst(product.getGst());
//
//        productRepository.save(opt.get());
//        opt.get().setName(product.getName());
//        productRepository.save(opt.get());
//        return "Product updated";
//    }

//    }
}
//public class ProductService {
//    static ArrayList<Product> products = new ArrayList<>();
//
//    public static void Service() { //To load csv data into array list
//        try {
//            String line = "";
//            String splitBy = ",";
//            BufferedReader sc1 = new BufferedReader(new FileReader("/Users/vasunthra/Documents/training/GST/src/Product.csv"));
//            while ((line = sc1.readLine()) != null) // returns a Boolean value
//            {
//                String[] productSplit = line.split(splitBy); // use comma as separator
//
//                products.add(new Product(Integer.parseInt(productSplit[0]), productSplit[1],
//                        Integer.parseInt(productSplit[2]), Integer.parseInt(productSplit[3]),Integer.parseInt(productSplit[4])));
//            }
//            sc1.close();
//
//
//        } catch (Exception e) {
//
//        }
//    }
//
//    //Add new product to products arraylist
//    public static String addProduct(ArrayList<Product> inputProducts) {
//        for(Product input:inputProducts) {
//            Product newProduct = new Product(input.getId(), input.getName(), input.getPrice(), input.getStock(),input.getGst());
//            products.add(newProduct);
//        }
//
//        String str = "";
//        for (Product p : products) {
//            str += p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getStock() + "\n";
//        }
//        return str;
//    }
//    public static String updateProduct(Product inputProduct){
//            for (Product pr : products) {
//                if (inputProduct.getId() == pr.getId()) {
//                    pr.setStock(inputProduct.getStock());
//                }
//            }
//
//            return "Product updated";
//        }
//
//    public static String deleteProduct(int productId) {
//            int count = 0;
//            int delIndex =0;
//            boolean flag=false;
//            for (Product pr : products) {
//                if (productId == pr.getId()) {
//                    System.out.println(pr.getId());
//                    delIndex=count;
//                    flag=true;
//                }
//                count++;
//
//            }
//            if(flag==true) {
//                products.remove(delIndex);
//            }
//
//            String str = "";
//            for (Product p : products) {
//                str += p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getStock() +" "+p.getGst()+ "\n";
//            }
//
//            return str;
//
//
//    }
//    public static ArrayList<Product> getProducts()
//    {
//        return products;
//    }
//}
