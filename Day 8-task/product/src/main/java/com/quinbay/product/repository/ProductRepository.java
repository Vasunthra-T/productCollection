package com.quinbay.product.repository;

import com.quinbay.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
  // ArrayList<Product> findAllProduct();

}
