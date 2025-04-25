package com.discount.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.discount.domain.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}