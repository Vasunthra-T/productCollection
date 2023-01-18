package com.quinbay.product.controller;

import com.quinbay.product.model.Product;
import com.quinbay.product.service.ProductDetails;
import com.quinbay.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductDetails productDetails;

    @GetMapping("/loadData")
    public String loadData(){
        productService.Service();
        return "Data loaded";
    }

    @GetMapping("/displayProduct/{productId}")
    public String viewProduct(@PathVariable int productId)
    {
        //pr.Service();
        return productDetails.getDetails(productId);
    }
    @GetMapping("/getAllProducts")
    public ArrayList<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }
    @PostMapping("/addProduct")
    public String postData(@RequestBody ArrayList<Product> inputProduct)
    {
        return productService.addProduct(inputProduct);
    }
    @PostMapping("/updateProduct")
    public String updateProduct(@RequestBody Product inputProduct)
    {
        return productService.updateProduct(inputProduct);
    }
    @DeleteMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId)
    {
        return productService.deleteProduct(productId);
    }

}
