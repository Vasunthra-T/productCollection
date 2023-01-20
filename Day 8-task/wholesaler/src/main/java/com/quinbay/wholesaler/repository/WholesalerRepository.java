package com.quinbay.wholesaler.repository;

import com.quinbay.wholesaler.model.Wholesaler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WholesalerRepository extends JpaRepository<Wholesaler,Integer> {
   // ArrayList<Wholesaler> findAllWholesaler();
}
