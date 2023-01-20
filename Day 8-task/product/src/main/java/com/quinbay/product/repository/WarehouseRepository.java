package com.quinbay.product.repository;

import com.quinbay.product.model.Product;
import com.quinbay.product.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
}
