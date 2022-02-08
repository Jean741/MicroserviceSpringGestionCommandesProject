package com.ondev.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ondev.product.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}