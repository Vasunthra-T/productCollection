package com.quinbay.retailer.repository;

import com.quinbay.retailer.model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer,Integer> {
   // ArrayList<Retailer> findAllRetailer();

}
